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
public class SachPDF {
    private Integer idReadlist;
    private String idSach;
    private Integer lastSeenPage;
    private LocalDateTime addedTime;

    public SachPDF() {
    }

    public SachPDF(Integer idReadlist, String idSach, Integer lastSeenPage, LocalDateTime addedTime) {
        this.idReadlist = idReadlist;
        this.idSach = idSach;
        this.lastSeenPage = lastSeenPage;
        this.addedTime = addedTime;
    }

    public Integer getIdReadlist() {
        return idReadlist;
    }

    public void setIdReadlist(Integer idReadlist) {
        this.idReadlist = idReadlist;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public Integer getLastSeenPage() {
        return lastSeenPage;
    }

    public void setLastSeenPage(Integer lastSeenPage) {
        this.lastSeenPage = lastSeenPage;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }
    
    
}
