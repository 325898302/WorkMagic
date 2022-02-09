package com.example.workmagic;

import android.text.InputType;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MagicBoard extends AppCompatActivity {
    private int rashi;
    private int[][] table = new int[4][4];

    public int[][] getTable() {
        return table;
    }

    public MagicBoard(int rashi) {
        this.rashi = rashi;
        int x = rashi;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                table[i][j] = x;
                x++;
                count++;

                if (count % rashi == 0) {
                    x += rashi;
                }

            }
        }

    }

    public TableLayout fillTable() {
        TableLayout tavla = new TableLayout(this);
        tavla.removeAllViews();
        for (int i = 0; i < 4; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < 4; j++) {
                TextView tv = new EditText(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                tv.setText(Double.toString(table[i][j]));

                row.addView(tv);
            }
            tavla.addView(row);
        }
        return tavla;
    }


}

