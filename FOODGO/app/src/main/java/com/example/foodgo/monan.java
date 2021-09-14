package com.example.foodgo;

public class monan {
    private int hinh;
    private String ten;
    private String mota;
    private int gia, soluong = 0;

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public monan(int hinh, String ten, String mota, int gia, int soluong) {
        this.hinh = hinh;
        this.ten = ten;
        this.mota = mota;
        this.gia = gia;
        this.soluong = soluong;
    }
}
