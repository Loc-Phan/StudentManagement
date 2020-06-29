/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import pojo.Lophoc;
import pojo.Sinhvien;

/**
 *
 * @author Chen-Yang
 */
public class Account {
    private String tenDN;
    private String matKhau;

    public Account() {
        this.tenDN="";
        this.matKhau="";
    }
    

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenDN() {
        return tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    /**
     *
     */
    
    Account(String ten, String mat) {
        this.tenDN=ten;
        this.matKhau=mat;
    }
    
    
}
