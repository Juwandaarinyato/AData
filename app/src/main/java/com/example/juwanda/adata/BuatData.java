package com.example.juwanda.adata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);;
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (text1.length() == 0 ) {
                    text1.setError("Harap Mengisi Nomor");
                    Toast.makeText(getApplicationContext(), "Gagal ditambahkan !", Toast.LENGTH_LONG).show();
                    return;
               } else {
                   SQLiteDatabase db = dbHelper.getWritableDatabase();
                   db.execSQL("insert into Adata(no, nama, hp, jk, alamat) values('" +
                           text1.getText().toString() + "','" +
                           text2.getText().toString() + "','" +
                           text3.getText().toString() + "','" +
                           text4.getText().toString() + "','" +
                           text5.getText().toString() + "')");
                   Toast.makeText(getApplicationContext(), "Berhasil ditambahkan", Toast.LENGTH_LONG).show();
                   MainActivity.ma.RefreshList();
                   finish();
               }
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

}