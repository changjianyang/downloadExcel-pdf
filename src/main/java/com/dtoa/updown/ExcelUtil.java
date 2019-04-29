package com.dtoa.updown;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangchangjian
 * @version 1.0
 * @Description:
 * @datatime 2019/3/7 10:20
 */
@Component
public class ExcelUtil {

    public static void main(String[] args) {
        String path = "C:\\Users\\Desktop\\123.xls";
        boolean b = path.endsWith(".xls");
        System.out.println(b);
    }

    /**
     * @param out      reponse OutPutStream
     * @param fileName 文件名称
     * @param title    顶部标题
     * @param head     列名
     * @param content  值
     */
    public void getExport(OutputStream out, String fileName, String title, List<String> head, List<Map<Object, Object>> content) {
        // 1.创建Excel工作薄对象
        HSSFWorkbook wb = new HSSFWorkbook();
        // 2.创建Excel工作表对象
        HSSFSheet sheet = wb.createSheet(fileName);
        // 3.创建单元格
        // 4.设置单元格的样式
        //设置标题
        if (title != null) {
            CellRangeAddress address = new CellRangeAddress(0, 0, 0, head.size() - 1);
            sheet.addMergedRegion(address);
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(title);
        }
        //设置头部
        HSSFRow headRow = sheet.createRow(1);
        for (int i = 0; i < head.size(); i++) {
            HSSFCell cell = headRow.createCell(i);
            cell.setCellValue(head.get(i));
        }

        //添加内容
        for (int i = 0; i < content.size(); i++) {
            HSSFRow contentRow = sheet.createRow(i + 2);
            Map<Object, Object> objectMap = content.get(i);
            int k = 0;
            for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
                HSSFCell cell = contentRow.createCell(k);
                cell.setCellValue(entry.getValue().toString());
                k++;
            }


        }

        // 7.设置sheet名称和单元格内容
        wb.setSheetName(0, fileName);
        try {
            // 8.将Excel写入到输出流里面
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel
     *
     * @param filePath
     * @return List<Map>
     * @throws Exception
     */
    public static List<Map> readExcel(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        Boolean isXsl = filePath.endsWith(".xls");
        Boolean isXlsx = filePath.endsWith(".xls");
        if (!isXsl && !isXlsx) {
            return null;
        }
        //返回值列
        List<Map> reaultList = new ArrayList<>();
        if (isXsl) {
            reaultList = readExcel2003(filePath);
        }
        return reaultList;
    }

    /**
     * 读取97-2003格式
     *
     * @param filePath 文件路径
     * @throws java.io.IOException
     */
    public static List<Map> readExcel2003(String filePath) throws IOException {
        //返回结果集
        List<Map> valueList = new ArrayList<Map>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            HSSFWorkbook wookbook = new HSSFWorkbook(fis);  // 创建对Excel工作簿文件的引用
            HSSFSheet sheet = wookbook.getSheetAt(0);   // 在Excel文档中，第一张工作表的缺省索引是0
            int rows = sheet.getPhysicalNumberOfRows(); // 获取到Excel文件中的所有行数
            Map<Integer, String> keys = new HashMap<Integer, String>();
            int cells = 2;
            // 遍历行（第1行  表头） 准备Map里的key
            HSSFRow firstRow = sheet.getRow(1);
            if (firstRow != null) {
                // 获取到Excel文件中的所有的列
                cells = firstRow.getPhysicalNumberOfCells();
                // 遍历列
                for (int j = 0; j < cells; j++) {
                    // 获取到列的值
                    try {
                        HSSFCell cell = firstRow.getCell(j);
                        String cellValue = getCellValue(cell);
                        keys.put(j, cellValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            // 遍历行（从第二行开始）
            for (int i = 2; i < rows; i++) {
                // 读取左上端单元格(从第二行开始)
                HSSFRow row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    //准备当前行 所储存值的map
                    Map<String, Object> val = new HashMap<String, Object>();

                    boolean isValidRow = false;

                    // 遍历列
                    for (int j = 0; j < cells; j++) {
                        // 获取到列的值
                        try {
                            HSSFCell cell = row.getCell(j);
                            String cellValue = getCellValue(cell);
                            val.put(keys.get(j), cellValue);
                            if (!isValidRow && cellValue != null && cellValue.trim().length() > 0) {
                                isValidRow = true;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //第I行所有的列数据读取完毕，放入list
                    if (isValidRow) {
                        valueList.add(val);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
        }
        return valueList;
    }

    private static String getCellValue(HSSFCell cell) {
        DecimalFormat df = new DecimalFormat("#");
        String cellValue = null;
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                    break;
                }
                cellValue = df.format(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                cellValue = null;
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
        }
        if (cellValue != null && cellValue.trim().length() <= 0) {
            cellValue = null;
        }
        return cellValue;
    }

}