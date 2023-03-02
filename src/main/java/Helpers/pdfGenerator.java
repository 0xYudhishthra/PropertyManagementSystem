package Helpers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfGenerator {

    public static boolean generatePDF(HashMap<Integer, HashMap<String, String>> data, String filepath) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 36, 36, 54, 54);

        // Create PDF writer instance in a specific path
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));

        // Define header and footer texts
        //the header will have a text called Property Management System Report, followed by a solid black line below it
        //the footer will first start with a solid black line, followed by the text Generated on followed by the date and time the report was generated
        String headerText = "Property Management System Report";
        String footerText = "Generated on " + new Date().toString();


        // Define header and footer fonts
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 20, Font.UNDERLINE, BaseColor.BLACK);
        Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE, BaseColor.BLACK);

        // Open document
        document.open();

        // Add header to document
        Paragraph headerParagraph = new Paragraph(headerText, headerFont);
        headerParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(headerParagraph);

        // Add blank line after header
        document.add(new Paragraph("\n\n"));

        // the data recevied would be someting like
        // lineNumber, {column1: value1, column2: value2, column3: value3}
        //the number of lines in the report will be determined by the number of lines in the data received
        //the number of columns in the report will be determined by the number of columns in the data received
        //we first construct the table with the number of columns and rows
        //stop comment here
        PdfPTable table = new PdfPTable(data.get(0).size());
        table.setWidthPercentage(100);

        //we then add the column names to the table, column names are in bold, adjust the header width to fit the column names
        for (String columnName : data.get(0).keySet()) {
            PdfPCell cell = new PdfPCell(new Phrase(columnName));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //set the width of the header to fit the column names
            table.addCell(cell);
        }

        //we then add the data to the table
        for (int lineNumber = 0; lineNumber < data.size(); lineNumber++) {
            for (String columnName : data.get(lineNumber).keySet()) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(lineNumber).get(columnName)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
        }

        // Add table to document
        document.add(table);

        // Add blank line after table
        document.add(new Paragraph("\n"));

        // Add footer to document
        Paragraph footerParagraph = new Paragraph(footerText, footerFont);
        footerParagraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(footerParagraph);

        // Close document
        document.close();
        return true;
    }
}

