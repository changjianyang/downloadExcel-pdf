package com.dtoa.updown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangchangjian
 * @version 1.0
 * @Description:
 * @datatime 2019/3/7 10:18
 */
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private ExcelUtil excelUtil;

    @RequestMapping(value = "up")
    public Object upExcel() {
        try {
            List<Map> maps = ExcelUtil.readExcel("C:\\Users\\cjyan\\Desktop\\123.xls");
            return maps;
        } catch (Exception e) {
            System.out.println("发生异常");
        }
        return "异常";
    }

    @RequestMapping(value = "down")
    public void downExcel(HttpServletResponse response) {
        String fileName = "示例";
        try {
            response.setHeader("Content-type", "application/vnd.ms-excel");
            // 解决导出文件名中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xls");
            // 模板导出Excel
            List<String> head = new ArrayList<>();
            head.add("经纬度");
            head.add("打卡范围（米）");
            head.add("位置名");
            head.add("详细地址");
            List<Map<Object, Object>> content = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Map<Object, Object> map = new LinkedHashMap<>();
                map.put("a" + i, "12.12,12.22");
                map.put("b" + i, "50" + i);
                map.put("c" + i, "北京" + i);
                map.put("d" + i, "望京soho" + i);
                content.add(map);
            }
            String title = "1.经纬度使用gcj02坐标系，非专业人士请勿修改，若需要填写请使用腾讯地图坐标拾取器获取经纬度，网址为\nhttps://lbs.qq.com/tool/getpoint/\n2.打卡范围只能填写100、200或300";
            excelUtil.getExport(response.getOutputStream(), "示例", title, head, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
