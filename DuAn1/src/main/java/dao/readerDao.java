/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.Jdbc;
import model.Reader;

/**
 *
 * @author TAN LOC
 */
public class readerDao {

    public void update(Reader reader) {
        String upDateQuery = "UPDATE Reader SET thanthiet = ?,  tichDiem = ?, ngaySinh = ?, avatar = ?, hoTen = ?, gioiTinh = ? WHERE idReader = ?";
        Jdbc.executeUpdate(upDateQuery,
                reader.getThanThiet(),
                reader.getTichDiem(),
                reader.getNgaySinh(),
                reader.getAvatar(),
                reader.getHoTen(),
                reader.getGioitinh(),
                reader.getIdReader());
    }
    
    public ArrayList<Reader> selectALL(){
        String selectALl = "select * from reader";
        return select(selectALl);
    }
    
    public Reader selectByID(String id) {
        String selectByid = "select * from reader where idreader = ?";
        ArrayList<Reader> readerList = select(selectByid, id);
        return !readerList.isEmpty() ? readerList.get(0) : null;
    }

    private ArrayList<Reader> select(String sql , Object ... args){
        ArrayList<Reader> readerList = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Reader reader = readFromRS(rs);
                    readerList.add(reader);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        return readerList;
    } 
    
    
    
    
    
    
    
    private Reader readFromRS(ResultSet resultSet) throws SQLException {
        Reader reader = new Reader(
                resultSet.getString("idReader"),
                resultSet.getBoolean("thanthiet"),
                resultSet.getInt("tichDiem"),
                resultSet.getDate("ngaySinh"),
                resultSet.getString("avatar"),
                resultSet.getString("hoTen"),
                resultSet.getBoolean("gioiTinh")
        );
        return reader;
    }

}
