/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class testAllDAO {

    //userdao
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
//        
//        User user = new User("user_abc0", "khoa0", "abc", "vakhoa4875abc@gmail.com", true, false);
//        
//        dao.insert(user);dao.search("khoa").isEmpty() ?  : dao.search("khoa")
        
        ArrayList<User> userList = dao.select();
        
        for (User u : userList) {
            System.out.println(u.toString());
        }
        
    }
    //sachdao
//    public static void main(String[] args) {
//        SachDAO dao = new SachDAO();
//
//        ArrayList<Sach> list = dao.search("s");
//
//        for (Sach sach : list) {
//            System.out.println(sach.toString());
//        }
//        
//        ArrayList<Sach> list2 = dao.select();
//
//        for (Sach sach : list2) {
//            System.out.println(sach.getTenSach());
//        }
//        
//        Integer i = 10;
//        for (Sach sach : list2) {
//            i++;
//            Sach s2 = new Sach(
//                    sach.getIdSach(), sach.getTenSach().concat(i.toString()), sach.getGiaNiemYet(),
//                    sach.getThumbnail(), sach.getAvatar(), sach.getTrueSizeAvatar(), 
//                    sach.getMoTa(), sach.getDanhGiaTB(), sach.getMinAge(), 
//                    sach.getPdfAvai(), sach.getAudioAvai(), sach.getVersion(), 
//                    sach.getSoTrang(),  sach.getNgonNgu(), sach.getSourcePDF(),
//                    sach.getSourceSound(), sach.getFree(), sach.getLikeCount(), 
//                    sach.getViewCount(), sach.getThoiLuong());
//            
//            dao.update(s2);
//        }
//        
//        list2 = dao.select();
//        for (Sach sach : list2) {
//            System.out.println(sach.getTenSach());
//        }
//
//    }
    
    
}
