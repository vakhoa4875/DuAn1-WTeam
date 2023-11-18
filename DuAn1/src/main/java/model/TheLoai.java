/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class TheLoai {

    private Integer idTheLoai;
    private String tenTheLoai, moTa;

    public TheLoai() {
    }

    public TheLoai(Integer idTheLoai, String tenTheLoai, String moTa) {
        this.idTheLoai = idTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
