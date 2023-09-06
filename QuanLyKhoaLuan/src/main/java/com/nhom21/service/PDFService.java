/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom21.service;

import static com.itextpdf.io.font.FontConstants.TIMES_ROMAN;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nhom21.pojo.PDFInfor;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PDFService {
    public void export(HttpServletResponse response, List<PDFInfor> pdfInfor) throws IOException, DocumentException {
//        String fontPath = "src/main/resources/arial-unicode-ms.ttf";
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(TIMES_ROMAN);
        fontTitle.setSize(18);

        // Lấy thông tin của khóa luận từ đối tượng đầu tiên trong danh sách pdfInfor
        PDFInfor firstPDFInfor = pdfInfor.get(0);

        Paragraph paragraph = new Paragraph("Summary Report", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(TIMES_ROMAN);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("Thesis: " + firstPDFInfor.getThesisName(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
      
        Paragraph paragraph3 = new Paragraph("Leadership       ", fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_RIGHT);
        Paragraph paragraph4 = new Paragraph("(Signature, full name) ", fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_RIGHT);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{2.0f, 2.0f});
        table.setSpacingBefore(10);

        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
//        cell.setPhrase(new Phrase("", fontParagraph));
//        table.addCell(cell);

        cell.setPhrase(new Phrase("Defense Committee User", fontParagraph));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Score", fontParagraph));
        table.addCell(cell);

        // Viết dữ liệu cho bảng
        for (PDFInfor pdfInfo : pdfInfor) {
//            table.addCell(pdfInfo.getThesisName());
            table.addCell(pdfInfo.getUserDefenseFirstName() + " " + pdfInfo.getUserDefenseLastName());
            table.addCell(pdfInfo.getAvgScore().toString());
        }

        document.add(paragraph);
        document.add(paragraph2);
        
        document.add(table);
        document.add(paragraph3);
        document.add(paragraph4);
        document.close();
    }
}
