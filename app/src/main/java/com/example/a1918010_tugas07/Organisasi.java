package com.example.a1918010_tugas07;

public class Organisasi {
    private String _id, _nama, _divisi;
    public Organisasi (String id, String nama, String divisi) {
        this._id = id;
        this._nama = nama;
        this._divisi = divisi;
    }
    public Organisasi() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_divisi() {
        return _divisi;
    }
    public void set_divisi(String _divisi) {
        this._divisi = _divisi;
    }

}
