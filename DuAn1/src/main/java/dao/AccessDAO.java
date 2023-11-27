/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import library.Jdbc;
import model.Access;

/**
 *
 * @author TAN LOC
 */
public class AccessDAO {

    public void insert(Access ac) {
        String sql = "INSERT INTO [Access] (idAccess, moTa, fullAccess, rReadList, uReadList, rWishList, uWishList, rUser, uUser, rPhongBan, uPhongBan, rSach, uSach, rReader, uReader, rNoiBo, uNoiBo, rTacGia, uTacGia, rTheLoai, uTheLoai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        Jdbc.executeUpdate(sql,
            ac.getIdAccess(),
            ac.getMoTa(),
            ac.getFullAccess(),
            ac.getrReadlist(),
            ac.getuReadlist(),
            ac.getrWishlist(),
            ac.getuWishlist(),
            ac.getrUser(),
            ac.getuUser(),
            ac.getrPhongBan(),
            ac.getuPhongBan(),
            ac.getrSach(),
            ac.getuSach(),
            ac.getrReader(),
            ac.getuReader(),
            ac.getrNoiBo(),
            ac.getuNoiBo(),
            ac.getrTacGia(),
            ac.getuTacGia(),
            ac.getrTheLoai(),
            ac.getuTheLoai()
    );
    }
}
