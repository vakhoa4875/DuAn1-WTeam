/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package library;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class URL_Dealer {
    
    
    // open link in default web browser
    public static void openURL(String link) {
        try {
            // Check if the Desktop API is supported on the current platform
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                // Create a URI object from the URL
                URI uri = new URI(link);

                // Open the default web browser to the specified URL
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop API is not supported on this platform.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
//            System.out.println(e.toString());
            DialogHelper.alert(null, e.toString()
            );
            
        }
    }
}
