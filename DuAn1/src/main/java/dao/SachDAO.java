/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import library.Jdbc;
import model.Sach;
import model.TacGia;
import model.TheLoai;

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
    
    public void insertSvTG(Sach sach, TacGia tg) {
        String insertQuery = """
                             INSERT INTO SvTG (IDSACH, idTacGia)
                             VALUES (?, ?)""";
        Jdbc.executeUpdate(insertQuery,
                sach.getIdSach(),
                tg.getIdTacGia());
    }
    
    public void insertSvTG(Sach sach, ArrayList<TacGia> authors) {
        for (TacGia tg : authors) {
            insertSvTG(sach, tg);
        }
    }
    
    public void insertSvTL(Sach sach, TheLoai tl) {
        String insertQuery = """
                             INSERT INTO SvTL (IDSACH, idTheLoai)
                             VALUES (?, ?)""";
        Jdbc.executeUpdate(insertQuery,
                sach.getIdSach(),
                tl.getIdTheLoai());
    }
    
    public void insertSvTL(Sach sach, ArrayList<TheLoai> genres) {
        for (TheLoai tl : genres) {
            insertSvTL(sach, tl);
        }
    }

    public void update(Sach sach) {
        String updateQuery = """
                             UPDATE SACH
                             SET 
                                 TENSACH = ?,
                                 GIANIEMYET = ?,
                                 THUMBNAIL = ?,
                                 AVATAR = ?,
                                 MOTA = ?,
                                 DANHGIATB = ?,
                                 MINAGE = ?,
                                 PDFAVAI = ?,
                                 AUDIOAVAI = ?,
                                 VERSIONS = ?,
                                 SOTRANG = ?,
                                 NGONNGU = ?,
                                 SOURCEPDF = ?,
                                 sourceSound = ?,
                                 FREE = ?,
                                 LIKECOUNT = ?,
                                 viewcount = ?
                             WHERE IDSACH = ?;
                             """;
        Jdbc.executeUpdate(updateQuery, 
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
                sach.getViewCount(),
                sach.getIdSach());
    }
}
