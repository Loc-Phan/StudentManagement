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

/**
 *
 * @author Chen-Yang
 */
public class ThoiKhoaBieuDAO {
    public static List<Monhoc> DocTKB(String path) throws IOException 
    {
        ArrayList ds = new ArrayList<Monhoc>();
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
            
            line = br.readLine(); // bo qua dong chua thong tin
            line = br.readLine(); 
            while(line!=null) {
                String[] arr=line.split(",");
                Monhoc mh = new Monhoc();
                mh.setMaMon(arr[1]);
                mh.setTenMon(arr[2]);
                mh.setPhongHoc(arr[3]);
                
                Lophoc lh = new Lophoc();
                lh.setMaLop(lopHoc);
                lh.setTenLop(lopHoc);
                lh.setLaLopHoc(1);
                mh.setLophoc(lh);
                
                Lophoc lh_ = new Lophoc();
                lh_.setLaLopHoc(0);
                lh_.setMaLop(lopHoc+"-"+arr[1]);
                lh_.setTenLop(lopHoc+"-"+arr[1]);
                SinhVienDAO.themLopHoc(lh_);
                
                ds.add(mh);

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
    public static List<Monhoc> layDachSachTKB() {
        List<Monhoc> ds = null;
        Session session = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select mh from Monhoc mh";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
            session.close();
        }  
            return ds;
    }
    public static Monhoc layThongTinTKB(String mamon) {
        Monhoc mh = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            mh = (Monhoc) session.get(Monhoc.class,mamon);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return mh;
    }
    public static boolean themTKB(Monhoc mh) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (ThoiKhoaBieuDAO.layThongTinTKB(mh.getMaMon())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(mh);
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
    public static boolean themDanhSachTKB(String path) throws IOException {
        List<Monhoc> ds = DocTKB(path);
        if(ds.size()==0) {
            return false;
        }
        for(int i=0;i<ds.size();i++) {
            boolean kq = ThoiKhoaBieuDAO.themTKB(ds.get(i));
            if(kq==false) {
                return false;
            }
        }
        return true;
    }
}
