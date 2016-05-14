package ru.kpfu.itis.khakov.service;

import com.itextpdf.text.*;
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
    private Font font;
    public String pdfCreate(MyCar myCar) throws DocumentException, IOException {
        String filename = "D:\\" + myCar.getCar().getManufacture().getManufacture() + "_" +
                myCar.getCar().getModel().getModel() + "(" + myCar.getDate() + ").pdf";
        Document document = new Document();
        String PATH = "D:\\Homework\\Sem1\\src\\main\\webapp\\WEB-INF\\resource\\fonts\\arial.ttf";
        BaseFont helvetica = BaseFont.createFont(PATH,"cp1251", BaseFont.EMBEDDED);
        font = new Font(helvetica, 10, Font.NORMAL);
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph(myCar.getCar().getManufacture().getManufacture()
                + " - " + myCar.getCar().getModel().getModel(), font));
        PdfPTable t = new PdfPTable(4);
        t.setSpacingBefore(25);
        t.setSpacingAfter(25);
        PdfPCell c1 = new PdfPCell(new Phrase("Марка авто", font));
        t.addCell(c1);
        PdfPCell c4 = new PdfPCell(new Phrase("Мощность",font));
        t.addCell(c4);
        PdfPCell c2 = new PdfPCell(new Phrase("цвет", font));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("цена в базовой комплектации", font));
        t.addCell(c3);
        t.addCell(new PdfPCell(new Phrase(myCar.getCar().getManufacture().getManufacture()
                + " - " + myCar.getCar().getModel().getModel(), font)));
        t.addCell(new PdfPCell(new Phrase(myCar.getCar().getModel().getMotor().getHorsepower() + " л.с", font)));
        t.addCell(new PdfPCell(new Phrase(myCar.getColor().getColorRu(), font)));
        t.addCell(new PdfPCell(new Phrase(myCar.getCar().getPrice() + "", font)));
        document.add(t);
        document.add(new Paragraph("дополнительное оборудование и цена на него", font));
        int price = myCar.getCar().getPrice();
        if (myCar.getAttributes() != null) {
            PdfPTable t2 = new PdfPTable(3);
            t2.setSpacingBefore(25);
            t2.setSpacingAfter(25);
            PdfPCell c11 = new PdfPCell(new Phrase("опция", font));
            t2.addCell(c11);
            PdfPCell c41 = new PdfPCell(new Phrase("описание", font));
            t2.addCell(c41);
            PdfPCell c21 = new PdfPCell(new Phrase("цена", font));
            t2.addCell(c21);
            int price_attr;
            for (Attribute attribute : myCar.getAttributes()) {
                t2.addCell( new PdfPCell(new Phrase(attribute.getName(), font)));
                t2.addCell( new PdfPCell(new Phrase(attribute.getDescription(), font)));
                price_attr = (int) (attribute.getPrice() * myCar.getCar().getKof());
                price += price_attr;
                t2.addCell(new PdfPCell(new Phrase(price_attr + "", font)));
            }
            document.add(t2);
        }
        document.add(new Paragraph("итоговая цена: " + price, font));
        document.close();
        return filename;
    }
}
