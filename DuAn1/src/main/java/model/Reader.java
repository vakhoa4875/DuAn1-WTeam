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
public class Reader {

    private Integer idReader;
    private String userID;
    private Boolean thanThiet;
    private Integer tichDiem;
    private Date ngaySinh;
    private String avatar;
    private String hoTen;

    public Reader(Integer idReader, String userID, Boolean thanThiet, Integer tichDiem, Date ngaySinh, String avatar, String hoTen) {
        this.idReader = idReader;
        this.userID = userID;
        this.thanThiet = thanThiet;
        this.tichDiem = tichDiem;
        this.ngaySinh = ngaySinh;
        this.avatar = avatar;
        this.hoTen = hoTen;
    }

    public Reader() {
    }

    public Integer getIdReader() {
        return idReader;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Boolean getThanThiet() {
        return thanThiet;
    }

    public void setThanThiet(Boolean thanThiet) {
        this.thanThiet = thanThiet;
    }

    public Integer getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(Integer tichDiem) {
        this.tichDiem = tichDiem;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
