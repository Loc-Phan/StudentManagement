/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.*;

import pojo.*;
import form.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Chen-Yang
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Login login = new Login();
        login.setVisible(true);
    }
    
}
