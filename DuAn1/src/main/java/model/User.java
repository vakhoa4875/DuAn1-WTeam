/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class User {

    private String userID;
    private String userName;
    private String password;
    private String email;
    private Boolean verificated, reader;
//    private String hoTen;
//    private String avatar;
//    private Date dob;

    public User() {

    }

    public User(String userID, String userName, String password, String email, Boolean verificated, Boolean reader) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.verificated = verificated;
        this.reader = reader;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVerificated() {
        return verificated;
    }

    public void setVerificated(Boolean verificated) {
        this.verificated = verificated;
    }

    public Boolean getReader() {
        return reader;
    }

    public void setReader(Boolean reader) {
        this.reader = reader;
    }

}
