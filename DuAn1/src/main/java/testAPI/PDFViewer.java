/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFViewer extends JFrame {

    public PDFViewer(String filePath) {
        super("PDF Viewer");

        try {
            // Load PDF document
            PDDocument document = PDDocument.load(new File(filePath));

            // Create PDF renderer
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            // Get the number of pages in the PDF
            int pageCount = document.getNumberOfPages();

            // Display each page in a separate JLabel
            for (int pageIndex = 0; pageIndex < pageCount; pageIndex++) {
                BufferedImage image = pdfRenderer.renderImage(pageIndex);
                JLabel pageLabel = new JLabel(new ImageIcon(image));
                add(pageLabel);
            }

            // Set up JFrame
            setLayout(new GridLayout(1, pageCount));
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            // Close the document when the JFrame is closed
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    try {
                        document.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PDFViewer("C:\\Users\\ADMIN\\Desktop\\RESTful Web Services.pdf"));
    }
}

