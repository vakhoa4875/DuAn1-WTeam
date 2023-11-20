/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Extension {

//    Class<Object> class = 
    public static void scaleImage(String path, JLabel anh) {
        ImageIcon icon = new ImageIcon(Extension.class.getResource("/images/" + path));
        //scale image
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(anh.getWidth(), anh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        anh.setIcon(scaledIcon);
    }

    public static void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }

    public static boolean areEmpty(JTextField... args) {
        for (JTextField txt : args) {
            if (txt.getText().length() == 0) {
                DialogHelper.alert(txt, "Vui lòng nhập đủ các trường");
                return true;
            }
        }
        return false;
    }

    public static boolean isEmail(JTextField txt) {
        String email = txt.getText();
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            DialogHelper.alert(txt, "Vui lòng nhập đúng syntax Email!");
        }

        return matcher.matches();
    }
    
    public static String randomUserID(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder("user_");

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
