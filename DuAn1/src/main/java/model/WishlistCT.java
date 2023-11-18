/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDateTime;

/**
 * 
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class WishlistCT {
    private Integer idWishlist;
    private String idSach;
    private LocalDateTime addedTime;

    public WishlistCT() {
    }

    public WishlistCT(Integer idWishlist, String idSach, LocalDateTime addedTime) {
        this.idWishlist = idWishlist;
        this.idSach = idSach;
        this.addedTime = addedTime;
    }

    public Integer getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Integer idWishlist) {
        this.idWishlist = idWishlist;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }    
    
}
