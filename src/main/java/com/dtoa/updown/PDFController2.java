package com.dtoa.updown;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
@RequestMapping(value = "pdf2")
public class PDFController2 {

    @RequestMapping(value = "down")
    public Object downPDF(HttpServletResponse response) {
        try {
            String jsonStr = "{\n" +
                    "    \"error_code\": 0,\n" +
                    "    \"msg\": \"成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"anonymousSign\": \"2\",\n" +
                    "        \"answerNum\": 0,\n" +
                    "        \"approvalId\": \"0\",\n" +
                    "        \"approvalStatus\": \"0\",\n" +
                    "        \"concludingRemarks\": \"问卷到此结束，感谢您的参与！\",\n" +
                    "        \"creatorId\": \"yzy\",\n" +
                    "        \"creatorName\": \"闫振瑛\",\n" +
                    "        \"describe\": \"不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查不知道是啥的问卷调查\",\n" +
                    "        \"endTime\": \"2019/12/30 10:56\",\n" +
                    "        \"id\": \"12ew12321ew213\",\n" +
                    "        \"questionList\": [\n" +
                    "            {\n" +
                    "                \"id\": \"qwe123\",\n" +
                    "                \"maxOption\": 1,\n" +
                    "                \"necessarySign\": \"1\",\n" +
                    "                \"optionList\": [\n" +
                    "                    \"一年\",\n" +
                    "                    \"两年\",\n" +
                    "                    \"三年\"\n" +
                    "                ],\n" +
                    "                \"orderNum\": 1,\n" +
                    "                \"questionType\": 1,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"randomSign\": \"1\",\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"你入公司多久了？\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": \"qwe124\",\n" +
                    "                \"maxOption\": 2,\n" +
                    "                \"necessarySign\": \"1\",\n" +
                    "                \"optionList\": [\n" +
                    "                    \"前端\",\n" +
                    "                    \"后端\",\n" +
                    "                    \"测试\",\n" +
                    "                    \"运维\"\n" +
                    "                ],\n" +
                    "                \"orderNum\": 2,\n" +
                    "                \"questionType\": 2,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"randomSign\": \"2\",\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"您目前的职位是？\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": \"qwe125\",\n" +
                    "                \"necessarySign\": \"1\",\n" +
                    "                \"optionList\": [\n" +
                    "                    \"下拉选项1\",\n" +
                    "                    \"下拉选项2\"\n" +
                    "                ],\n" +
                    "                \"orderNum\": 3,\n" +
                    "                \"questionType\": 3,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"下拉题\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": \"qwe126\",\n" +
                    "                \"necessarySign\": \"1\",\n" +
                    "                \"optionList\": [\n" +
                    "                    \"排序题项a\",\n" +
                    "                    \"排序题项b\",\n" +
                    "                    \"排序题项c\",\n" +
                    "                    \"排序题项d\",\n" +
                    "                    \"排序题项e\",\n" +
                    "                    \"排序题项f\"\n" +
                    "                ],\n" +
                    "                \"orderNum\": 4,\n" +
                    "                \"questionType\": 5,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"排序题\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": \"qwe127\",\n" +
                    "                \"necessarySign\": \"2\",\n" +
                    "                \"orderNum\": 5,\n" +
                    "                \"questionType\": 6,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"rowNumber\": 1,\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"单行文本\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": \"qwe128\",\n" +
                    "                \"necessarySign\": \"2\",\n" +
                    "                \"orderNum\": 6,\n" +
                    "                \"questionType\": 7,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"rowNumber\": 4,\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"多行文本\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"gaugeRange\": 5,\n" +
                    "                \"gaugeSign\": 1,\n" +
                    "                \"id\": \"qwe129\",\n" +
                    "                \"necessarySign\": \"1\",\n" +
                    "                \"orderNum\": 7,\n" +
                    "                \"questionType\": 4,\n" +
                    "                \"questionnaireId\": \"12ew12321ew213\",\n" +
                    "                \"textCheck\": \"chinese\",\n" +
                    "                \"title\": \"量表题\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"questionTotal\": 0,\n" +
                    "        \"questionnaireStatus\": 3,\n" +
                    "        \"readStatus\": 0,\n" +
                    "        \"startTime\": \"2019/12/30 10:56\",\n" +
                    "        \"title\": \"啥子问卷\"\n" +
                    "    }\n" +
                    "}";
            JSONObject questionar = JSON.parseObject(jsonStr);
            JSONObject data = questionar.getJSONObject("data");

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
            PdfPTable table = new PdfPTable(4);
            PdfPCell cell0 = new PdfPCell();
            cell0.setColspan(4);
            cell0.setPhrase(new Paragraph(data.getString("title"), font));
            cell0.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell0.setPaddingBottom(10);
            cell0.setBorderColor(BaseColor.WHITE);
            table.addCell(cell0);

            PdfPCell cell1 = new PdfPCell();
            cell1.setColspan(4);
            cell1.setPhrase(new Paragraph(data.getString("describe"), font));
            cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell1.setPaddingTop(10);
            cell1.setBorderColor(BaseColor.WHITE);
            table.addCell(cell1);

            JSONArray questionList = data.getJSONArray("questionList");
            PdfPTable table1 = new PdfPTable(4);
//            5	排序题
//            2
//            4	量表题
//            7	多行文本题
//            6	单行文本题
//            8	文本描述
//            3	下拉题
            for (int i = 1; i <= questionList.size(); i++) {
                JSONObject question = questionList.getJSONObject(i - 1);
                String questionType = question.getString("questionType");
                String title = question.getString("title");
                if (i < 10) {
                    title = "0" + i + title;
                }
                JSONArray optionList = question.getJSONArray("optionList");
                switch (questionType) {
                    case "1":
                        title = title + "单选题";
                        PdfPCell pdfPCell1 = addCell(title, font, 20);
                        table1.addCell(pdfPCell1);
                        for (int j = 0; j < optionList.size(); j++) {
                            PdfPCell pdfPCell = addCell(optionList.getString(j), font, 0);
                            table1.addCell(pdfPCell);
                        }
                        break;
                    case "2":
                        title = title + "多选题";
                        PdfPCell pdfPCell2 = addCell(title, font, 20);
                        table1.addCell(pdfPCell2);
                        optionList = question.getJSONArray("optionList");
                        for (int j = 0; j < optionList.size(); j++) {
                            PdfPCell pdfPCell = addCell(optionList.getString(j), font, 0);
                            table1.addCell(pdfPCell);
                        }
                        break;
                    case "3":
                        System.out.println("下拉题");
                        break;
                    case "4":
                        System.out.println("量表题");

                        break;
                    case "5":
                        title = title + "排序题";
                        PdfPCell pdfPCell3 = addCell(title, font, 20);
                        table1.addCell(pdfPCell3);
                        optionList = question.getJSONArray("optionList");
                        for (int j = 0; j < optionList.size(); j++) {
                            PdfPCell pdfPCell = addCell(optionList.getString(j), font, 0);
                            table1.addCell(pdfPCell);
                        }
                        break;
                    case "6":
                        title = title + "单行文本题";
                        PdfPCell pdfPCell = addCell(title, font, 20);
                        pdfPCell.setPaddingBottom(10);
                        table1.addCell(pdfPCell);
                        PdfPCell pdfPCell6 = addCell("", font, 20);
                        pdfPCell6.setBorderColor(BaseColor.BLACK);
                        pdfPCell6.setFixedHeight(20);
                        pdfPCell6.setBorderColorBottom(BaseColor.BLACK);
                        table1.addCell(pdfPCell6);
                        break;
                    case "7":
                        title = title + "多行文本题";
                        PdfPCell pdfPCell4 = addCell(title, font, 20);
                        pdfPCell4.setPaddingBottom(10);
                        table1.addCell(pdfPCell4);
                        PdfPCell pdfPCell7 = addCell("", font, 20);
                        pdfPCell7.setBorderColor(BaseColor.BLACK);
                        pdfPCell7.setFixedHeight(80);
                        pdfPCell7.setBorderColorBottom(BaseColor.BLACK);
                        table1.addCell(pdfPCell7);
                        break;
                    case "8":
                        title = title + "文本描述";
                        PdfPCell pdfPCell5 = addCell(title, font, 20);
                        table1.addCell(pdfPCell5);
                        break;
                    default:
                        System.out.println("默认了");
                }

            }
            //增加结尾
            PdfPCell concludingRemarks = addCell(data.getString("concludingRemarks"), font, 20);
            table1.addCell(concludingRemarks);
            document.add(table);
            document.add(table1);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
        return "ok";
    }

    public PdfPCell addCell(String param, Font font, Integer top) {
        PdfPCell cell = new PdfPCell();
        cell.setColspan(4);
        cell.setPhrase(new Paragraph(param, font));
        cell.setPaddingTop(top);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setMinimumHeight(10);
        cell.setBorderColor(BaseColor.WHITE);
        return cell;
    }
}
