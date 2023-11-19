/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Arrays;
import library.Jdbc;
import model.Sach;
import model.TacGia;
import model.TheLoai;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SachDAO{
    
//    @Override
    public void insert(Sach sach) {
        String insertQuery = """
                             INSERT INTO SACH (IDSACH, TENSACH, GIANIEMYET,
                             truesizeavatar, THUMBNAIL, AVATAR, 
                             MOTA, DANHGIATB, MINAGE, 
                             PDFAVAI, AUDIOAVAI, SOTRANG, 
                             NGONNGU, SOURCEPDF, sourceSound, 
                             FREE, LIKECOUNT, viewcount, [version], thoiluong)
                             VALUES (?, ?, ?, ?, 
                             ?, ?, ?, ?, 
                             ?, ?, ?, ?, 
                             ?, ?, ?, ?, 
                             ?, ?, ?, ?)""";
        Jdbc.executeUpdate(insertQuery,
                sach.getIdSach(),
                sach.getTenSach(),
                sach.getFree() ? 0 : sach.getGiaNiemYet(),
                sach.getTrueSizeAvatar(),
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
                sach.getVersion(),
                sach.getThoiLuong());
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
    
    public void delete(Sach sach) {
        String deleteQuery = """
                             delete from sach
                             where idSach = ?
                             """;
        Jdbc.executeUpdate(deleteQuery, sach.getIdSach());
    }
    
    public void deleteSvTG(Sach sach) {
        String deleteQuery = """
                             delete from SvTG
                             where idSach = ?
                             """;
        Jdbc.executeUpdate(deleteQuery, sach.getIdSach());
    }
    
    public void deleteSvTL(Sach sach) {
        String deleteQuery = """
                             delete from SvTL
                             where idSach = ?
                             """;
        Jdbc.executeUpdate(deleteQuery, sach.getIdSach());
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
    
    public void updateSvTG(Sach sach, TacGia tg) {
        deleteSvTG(sach);
        insertSvTG(sach, tg);
    }
    
    public void updateSvTG(Sach sach, ArrayList<TacGia> authors) {
        deleteSvTG(sach);
        insertSvTG(sach, authors);
    }
    
    public void updateSvTL(Sach sach, TheLoai tg) {
        deleteSvTL(sach);
        insertSvTL(sach, tg);
    }
    
    public void updateSvTL(Sach sach, ArrayList<TheLoai> genres) {
        deleteSvTL(sach);
        insertSvTL(sach, genres);
    }
    
    
    private Sach readFromRS(ResultSet resultSet) throws SQLException {
        Sach sach = new Sach();
                sach.setIdSach(resultSet.getString("IDSACH"));
                sach.setTenSach(resultSet.getString("TENSACH"));
                sach.setGiaNiemYet(resultSet.getInt("GIANIEMYET"));
                sach.setThumbnail(resultSet.getString("THUMBNAIL"));
                sach.setAvatar(resultSet.getString("AVATAR"));
                sach.setMoTa(resultSet.getString("MOTA"));
                sach.setDanhGiaTB(resultSet.getDouble("DANHGIATB"));
                sach.setMinAge(resultSet.getInt("MINAGE"));
                sach.setPdfAvai(resultSet.getBoolean("PDFAVAI"));
                sach.setAudioAvai(resultSet.getBoolean("AUDIOAVAI"));
                sach.setVersion(resultSet.getString("VERSIONS"));
                sach.setSoTrang(resultSet.getInt("SOTRANG"));
                sach.setNgonNgu(resultSet.getString("NGONNGU"));
                sach.setSourcePDF(resultSet.getString("SOURCEPDF"));
                sach.setSourceSound(resultSet.getString("sourceSound"));
                sach.setFree(resultSet.getBoolean("FREE"));
                sach.setLikeCount(resultSet.getInt("LIKECOUNT"));
                sach.setViewCount(resultSet.getInt("viewcount"));
        return null;
    }
//
//    @Override
//    public void insert(Object... args) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void delete(Object... args) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void update(Object... args) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void select(Object... args) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
