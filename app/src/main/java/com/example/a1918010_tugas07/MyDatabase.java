package com.example.a1918010_tugas07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kebun";
    private static final String tb_organisasi = "tb_organisasi";
    private static final String tb_organisasi_id = "id";
    private static final String tb_organisasi_nama = "nama";
    private static final String tb_organisasi_divisi = "kelas";
    private static final String CREATE_TABLE_ORGANISASI = "CREATE TABLE "
            + tb_organisasi +"("
            + tb_organisasi_id + " INTEGER PRIMARY KEY ,"
            + tb_organisasi_nama + " TEXT ,"
            + tb_organisasi_divisi + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORGANISASI);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateOrganisasi(Organisasi data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_organisasi_id, data.get_id());
        values.put(tb_organisasi_nama, data.get_nama());
        values.put(tb_organisasi_divisi, data.get_divisi());
        db.insert(tb_organisasi, null, values);
        db.close();
    }
    public List<Organisasi> ReadOrganisasi() {
        List<Organisasi> listMhs = new ArrayList<Organisasi>();
        String selectQuery = "SELECT * FROM " + tb_organisasi;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Organisasi data = new Organisasi();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_divisi(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateOrganisasi (Organisasi data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_organisasi_nama, data.get_nama());
        values.put(tb_organisasi_divisi, data.get_divisi());
        return db.update(tb_organisasi, values, tb_organisasi_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteOrganisasi(Organisasi data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_organisasi,tb_organisasi_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
