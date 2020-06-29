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
public class DocFileDiemCSV {
    private String lop;
    private String mssv;
    private float diemGK;
    private float diemCK;
    private float diemKhac;
    private float diemTong;

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setDiemGK(float diemGK) {
        this.diemGK = diemGK;
    }

    public void setDiemCK(float diemCK) {
        this.diemCK = diemCK;
    }

    public void setDiemKhac(float diemKhac) {
        this.diemKhac = diemKhac;
    }

    public void setDiemTong(float diemTong) {
        this.diemTong = diemTong;
    }

    public String getLop() {
        return lop;
    }

    public String getMssv() {
        return mssv;
    }

    public float getDiemGK() {
        return diemGK;
    }

    public float getDiemCK() {
        return diemCK;
    }

    public float getDiemKhac() {
        return diemKhac;
    }

    public float getDiemTong() {
        return diemTong;
    }
    
    public DocFileDiemCSV(){
        
    }
}
