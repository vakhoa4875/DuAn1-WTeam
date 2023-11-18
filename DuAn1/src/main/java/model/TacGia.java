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
public class TacGia {

    private Integer idTacGia;
    private String tenTacGia, moTa;
    private Date ngaySinh, ngayMat;
    private String quocTich[];

    public TacGia(Integer idTacGia, String tenTacGia, String moTa, Date ngaySinh, Date ngayMat, String[] quocTich) {
        this.idTacGia = idTacGia;
        this.tenTacGia = tenTacGia;
        this.moTa = moTa;
        this.ngaySinh = ngaySinh;
        this.ngayMat = ngayMat;
        this.quocTich = quocTich;
    }

    public TacGia() {
    }

    public Integer getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(Integer idTacGia) {
        this.idTacGia = idTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayMat() {
        return ngayMat;
    }

    public void setNgayMat(Date ngayMat) {
        this.ngayMat = ngayMat;
    }

    public String[] getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String[] quocTich) {
        this.quocTich = quocTich;
    }

}
