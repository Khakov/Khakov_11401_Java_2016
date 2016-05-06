package ru.kpfu.itis.khakov.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.khakov.entity.Attribute;
import ru.kpfu.itis.khakov.entity.MyCar;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Rus on 06.05.2016.
 */
@Component
public class PdfCreator {
    public String pdfCreate(MyCar myCar) throws DocumentException, IOException {
        String filename = "D:\\" + myCar.getCar().getManufacture().getManufacture() + "_" +
                myCar.getCar().getModel().getModel() + "(" + myCar.getDate() + ").pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph(myCar.getCar().getManufacture().getManufacture()
                + " - " + myCar.getCar().getModel().getModel()));
        PdfPTable t = new PdfPTable(4);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);
        PdfPCell c1 = new PdfPCell(new Phrase("Марка авто"));
        t.addCell(c1);
        PdfPCell c4 = new PdfPCell(new Phrase("Мощность"));
        t.addCell(c4);
        PdfPCell c2 = new PdfPCell(new Phrase("цвет"));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("цена в базовой комплектации"));
        t.addCell(c3);
        t.addCell(myCar.getCar().getManufacture().getManufacture()
                + " - " + myCar.getCar().getModel().getModel());
        t.addCell(myCar.getCar().getModel().getMotor().getHorsepower() + " л.с");
        t.addCell(myCar.getColor().getColorRu());
        t.addCell(myCar.getCar().getPrice() + "");
        document.add(t);
        document.add(new Paragraph("дополнительное оборудование и цена на него"));
        int price = myCar.getCar().getPrice();
        if (myCar.getAttributes() != null) {
            PdfPTable t2 = new PdfPTable(3);
            t2.setSpacingBefore(25);
            t2.setSpacingAfter(25);
            PdfPCell c11 = new PdfPCell(new Phrase("опция"));
            t2.addCell(c11);
            PdfPCell c41 = new PdfPCell(new Phrase("описание"));
            t2.addCell(c41);
            PdfPCell c21 = new PdfPCell(new Phrase("цена"));
            t2.addCell(c21);
            int price_attr;
            for (Attribute attribute : myCar.getAttributes()) {
                t2.addCell(attribute.getName());
                t2.addCell(attribute.getDescription());
                price_attr = (int) (attribute.getPrice() * myCar.getCar().getKof());
                price += price_attr;
                t2.addCell(price_attr + "");
            }
            document.add(t2);
        }
        document.add(new Paragraph("итоговая цена: " + price));
        document.close();
        return filename;
    }
}
