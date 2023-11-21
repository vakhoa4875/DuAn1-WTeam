package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO {

    public void insert(Sach sach) {
        String insertQuery = """
                             INSERT INTO SACH
                             VALUES (?, ?, ?, ?, ?,
                             ?, ?, ?, ?, ?,
                             ?, ?, ?, ?, 
                             ?, ?, ?, ?, 
                             ?, ?, ?, ?)""";
        Jdbc.executeUpdate(insertQuery,
                sach.getIdSach(),
                sach.getTenSach(),
                sach.getFree(),
                sach.getGiaNiemYet(),
                sach.getDanhGiaTB(),
                sach.getMoTa(),
                sach.getNgonNgu(),
                sach.getThumbnail(),
                sach.getAvatar(),
                sach.getTrueSizeAvatar(),
                sach.getPdfAvai(),
                sach.getSourcePDF(),
                sach.getSoTrang(),
                sach.getAudioAvai(),
                sach.getSourceSound(),
                sach.getThoiLuong(),
                sach.getNamSangTac(),
                sach.getVersion(),
                sach.getNamXB(),
                sach.getMinAge(),
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
                         free = ?,
                         giaNiemYet = ?,
                             danhGiaTB =?,
                             moTa = ?,
                             ngonNgu =?,
                             thumbnail = ?,
                             avatar = ?,
                             trueSizeAvatar = ?,
                             pdfAvai = ?,
                             sourcePDF = ?,
                             soTrang =?,
                             audioAvai = ?,
                             sourceSound = ?,
                             thoiLuong = ?,
                             namSangTac = ?,
                             [version] = ?,
                             namXB = ? ,
                             minAge = ?,
                             likeCount = ? ,
                             viewCount = ?
                     WHERE IDSACH = ?;
                     """;
        Jdbc.executeUpdate(updateQuery,
                sach.getTenSach(),
                sach.getFree(),
                sach.getGiaNiemYet(),
                sach.getDanhGiaTB(),
                sach.getMoTa(),
                sach.getNgonNgu(),
                sach.getThumbnail(),
                sach.getAvatar(),
                sach.getTrueSizeAvatar(),
                sach.getPdfAvai(),
                sach.getSourcePDF(),
                sach.getSoTrang(),
                sach.getAudioAvai(),
                sach.getSourceSound(),
                sach.getThoiLuong(),
                sach.getNamSangTac(),
                sach.getVersion(),
                sach.getNamXB(),
                sach.getMinAge(),
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
                resultSet.getBoolean("FREE"),
                resultSet.getInt("GIANIEMYET"),
                resultSet.getDouble("DANHGIATB"),
                resultSet.getString("MOTA"),
                resultSet.getString("NGONNGU"),
                resultSet.getString("THUMBNAIL"),
                resultSet.getString("AVATAR"),
                resultSet.getString("TRUESIZEAVATAR"),
                resultSet.getBoolean("PDFAVAI"),
                resultSet.getString("SOURCEPDF"),
                resultSet.getInt("SOTRANG"),
                resultSet.getBoolean("AUDIOAVAI"),
                resultSet.getString("sourceSound"),
                resultSet.getTime("thoiLuong"),
                resultSet.getInt("NAMSANGTAC"),
                resultSet.getString("VERSION"),
                resultSet.getInt("NAMXB"),
                resultSet.getInt("MINAGE"),
                resultSet.getInt("LIKECOUNT"),
                resultSet.getInt("VIEWCOUNT"));
        return sach;
    }

//    private Sach readFromRS(ResultSet resultSet) throws SQLException {
//        Sach sach = new Sach(
//                resultSet.getString("IDSACH"),
//                resultSet.getString("TENSACH"),
//                resultSet.getInt("GIANIEMYET"),
//                resultSet.getString("THUMBNAIL"),
//                resultSet.getString("AVATAR"),
//                resultSet.getString("TRUESIZEAVATAR"),
//                resultSet.getString("MOTA"),
//                resultSet.getDouble("DANHGIATB"),
//                resultSet.getInt("MINAGE"),
//                resultSet.getBoolean("PDFAVAI"),
//                resultSet.getBoolean("AUDIOAVAI"),
//                resultSet.getString("VERSION"),
//                resultSet.getInt("SOTRANG"),
//                resultSet.getString("NGONNGU"),
//                resultSet.getString("SOURCEPDF"),
//                resultSet.getString("sourceSound"),
//                resultSet.getBoolean("FREE"),
//                resultSet.getInt("LIKECOUNT"),
//                resultSet.getInt("viewcount"),
//                resultSet.getTime("thoiLuong"));
//        return sach;
//    }
}
