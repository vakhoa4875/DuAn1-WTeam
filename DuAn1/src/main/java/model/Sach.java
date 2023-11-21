
package model;

/**
 *
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
import java.sql.Time;

public class Sach {
    private String idSach, tenSach, moTa, ngonNgu, thumbnail, avatar, trueSizeAvatar, sourcePDF, sourceSound, version;
    private Boolean free, pdfAvai, audioAvai;
    private Integer giaNiemYet, namSangTac, soTrang, namXB, minAge, likeCount, viewCount;
    private Double danhGiaTB;
    private Time thoiLuong;

    // Constructors, getters, and setters...

    // Default constructor
    public Sach() {
    }

    // Parameterized constructor to initialize all fields
    public Sach(String idSach, String tenSach, Boolean free, Integer giaNiemYet, Double danhGiaTB, String moTa,
                String ngonNgu, String thumbnail, String avatar, String trueSizeAvatar, Boolean pdfAvai,
                String sourcePDF, Integer soTrang, Boolean audioAvai, String sourceSound, Time thoiLuong,
                Integer namSangTac, String version, Integer namXB, Integer minAge, Integer likeCount,
                Integer viewCount) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.free = free;
        this.giaNiemYet = giaNiemYet;
        this.danhGiaTB = danhGiaTB;
        this.moTa = moTa;
        this.ngonNgu = ngonNgu;
        this.thumbnail = thumbnail;
        this.avatar = avatar;
        this.trueSizeAvatar = trueSizeAvatar;
        this.pdfAvai = pdfAvai;
        this.sourcePDF = sourcePDF;
        this.soTrang = soTrang;
        this.audioAvai = audioAvai;
        this.sourceSound = sourceSound;
        this.thoiLuong = thoiLuong;
        this.namSangTac = namSangTac;
        this.version = version;
        this.namXB = namXB;
        this.minAge = minAge;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
    }

    // Getters and setters for all fields...

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

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
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

    public Integer getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(Integer giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }

    public Integer getNamSangTac() {
        return namSangTac;
    }

    public void setNamSangTac(Integer namSangTac) {
        this.namSangTac = namSangTac;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public Integer getNamXB() {
        return namXB;
    }

    public void setNamXB(Integer namXB) {
        this.namXB = namXB;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
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

    public Double getDanhGiaTB() {
        return danhGiaTB;
    }

    public void setDanhGiaTB(Double danhGiaTB) {
        this.danhGiaTB = danhGiaTB;
    }

    public Time getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Time thoiLuong) {
        this.thoiLuong = thoiLuong;
    }
    
    @Override
    public String toString() {
        return "Sach{" +
                "idSach='" + idSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngonNgu='" + ngonNgu + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", avatar='" + avatar + '\'' +
                ", trueSizeAvatar='" + trueSizeAvatar + '\'' +
                ", sourcePDF='" + sourcePDF + '\'' +
                ", sourceSound='" + sourceSound + '\'' +
                ", version='" + version + '\'' +
                ", free=" + free +
                ", pdfAvai=" + pdfAvai +
                ", audioAvai=" + audioAvai +
                ", giaNiemYet=" + giaNiemYet +
                ", namSangTac=" + namSangTac +
                ", soTrang=" + soTrang +
                ", namXB=" + namXB +
                ", minAge=" + minAge +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                ", danhGiaTB=" + danhGiaTB +
                ", thoiLuong=" + thoiLuong +
                '}';
    }
}


//public class Sach {
//
////    private String idSach, tenSach, moTa, version, ngonNgu;
////    private Integer giaNiemYet, minAge, soTrang, likeCount, viewCount;
////    private String thumbnail, avatar, trueSizeAvatar, sourcePDF, sourceSound;
////    private Double danhGiaTB;
////    private Boolean pdfAvai, audioAvai, free;
////    private Time thoiLuong;
////
////    public Sach() {
////    }
////    
////    
////
//////    public Sach(String idSach, String tenSach, String moTa, Integer giaNiemYet, Integer soTrang, String trueSizeAvatar, String sourcePDF, String sourceSound, Boolean pdfAvai, Boolean audioAvai, Boolean free, Time thoiLuong) {
//////        this.idSach = idSach;
//////        this.tenSach = tenSach;
//////        this.moTa = moTa;
//////        this.giaNiemYet = giaNiemYet;
//////        this.soTrang = soTrang;
//////        this.trueSizeAvatar = trueSizeAvatar;
//////        this.sourcePDF = sourcePDF;
//////        this.sourceSound = sourceSound;
//////        this.pdfAvai = pdfAvai;
//////        this.audioAvai = audioAvai;
//////        this.free = free;
//////        this.thoiLuong = thoiLuong;
//////    }
////
////    public Sach(String idSach, String tenSach, String moTa, String version, String ngonNgu, Integer giaNiemYet, Integer minAge, Integer soTrang, Integer likeCount, Integer viewCount, String thumbnail, String avatar, String trueSizeAvatar, String sourcePDF, String sourceSound, Double danhGiaTB, Boolean pdfAvai, Boolean audioAvai, Boolean free, Time thoiLuong) {
////        this.idSach = idSach;
////        this.tenSach = tenSach;
////        this.moTa = moTa;
////        this.version = version;
////        this.ngonNgu = ngonNgu;
////        this.giaNiemYet = giaNiemYet;
////        this.minAge = minAge;
////        this.soTrang = soTrang;
////        this.likeCount = likeCount;
////        this.viewCount = viewCount;
////        this.thumbnail = thumbnail;
////        this.avatar = avatar;
////        this.trueSizeAvatar = trueSizeAvatar;
////        this.sourcePDF = sourcePDF;
////        this.sourceSound = sourceSound;
////        this.danhGiaTB = danhGiaTB;
////        this.pdfAvai = pdfAvai;
////        this.audioAvai = audioAvai;
////        this.free = free;
////        this.thoiLuong = thoiLuong;
////    }
//    private String idSach, tenSach;
//    private Integer giaNiemYet;
//    private String thumbnail, avatar, trueSizeAvatar, moTa;
//    private Double danhGiaTB;
//    private Integer minAge;
//    private Boolean pdfAvai, audioAvai;
//    private String version;
//    private Integer soTrang;
//    private String ngonNgu, sourcePDF, sourceSound;
//    private Boolean free;
//    private Integer likeCount, viewCount;
//    private Time thoiLuong;
//
//    // Constructors, getters, and setters...
//
//    // Default constructor
//    public Sach() {
//    }
//
//    // Parameterized constructor to initialize all fields
//    public Sach(String idSach, String tenSach, Integer giaNiemYet, 
//                String thumbnail, String avatar, String trueSizeAvatar,
//                String moTa, Double danhGiaTB, Integer minAge, 
//                Boolean pdfAvai, Boolean audioAvai, String version,
//                Integer soTrang, String ngonNgu, String sourcePDF,
//                String sourceSound, Boolean free, Integer likeCount, 
//                Integer viewCount, Time thoiLuong) {
//        this.idSach = idSach;
//        this.tenSach = tenSach;
//        this.giaNiemYet = giaNiemYet;
//        this.thumbnail = thumbnail;
//        this.avatar = avatar;
//        this.trueSizeAvatar = trueSizeAvatar;
//        this.moTa = moTa;
//        this.danhGiaTB = danhGiaTB;
//        this.minAge = minAge;
//        this.pdfAvai = pdfAvai;
//        this.audioAvai = audioAvai;
//        this.version = version;
//        this.soTrang = soTrang;
//        this.ngonNgu = ngonNgu;
//        this.sourcePDF = sourcePDF;
//        this.sourceSound = sourceSound;
//        this.free = free;
//        this.likeCount = likeCount;
//        this.viewCount = viewCount;
//        this.thoiLuong = thoiLuong;
//    }
//
//    public String getIdSach() {
//        return idSach;
//    }
//
//    public void setIdSach(String idSach) {
//        this.idSach = idSach;
//    }
//
//    public String getTenSach() {
//        return tenSach;
//    }
//
//    public void setTenSach(String tenSach) {
//        this.tenSach = tenSach;
//    }
//
//    public String getMoTa() {
//        return moTa;
//    }
//
//    public void setMoTa(String moTa) {
//        this.moTa = moTa;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public String getNgonNgu() {
//        return ngonNgu;
//    }
//
//    public void setNgonNgu(String ngonNgu) {
//        this.ngonNgu = ngonNgu;
//    }
//
//    public Integer getGiaNiemYet() {
//        return giaNiemYet;
//    }
//
//    public void setGiaNiemYet(Integer giaNiemYet) {
//        this.giaNiemYet = giaNiemYet;
//    }
//
//    public Integer getMinAge() {
//        return minAge;
//    }
//
//    public void setMinAge(Integer minAge) {
//        this.minAge = minAge;
//    }
//
//    public Integer getSoTrang() {
//        return soTrang;
//    }
//
//    public void setSoTrang(Integer soTrang) {
//        this.soTrang = soTrang;
//    }
//
//    public Integer getLikeCount() {
//        return likeCount;
//    }
//
//    public void setLikeCount(Integer likeCount) {
//        this.likeCount = likeCount;
//    }
//
//    public Integer getViewCount() {
//        return viewCount;
//    }
//
//    public void setViewCount(Integer viewCount) {
//        this.viewCount = viewCount;
//    }
//
//    public String getThumbnail() {
//        return thumbnail;
//    }
//
//    public void setThumbnail(String thumbnail) {
//        this.thumbnail = thumbnail;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getTrueSizeAvatar() {
//        return trueSizeAvatar;
//    }
//
//    public void setTrueSizeAvatar(String trueSizeAvatar) {
//        this.trueSizeAvatar = trueSizeAvatar;
//    }
//
//    public String getSourcePDF() {
//        return sourcePDF;
//    }
//
//    public void setSourcePDF(String sourcePDF) {
//        this.sourcePDF = sourcePDF;
//    }
//
//    public String getSourceSound() {
//        return sourceSound;
//    }
//
//    public void setSourceSound(String sourceSound) {
//        this.sourceSound = sourceSound;
//    }
//
//    public Double getDanhGiaTB() {
//        return danhGiaTB;
//    }
//
//    public void setDanhGiaTB(Double danhGiaTB) {
//        this.danhGiaTB = danhGiaTB;
//    }
//
//    public Boolean getPdfAvai() {
//        return pdfAvai;
//    }
//
//    public void setPdfAvai(Boolean pdfAvai) {
//        this.pdfAvai = pdfAvai;
//    }
//
//    public Boolean getAudioAvai() {
//        return audioAvai;
//    }
//
//    public void setAudioAvai(Boolean audioAvai) {
//        this.audioAvai = audioAvai;
//    }
//
//    public Boolean getFree() {
//        return free;
//    }
//
//    public void setFree(Boolean free) {
//        this.free = free;
//    }
//
//    public Time getThoiLuong() {
//        return thoiLuong;
//    }
//
//    public void setThoiLuong(Time thoiLuong) {
//        this.thoiLuong = thoiLuong;
//    }
//
//}
