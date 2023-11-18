/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;

/**
 *
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class Sach {

    private String idSach, tenSach, moTa, version, ngonNgu[];
    private Integer giaNiemYet, minAge, soTrang, likeCount, viewCount;
    private String thumbnail, avatar, trueSizeAvatar, sourcePDF, sourceSound;
    private Double danhGiaTB;
    private Boolean pdfAvai, audioAvai, free;
    private Time thoiLuong;

    public Sach() {
    }

    public Sach(String idSach, String tenSach, String moTa, String version, String[] ngonNgu, Integer giaNiemYet, Integer minAge, Integer soTrang, Integer likeCount, Integer viewCount, String thumbnail, String avatar, String trueSizeAvatar, String sourcePDF, String sourceSound, Double danhGiaTB, Boolean pdfAvai, Boolean audioAvai, Boolean free, Time thoiLuong) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.moTa = moTa;
        this.version = version;
        this.ngonNgu = ngonNgu;
        this.giaNiemYet = giaNiemYet;
        this.minAge = minAge;
        this.soTrang = soTrang;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.thumbnail = thumbnail;
        this.avatar = avatar;
        this.trueSizeAvatar = trueSizeAvatar;
        this.sourcePDF = sourcePDF;
        this.sourceSound = sourceSound;
        this.danhGiaTB = danhGiaTB;
        this.pdfAvai = pdfAvai;
        this.audioAvai = audioAvai;
        this.free = free;
        this.thoiLuong = thoiLuong;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String[] getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String[] ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public Integer getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(Integer giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTrueSizeAvatar() {
        return trueSizeAvatar;
    }

    public void setTrueSizeAvatar(String trueSizeAvatar) {
        this.trueSizeAvatar = trueSizeAvatar;
    }

    public String getSourcePDF() {
        return sourcePDF;
    }

    public void setSourcePDF(String sourcePDF) {
        this.sourcePDF = sourcePDF;
    }

    public String getSourceSound() {
        return sourceSound;
    }

    public void setSourceSound(String sourceSound) {
        this.sourceSound = sourceSound;
    }

    public Double getDanhGiaTB() {
        return danhGiaTB;
    }

    public void setDanhGiaTB(Double danhGiaTB) {
        this.danhGiaTB = danhGiaTB;
    }

    public Boolean getPdfAvai() {
        return pdfAvai;
    }

    public void setPdfAvai(Boolean pdfAvai) {
        this.pdfAvai = pdfAvai;
    }

    public Boolean getAudioAvai() {
        return audioAvai;
    }

    public void setAudioAvai(Boolean audioAvai) {
        this.audioAvai = audioAvai;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Time getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Time thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

}
