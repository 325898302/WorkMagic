package com.example.workmagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.workmagic.other.Board;
import com.example.workmagic.R;
import com.example.workmagic.other.ServiceMusic;

public class MagicCardActivity extends AppCompatActivity implements View.OnClickListener {
    int firstNum;
    Board[] board;
    TableLayout tbl;
    int[][] boardNums;
    Button btYes;
    Button btNo;
    int selectNum;
    int numOfBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_card);
        tbl = findViewById(R.id.tbl);
        firstNum = 1;  // המספר החשוב בטבלה
        numOfBoard = 0;
        selectNum = 0;
        btYes = findViewById(R.id.bt1);
        btYes.setOnClickListener(this);
        btNo = findViewById(R.id.bt2);
        btNo.setOnClickListener(this);
        board = new Board[5];   // כמות הטבלאות שיש לי
        drawTable();
    }


    private void drawTable() {
        board[numOfBoard] = new Board(firstNum);
        boardNums = board[numOfBoard].getBoardNums();

        for (int i = 0; i < 4; i++) {
            TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.row_layout, null);

            int j = 0;


            ((TextView) row.findViewById(R.id.column1)).setText(String.format("%10d", boardNums[i][j]));
            j++;
            ((TextView) row.findViewById(R.id.column2)).setText( String.format("%10d", boardNums[i][j]));
            j++;
            ((TextView) row.findViewById(R.id.column3)).setText(String.format("%10d", boardNums[i][j]));
            j++;
            ((TextView) row.findViewById(R.id.column4)).setText(String.format("%10d", boardNums[i][j]));
            tbl.addView(row);
        }
        tbl.requestLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nomain, menu);
        SharedPreferences sp;
        MenuItem i = menu.findItem(R.id.music);
        sp = getSharedPreferences("sound", 0);
        if(sp.getBoolean("music", true)) {
            i.setIcon(R.drawable.musicyes);
        } else {
            i.setIcon(R.drawable.musicno);
        }
        i = menu.findItem(R.id.phone); // מעלים את הכפתור של phone
        i.setVisible(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == R.id.rash) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("app", true);
            startActivity(intent);
        }

        if (id == R.id.music) {
            SharedPreferences sp;
            sp = getSharedPreferences("sound", 0);
            SharedPreferences.Editor editor = sp.edit();
            if (sp.getBoolean("music", true)) {
                item.setIcon(R.drawable.musicno);
                stopService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", false);
            } else {
                item.setIcon(R.drawable.musicyes);
                startService(new Intent(this, ServiceMusic.class));
                editor.putBoolean("music", true);
            }
            editor.apply();
        }

        return true;
    }

    @Override
    public void onClick(View v) {

        if (v == btYes) {
            board[numOfBoard].setIsNumInBoard(true);
            selectNum += firstNum;
            if (numOfBoard < 4) {
                numOfBoard++;
                firstNum *= 2;
                tbl.removeAllViews();
                drawTable();
            } else {

                Intent intent = new Intent(this, NumDiscoveryActivity.class);
                intent.putExtra("selectNum", selectNum);
                startActivity(intent);
            }
        }


        if (v == btNo) {
            board[numOfBoard].setIsNumInBoard(false);

            if (numOfBoard < 4) {
                numOfBoard++;
                firstNum *= 2;
                tbl.removeAllViews();
                drawTable();
            } else {
                Intent intent = new Intent(this, NumDiscoveryActivity.class);
                intent.putExtra("selectNum", selectNum);
                startActivity(intent);
            }
        }

    }
}

