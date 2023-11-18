/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.duan1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageDisplay extends JFrame {

    public ImageDisplay(String imageUrl) {
        setTitle("Image Display");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);

            if (image != null) {
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);
                getContentPane().add(label, BorderLayout.CENTER);
            } else {
                System.err.println("Không thể tải hình ảnh từ URL.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi tải hình ảnh từ URL.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String imageUrl = "https://ichef.bbci.co.uk/news/999/cpsprodpb/15951/production/_117310488_16.jpg"; // Thay đổi URL hình ảnh của bạn ở đây
            ImageDisplay imageDisplay = new ImageDisplay(imageUrl);
            imageDisplay.setVisible(true);
        });
    }
}

