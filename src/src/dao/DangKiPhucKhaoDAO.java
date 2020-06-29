/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Chitietphuckhao;
import pojo.Phuckhao;
import util.NewHibernateUtil;

/**
 *
 * @author Chen-Yang
 */
public class DangKiPhucKhaoDAO {
    public static Chitietphuckhao layThongTinDangKiPhucKhao(int id) {
        Chitietphuckhao phuckhao = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            phuckhao = (Chitietphuckhao) session.get(Chitietphuckhao.class,id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return phuckhao;
    }
    
    
    public static boolean themDangKiPhucKhao(Chitietphuckhao ct) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (DangKiPhucKhaoDAO.layThongTinDangKiPhucKhao(ct.getId())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ct);
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
    
    public static List<Chitietphuckhao> layDachSachDangKiPhucKhao() {
        List<Chitietphuckhao> ds = null;
        Session session = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select dk from Chitietphuckhao dk";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static boolean capNhatThongTinDKPK(Chitietphuckhao ctpk) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (DangKiPhucKhaoDAO.layThongTinDangKiPhucKhao(ctpk.getId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(ctpk);
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

}
