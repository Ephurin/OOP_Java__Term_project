/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lapbangtinhcong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hieu Nguyen
 */
public class Lapbangtinhcong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<nhanvien> arr=new ArrayList<>();
        while(n-->0){
            String hoten=sc.nextLine();
            long luongcb=sc.nextLong();
            byte songaycong=sc.nextByte();
            sc.nextLine();
            String chucvu=sc.nextLine();
            nhanvien a=new nhanvien(hoten,luongcb,songaycong,chucvu);
            arr.add(a);
        }
        for (nhanvien a:arr){
            a.hienthi();
        }
    }
    
}
