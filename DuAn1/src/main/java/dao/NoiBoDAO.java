/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import library.Jdbc;
import model.NoiBo;
import model.User;

/**
 *
 * @author Admin
 */
public class NoiBoDAO {
    public void insert(User user) {
        String insertQuery = "INSERT INTO [User] (UserID, UserName, [password], Email, Reader, Verificated) VALUES (?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(insertQuery, 
                user.getUserID(), 
                user.getUserName(), 
                user.getPassword(), 
                user.getEmail(), 
                user.getReader(), 
                user.getVerificated());
    }
        public void delete(NoiBo noiBo) {
        String deleteQuery = "DELETE FROM noibo WHERE idNoiBo = ?";
        Jdbc.executeUpdate(deleteQuery, noiBo.getIdNoiBo());
    }

    public void update(NoiBo noiBo) {
        String updateQuery = "update noiBo set idPB = ?, idQuanLy = ?, luong = ?, fullTime = ?, ngayThue = ?, caLam = ?, quanLy = ?, luongbong = ?, ngaySinh = ?, avatar = ?, gioiTinh = ?  where idNoiBo = ?";
        Jdbc.executeUpdate(updateQuery, 
               noiBo.getIdPB(),
               noiBo.getIdQuanLy(),
               noiBo.getLuong(),
               noiBo.getFulltime(),
               noiBo.getNgayThue(),
               noiBo.getCaLam(),
               noiBo.getQuanLy(),
               noiBo.getLuongBong(),
               noiBo.getNgaySinh(),
               noiBo.getAvatar(),
               noiBo.getGioiTinh()
                );
    }
}
