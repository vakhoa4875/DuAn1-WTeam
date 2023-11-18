/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * 
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class GHCT {
    private Integer idGioHang, soLuongSach;
    private String idSach, selectedOption;
    private Boolean selected;

    public GHCT() {
    }

    public GHCT(Integer idGioHang, Integer soLuongSach, String idSach, String selectedOption, Boolean selected) {
        this.idGioHang = idGioHang;
        this.soLuongSach = soLuongSach;
        this.idSach = idSach;
        this.selectedOption = selectedOption;
        this.selected = selected;
    }

    public Integer getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(Integer idGioHang) {
        this.idGioHang = idGioHang;
    }

    public Integer getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(Integer soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    
    
}
