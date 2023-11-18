/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testAPI;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;

public class SimpleWebBrowser extends JFrame {

    private JFXPanel jfxPanel;
    private WebEngine engine;

    public SimpleWebBrowser() {
        super("Simple Web Browser");

        initComponents();

        // Set up the JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        jfxPanel = new JFXPanel();

        createScene();

        setLayout(new BorderLayout());
        add(jfxPanel, BorderLayout.CENTER);

        JTextField urlField = new JTextField("https://www.example.com");
        JButton goButton = new JButton("Go");

        goButton.addActionListener((ActionEvent e) -> {
            loadURL(urlField.getText());
        });

        JPanel toolbar = new JPanel(new FlowLayout());
        toolbar.add(urlField);
        toolbar.add(goButton);

        add(toolbar, BorderLayout.NORTH);
    }

    private void createScene() {
        Platform.runLater(() -> {
            WebView view = new WebView();
            engine = view.getEngine();

            jfxPanel.setScene(new Scene(view));
        });
    }

    private void loadURL(String url) {
        Platform.runLater(() -> {
            String finalUrl = url.startsWith("http://") || url.startsWith("https://") ? url : "http://" + url;
            engine.load(finalUrl);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleWebBrowser());
    }
}
