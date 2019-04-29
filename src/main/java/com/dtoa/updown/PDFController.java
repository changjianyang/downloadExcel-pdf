package com.dtoa.updown;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yangchangjian
 * @version 1.0
 * @Description:
 * @datatime 2019/3/7 14:46
 */
@RestController
@RequestMapping(value = "pdf")
public class PDFController {

    @RequestMapping(value = "down")
    public Object downPDF(HttpServletResponse response) {
        try {

// 告诉浏览器用什么软件可以打开此文件
            response.setHeader("content-Type", "application/pdf;charset=UTF-8");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=user.pdf");

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            BaseFont baseFont = BaseFont.createFont("/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont);
            document.open();

            //第0行
            PdfPTable table0 = new PdfPTable(4);
            PdfPCell cell0 = new PdfPCell();
            cell0.setColspan(4);
            cell0.setPhrase(new Paragraph("aa的日志", font));
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            cell0.setPaddingBottom(10);
            cell0.setBorderColor(BaseColor.WHITE);
            table0.addCell(cell0);
            document.add(table0);

            //第一行
            PdfPTable table = new PdfPTable(4);
            PdfPCell cell = new PdfPCell();
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPhrase(new Paragraph("汇报时间", font));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("2019/01/01", font));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("模板名称", font));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("日报", font));
            table.addCell(cell);
            document.add(table);

            //第2行
            PdfPTable table2 = new PdfPTable(4);
            PdfPCell cell2 = new PdfPCell();
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell2.setPhrase(new Paragraph("汇报人", font));

            table2.addCell(cell2);
            document.add(table2);

            cell2 = new PdfPCell();
            cell2.setPhrase(new Paragraph("aa", font));
            table2.addCell(cell2);
            document.add(table2);

            cell2 = new PdfPCell();
            cell2.setPhrase(new Paragraph("汇报人部门", font));
            cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中

            table2.addCell(cell2);
            document.add(table2);

            cell2 = new PdfPCell();
            cell2.setPhrase(new Paragraph("公司", font));
            table2.addCell(cell2);
            document.add(table2);

            //第3行
            PdfPTable table3 = new PdfPTable(4);
            PdfPCell cell3 = new PdfPCell();
            cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell3.setPhrase(new Paragraph("汇报对象", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中

            table3.addCell(cell3);
            document.add(table3);

            cell3 = new PdfPCell();
            cell3.setColspan(3);
            cell3.setPhrase(new Paragraph("刘兵", font));
            table3.addCell(cell3);
            document.add(table3);

            //第4行
            PdfPTable table4 = new PdfPTable(4);
            PdfPCell cell4 = new PdfPCell();
            cell4.setColspan(4);
            cell4.setPhrase(new Paragraph("\n", font));
            table4.addCell(cell4);
            document.add(table4);

            //第5行
            PdfPTable table5 = new PdfPTable(4);
            PdfPCell cell5 = new PdfPCell();
            cell5.setColspan(4);
            cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell5.setPhrase(new Paragraph("汇报对象", font));
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中

            table5.addCell(cell5);
            document.add(table5);

            //第6行
            PdfPTable table6 = new PdfPTable(4);
            PdfPCell cell6 = new PdfPCell();
            cell6.setPhrase(new Paragraph("今日计划", font));
            cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中

            table6.addCell(cell6);
            document.add(table6);

            cell6 = new PdfPCell();
            cell6.setColspan(3);
            cell6.setPhrase(new Paragraph("好好学习", font));
            table6.addCell(cell6);
            document.add(table6);

            //第7行
            PdfPTable table7 = new PdfPTable(4);
            PdfPCell cell7 = new PdfPCell();
            cell7.setPhrase(new Paragraph("明日计划", font));
            cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table7.addCell(cell7);
            document.add(table7);

            cell7 = new PdfPCell();
            cell7.setColspan(3);
            cell7.setPhrase(new Paragraph("好好学习2", font));
            table7.addCell(cell7);
            document.add(table7);

            //第8行
            PdfPTable table8 = new PdfPTable(4);
            PdfPCell cell8 = new PdfPCell();
            cell8.setPhrase(new Paragraph("其他事项", font));
            cell8.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中
            table8.addCell(cell8);
            document.add(table8);

            cell8 = new PdfPCell();
            cell8.setColspan(3);
            cell8.setPhrase(new Paragraph("暂无", font));
            table8.addCell(cell8);
            document.add(table8);

            document.close();
        } catch (Exception e) {
            System.out.println("exception");
        }
        return "ok";
    }

}
