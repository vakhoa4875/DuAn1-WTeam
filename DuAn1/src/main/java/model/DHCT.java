/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class DHCT {

    private Integer idDonHang, soLuongSach, subTotal;
    private String idSach;

    public DHCT() {
    }

    public DHCT(Integer idDonHang, Integer soLuongSach, Integer subTotal, String idSach) {
        this.idDonHang = idDonHang;
        this.soLuongSach = soLuongSach;
        this.subTotal = subTotal;
        this.idSach = idSach;
    }

    public Integer getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }

    public Integer getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(Integer soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

}
