///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
//package testAPI;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import java.io.Reader;
//import java.util.Arrays;
//
//public class GoogleLoginExample {
//    private static final String CLIENT_ID = "YOUR_CLIENT_ID";
//    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET";
//    private static final String REDIRECT_URI = "YOUR_REDIRECT_URI";
//
//    public static void main(String[] args) {
//        try {
//            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
//
//            // Load client secrets from a JSON file
//            GoogleClientSecrets clientSecrets;
//            clientSecrets = GoogleClientSecrets.load(jsonFactory,
//                    GoogleLoginExample.class.getResourceAsStream("/client_secrets.json"));
//
//            // Set up authorization code flow
//            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                    httpTransport, jsonFactory, clientSecrets, Arrays.asList("email", "profile"))
//                    .setAccessType("offline")
//                    .setApprovalPrompt("force")
//                    .build();
//
//            // Generate the URL for the login page
//            String loginUrl = flow.newAuthorizationUrl()
//                    .setRedirectUri(REDIRECT_URI)
//                    .build();
//
//            // Redirect the user to the login URL
//            System.out.println("Open the following URL in your browser:");
//            System.out.println(loginUrl);
//
//            // After the user logs in and grants permission, they will be redirected to your redirect URI
//            // You will need to handle the authorization code from the redirected URL and exchange it for an access token
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
