/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Chen-Yang
 */
public class QuanLyDate {
    private int dd;
    private int mm;
    private int yyyy;

    public int getDd() {
        return dd;
    }

    public int getMm() {
        return mm;
    }

    public int getYyyy() {
        return yyyy;
    }


    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    public QuanLyDate() {
        dd = 1;
        mm = 1;
        yyyy = 1;
    }

    public QuanLyDate(int y, int m, int d) {
        dd = d;
        mm = m;
        yyyy = y;
    }
    public static boolean compareDatePre(QuanLyDate date, QuanLyDate date_) {
        if(date.getYyyy()<date_.getYyyy())
            return true;
        else if(date.getYyyy()==date_.getYyyy() && date.getMm()<date_.getMm())
            return true;
        else if(date.getYyyy()==date_.getYyyy() && date.getMm()==date_.getMm() && date.getDd()<=date_.getDd())
            return true;
        return false;
    }
}
