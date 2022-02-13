package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

public class MagicCard extends AppCompatActivity {
    int x = 1;

    TableLayout tbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_card);
        tbl= findViewById(R.id.tbl);
        MagicBoard mb = new MagicBoard(1);
        TableLayout t = mb.fillTable();





    }
}