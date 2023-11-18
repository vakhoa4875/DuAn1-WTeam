/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDateTime;

/**
 * 
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class DonHang {
    private Integer idDonHang, idGioHang;
    private String maKhuyenMai;
    private Integer tongTien;
    private LocalDateTime ngayLapDon;

    public DonHang() {
    }

    public DonHang(Integer idDonHang, Integer idGioHang, String maKhuyenMai, Integer tongTien, LocalDateTime ngayLapDon) {
        this.idDonHang = idDonHang;
        this.idGioHang = idGioHang;
        this.maKhuyenMai = maKhuyenMai;
        this.tongTien = tongTien;
        this.ngayLapDon = ngayLapDon;
    }

    public Integer getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }

    public Integer getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(Integer idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDateTime getNgayLapDon() {
        return ngayLapDon;
    }

    public void setNgayLapDon(LocalDateTime ngayLapDon) {
        this.ngayLapDon = ngayLapDon;
    }
    
}
