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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chen-Yang
 */
public class AccountDAO {
    public static List<Account> DocAccount(String path) throws IOException 
    {
        List<Account> dsAccount = new ArrayList<Account>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            //int brr = br.read();

            String line = br.readLine(); 
            
            while(line!=null) {
                String[] arr=line.split(",");
                Account acc = new Account();
                acc.setMatKhau(arr[1]);
                acc.setTenDN(arr[0]);
                dsAccount.add(acc);
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
        return dsAccount;      
    }
    public static boolean GhiAccount(String path,List<Account> dsAccount){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            //bw.newLine();
            for(Account acc:dsAccount) {
                String line=acc.getTenDN()+","+acc.getMatKhau();
                bw.write(line);
                bw.newLine();
            }
            
            bw.close();
            osw.close();
            fos.close();
            return true;
        }catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean Search(Account acc, List<Account> ds) {
        for(int i=0;i<ds.size();i++) {
            if(acc.getTenDN().compareTo(ds.get(i).getTenDN())==0 && acc.getMatKhau().compareTo(ds.get(i).getMatKhau())==0) {
                return true;
            }
        }
        return false;
    }
    public static int Index(Account acc, List<Account> ds) {
        for(int i=0;i<ds.size();i++) {
            if(acc.getTenDN().compareTo(ds.get(i).getTenDN())==0 && acc.getMatKhau().compareTo(ds.get(i).getMatKhau())==0) {
                return i;
            }
        }
        return -1;
    }
}
