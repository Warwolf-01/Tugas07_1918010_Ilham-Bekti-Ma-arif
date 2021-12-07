package com.example.a1918010_tugas07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sdivisi;
    private EditText Enama, Edivisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sdivisi = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Edivisi = (EditText) findViewById(R.id.updel_divisi);
        Enama.setText(Snama);
        Edivisi.setText(Sdivisi);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sdivisi = String.valueOf(Edivisi.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama tumbuhan", Toast.LENGTH_SHORT).show();
                } else if (Sdivisi.equals("")){
                    Edivisi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga tumbuhan", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateOrganisasi(new Organisasi(Sid, Snama, Sdivisi));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteOrganisasi(new Organisasi(Sid, Snama, Sdivisi));
                Toast.makeText(MainUpdel.this, "Data telah tumbuhan dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

