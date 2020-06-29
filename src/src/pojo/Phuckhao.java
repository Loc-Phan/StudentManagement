package pojo;
// Generated Jun 21, 2020 2:02:39 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Phuckhao generated by hbm2java
 */
public class Phuckhao  implements java.io.Serializable {


     private int maPhucKhao;
     private Date ngayBatDau;
     private Date ngayKetThuc;
     private Set chitietphuckhaos = new HashSet(0);

    public Phuckhao() {
    }

	
    public Phuckhao(int maPhucKhao, Date ngayBatDau, Date ngayKetThuc) {
        this.maPhucKhao = maPhucKhao;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    public Phuckhao(int maPhucKhao, Date ngayBatDau, Date ngayKetThuc, Set chitietphuckhaos) {
       this.maPhucKhao = maPhucKhao;
       this.ngayBatDau = ngayBatDau;
       this.ngayKetThuc = ngayKetThuc;
       this.chitietphuckhaos = chitietphuckhaos;
    }
   
    public int getMaPhucKhao() {
        return this.maPhucKhao;
    }
    
    public void setMaPhucKhao(int maPhucKhao) {
        this.maPhucKhao = maPhucKhao;
    }
    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }
    
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }
    
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public Set getChitietphuckhaos() {
        return this.chitietphuckhaos;
    }
    
    public void setChitietphuckhaos(Set chitietphuckhaos) {
        this.chitietphuckhaos = chitietphuckhaos;
    }




}


