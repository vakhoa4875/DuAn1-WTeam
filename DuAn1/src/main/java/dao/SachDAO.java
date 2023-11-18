/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import library.Jdbc;
import model.Sach;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SachDAO {

    public void insert(Sach sach) {
        String insertQuery = """
                             INSERT INTO SACH (IDSACH, TENSACH, GIANIEMYET, THUMBNAIL, AVATAR, MOTA, DANHGIATB, MINAGE, PDFAVAI, AUDIOAVAI, SOTRANG, NGONNGU, SOURCEPDF, sourceSound, FREE, LIKECOUNT, viewcount)
                             VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        Jdbc.executeUpdate(insertQuery, 
                sach.getIdSach(),
                sach.getTenSach(),
                sach.getGiaNiemYet(),
                sach.getThumbnail(),
                sach.getAvatar(),
                sach.getMoTa(),
                sach.getDanhGiaTB(),
                sach.getMinAge(),
                sach.getPdfAvai() == true ? 1 : 0,
                sach.getAudioAvai() == true ? 1 : 0,
                sach.getSoTrang(),
                sach.getNgonNgu(),
                sach.getSourcePDF(),
                sach.getSourceSound(),
                sach.getFree() == true ? 1 : 0,
                sach.getLikeCount(),
                sach.getViewCount());
    }
}
