/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.*;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.hibernate.Session;

public class SinhVienDAO {
    public static List<Sinhvien> DocDSSV(String path) throws IOException 
    {
        ArrayList ds = new ArrayList<Sinhvien>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            int brr = br.read();
            String line = br.readLine();
            String[] lopHoc_ = line.split(",");
            String lopHoc = lopHoc_[0];
            
            Lophoc lh = new Lophoc();
            lh.setMaLop(lopHoc);
            lh.setTenLop(lopHoc);
            lh.setLaLopHoc(1);
            SinhVienDAO.themLopHoc(lh);
            
            line = br.readLine(); // bo qua dong chua thong tin
            line = br.readLine(); 
            while(line!=null) {
                String[] arr=line.split(",");
                Sinhvien sv = new Sinhvien();
                
                sv.setMssv(arr[1]);
                sv.setHoTen(arr[2]);
                sv.setGioiTinh(arr[3]);
                sv.setCmnd(arr[4]);
                sv.setMatKhau(arr[1]);
                sv.setLophoc(lh);
                ds.add(sv);
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        }  finally {
            br.close();
            isr.close();
            fis.close();
        }  
        return ds;      
    }
         
    public static List<Sinhvien> layDachSachSinhVien() {
        List<Sinhvien> ds = null;
        Session session = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select sv from Sinhvien sv";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
            session.close();
        }  
            return ds;
    }
   
    public static List<Lophoc> layDachSachLop() {
        List<Lophoc> lh = null;
        Session session = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select lh from Lophoc lh";
            Query query = session.createQuery(hql);
            lh = query.list();
        } catch (HibernateException ex) {
    
        System.err.println(ex);
        } finally {
            session.close();
        }  
            return lh;
    }
    public static Sinhvien layThongTinSinhVien(String mssv) {
        Sinhvien sv = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            sv = (Sinhvien) session.get(Sinhvien.class,mssv);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }
    
    
    public static boolean themSinhVien(Sinhvien sv) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMssv())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static boolean capNhatThongTinSinhVien(Sinhvien sv) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMssv()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static boolean xoaSinhVien(String maSinhVien) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Sinhvien sv = SinhVienDAO.layThongTinSinhVien(maSinhVien);
        if(sv==null){
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
    return true;
    }
    
    public static Lophoc layThongTinLopHoc(String malop) {
        Lophoc lh = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            lh = (Lophoc) session.get(Lophoc.class,malop);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lh;
    }
    public static boolean themLopHoc(Lophoc lh) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinLopHoc(lh.getMaLop())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(lh);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static boolean themDanhSachSinhVien(String path) throws IOException {
        List<Sinhvien> ds  = DocDSSV(path);
        if(ds.size()==0) {
            return false;
        }
        for(int i=0;i<ds.size();i++) {
            SinhVienDAO.themSinhVien(ds.get(i));
        }
        
        return true;
    }
    
}
