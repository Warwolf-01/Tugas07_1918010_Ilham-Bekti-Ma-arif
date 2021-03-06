package com.example.a1918010_tugas07;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Organisasi> Organisasi;
    public CustomListAdapter(Activity activity, List<Organisasi> Organisasi) {
        this.activity = activity;
        this.Organisasi = Organisasi;
    }
    @Override
    public int getCount() {
        return Organisasi.size();
    }
    @Override
    public Object getItem(int location) {
        return Organisasi.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_divisi);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Organisasi t = Organisasi.get(position);
        nama.setText("Nama Organisasi : "+ t.get_nama());
        kelas.setText("Divisi Organisasi : "+ t.get_divisi());
        return convertView;
    }
}

