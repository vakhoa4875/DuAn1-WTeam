/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * 
 * @author Vu Anh Khoa <vakhoa4875@gmail.com>
 */
public class SachNoi {
    private Integer idReadlist;
    private String idSach;
    private Time lastLeft;
    private LocalDateTime addedTime;

    public SachNoi(Integer idReadlist, String idSach, Time lastLeft, LocalDateTime addedTime) {
        this.idReadlist = idReadlist;
        this.idSach = idSach;
        this.lastLeft = lastLeft;
        this.addedTime = addedTime;
    }

    public SachNoi() {
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

    public Time getLastLeft() {
        return lastLeft;
    }

    public void setLastLeft(Time lastLeft) {
        this.lastLeft = lastLeft;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }
    
}
