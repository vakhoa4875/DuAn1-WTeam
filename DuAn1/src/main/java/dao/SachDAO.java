/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.List;
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
public class SachDAO {

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
                         TRUESIZEAVATAR = ?,
                         MOTA = ?,
                         DANHGIATB = ?,
                         MINAGE = ?,
                         PDFAVAI = ?,
                         AUDIOAVAI = ?,
                         [VERSION] = ?,
                         SOTRANG = ?,
                         NGONNGU = ?,
                         SOURCEPDF = ?,
                         sourceSound = ?,
                         FREE = ?,
                         LIKECOUNT = ?,
                         viewcount = ?,
                         thoiLuong = ?
                     WHERE IDSACH = ?;
                     """;
        Jdbc.executeUpdate(updateQuery,
                sach.getTenSach(),
                    sach.getGiaNiemYet(),
                    sach.getThumbnail(),
                    sach.getAvatar(),
                    sach.getTrueSizeAvatar(),
                    sach.getMoTa(),
                    sach.getDanhGiaTB(),
                    sach.getMinAge(),
                    sach.getPdfAvai(),
                    sach.getAudioAvai(),
                    sach.getVersion(),
                    sach.getSoTrang(),
                    sach.getNgonNgu(),
                    sach.getSourcePDF(),
                    sach.getSourceSound(),
                    sach.getFree(),
                    sach.getLikeCount(),
                    sach.getViewCount(),
                    sach.getThoiLuong(),
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

    public ArrayList<Sach> select() {
        String selectQuery = "select * from Sach";
        return select(selectQuery);
    }

    public ArrayList<Sach> search(String searchValue) {
        String selectQuery = "{call searchSach (?)}";
        return select(selectQuery, searchValue);

    }

    private ArrayList<Sach> select(String sql, Object... args) {
        ArrayList<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Sach sach = readFromRS(rs);
                    list.add(sach);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        return list;

    }

    private Sach readFromRS(ResultSet resultSet) throws SQLException {
        Sach sach = new Sach(
                resultSet.getString("IDSACH"),
                resultSet.getString("TENSACH"),
                resultSet.getInt("GIANIEMYET"),
                resultSet.getString("THUMBNAIL"),
                resultSet.getString("AVATAR"),
                resultSet.getString("TRUESIZEAVATAR"),
                resultSet.getString("MOTA"),
                resultSet.getDouble("DANHGIATB"),
                resultSet.getInt("MINAGE"),
                resultSet.getBoolean("PDFAVAI"),
                resultSet.getBoolean("AUDIOAVAI"),
                resultSet.getString("VERSION"),
                resultSet.getInt("SOTRANG"),
                resultSet.getString("NGONNGU"),
                resultSet.getString("SOURCEPDF"),
                resultSet.getString("sourceSound"),
                resultSet.getBoolean("FREE"),
                resultSet.getInt("LIKECOUNT"),
                resultSet.getInt("viewcount"),
                resultSet.getTime("thoiLuong"));
        return sach;
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
