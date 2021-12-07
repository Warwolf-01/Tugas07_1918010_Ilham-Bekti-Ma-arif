package com.example.a1918010_tugas07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Organisasi> ListOrganisasi = new ArrayList<Organisasi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListOrganisasi);
        mListView = (ListView) findViewById(R.id.list_organisasi);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListOrganisasi.clear();
        List<Organisasi> organisasi = db.ReadOrganisasi();
        for (Organisasi tmh : organisasi) {
            Organisasi daftar = new Organisasi();
            daftar.set_id(tmh.get_id());
            daftar.set_nama(tmh.get_nama());
            daftar.set_divisi(tmh.get_divisi());
            ListOrganisasi.add(daftar);
            if ((ListOrganisasi.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Organisasi detailTmh = (Organisasi) o;
        String Sid = detailTmh.get_id();
        String Snama = detailTmh.get_nama();
        String Sdivisi = detailTmh.get_divisi();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Idivisi", Sdivisi);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListOrganisasi.clear();
        mListView.setAdapter(adapter_off);
        List<Organisasi> organisasi = db.ReadOrganisasi();
        for (Organisasi tmh : organisasi) {
            Organisasi daftar = new Organisasi();
            daftar.set_id(tmh.get_id());
            daftar.set_nama(tmh.get_nama());
            daftar.set_divisi(tmh.get_divisi());
            ListOrganisasi.add(daftar);
            if ((ListOrganisasi.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
