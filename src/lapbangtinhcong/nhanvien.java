/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lapbangtinhcong;

/**
 *
 * @author Hieu Nguyen
 */
public class nhanvien {
    private String manv,hoten;
    private long luongcb;
    private byte songaycong;
    private String chucvu;
    private long thuong;
    private int phucap;
    private long thunhap;
    private long luongthang;
    private static int stt=1;
    public nhanvien(String hoten,long luongcb,byte songaycong,String chucvu ){
        this.manv=String.format("NV%02d", stt++);
        this.hoten=hoten;
        this.luongcb=luongcb;
        this.songaycong=songaycong;
        this.chucvu=chucvu;
        this.luongthang=this.luongcb*this.songaycong;
        this.thuong=tinhthuong();
        this.phucap=tinhphucap();
        this.thunhap=tinhthunhap();
    }
    private long tinhthuong(){
        if(songaycong>=25){
            return (long) (luongthang*0.2);
        }
        else if(songaycong>=22){
            return (long) (luongthang*0.1);
        }
        else{
            return 0;
        }             
    }
    private int tinhphucap(){
        if( chucvu.equals("GD")){
            return 250000;
        }
        else if(chucvu.equals("PGD")){
            return 200000;
        }
        else if(chucvu.equals("TP")){
            return 180000;
        }
        else{
            return 150000;
        }
    }
    private long tinhthunhap(){
        return (long) (luongthang+ thuong+phucap);
    }
    public void hienthi(){
        System.out.printf("%s %s %d %d %d %d\n", manv,hoten,luongthang,thuong,phucap,thunhap);
    }
}

