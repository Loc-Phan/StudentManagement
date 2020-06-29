/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Lophoc;
import pojo.Monhoc;
import pojo.Phuckhao;
import pojo.Sinhvien;
import util.NewHibernateUtil;

/**
 *
 * @author Chen-Yang
 */
public class PhucKhaoDAO {

    public static Phuckhao layThongTinPhucKhao(int id) {
        Phuckhao phuckhao = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            phuckhao = (Phuckhao) session.get(Phuckhao.class,id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return phuckhao;
    }
    
    
    public static boolean themPhucKhao(Phuckhao phuckhao) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (PhucKhaoDAO.layThongTinPhucKhao(phuckhao.getMaPhucKhao())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phuckhao);
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
    
    public static List<Phuckhao> layDachSachPhucKhao() {
        List<Phuckhao> ds = null;
        Session session = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select pk from Phuckhao pk";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
}
