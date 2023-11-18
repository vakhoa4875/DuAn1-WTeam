/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleBooksPreviewViewer extends JFrame {

    public GoogleBooksPreviewViewer(String previewLink) {
        super("Google Books Preview Viewer");

        // Create a JButton to open the preview link
        JButton openButton = new JButton("Open Preview");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPreviewLink(previewLink);
            }
        });

        // Set up the layout
        setLayout(new BorderLayout());
        add(openButton, BorderLayout.CENTER);

        // Set up the JFrame
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openPreviewLink(String previewLink) {
        try {
            // Open the preview link in the default web browser
            Desktop.getDesktop().browse(new URI(previewLink));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace "YOUR_PREVIEW_LINK" with the actual preview link obtained from the Google Books API
        String previewLink = "http://books.google.com.vn/books?id=e3tuAAAAMAAJ&printsec=frontcover&dq=java&hl=&as_brr=7&cd=1&source=gbs_api";

        SwingUtilities.invokeLater(() -> new GoogleBooksPreviewViewer(previewLink));
    }
}

