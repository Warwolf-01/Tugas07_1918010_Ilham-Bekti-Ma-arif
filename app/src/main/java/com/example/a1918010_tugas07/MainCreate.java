package com.example.a1918010_tugas07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Edivisi;
    private String Snama, Sdivisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Edivisi = (EditText) findViewById(R.id.create_divisi);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sdivisi = String.valueOf(Edivisi.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Tambahkan Nama Organisasi", Toast.LENGTH_SHORT).show();
                }
                else if (Sdivisi.equals("")) {
                    Edivisi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Tambahkan Divisi Organisasi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Edivisi.setText("");
                    Toast.makeText(MainCreate.this, " Sip !! Data telah Ditambahkan",
                            Toast.LENGTH_SHORT).show();
                    db.CreateOrganisasi(new Organisasi(null, Snama, Sdivisi));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
