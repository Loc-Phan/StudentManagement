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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import pojo.Lophoc;
import pojo.Sinhvien;

/**
 *
 * @author Chen-Yang
 */
public class DocDiem {
   public static List<DocFileDiemCSV> DocDSSV(String path) throws IOException 
    {
        List<DocFileDiemCSV> ds = new ArrayList<DocFileDiemCSV>();
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
                DocFileDiemCSV diem = new DocFileDiemCSV();
                
                diem.setLop(lopHoc);
                diem.setMssv(arr[1]);
                diem.setDiemGK(Float.parseFloat(arr[3]));
                diem.setDiemCK(Float.parseFloat(arr[4]));
                diem.setDiemKhac(Float.parseFloat(arr[5]));
                diem.setDiemTong(Float.parseFloat(arr[6]));
                
                ds.add(diem);
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
}
