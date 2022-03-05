package com.example.workmagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MagicCardActivity extends AppCompatActivity implements View.OnClickListener {
    int firstNum;
    BoardActivity[] board;
    TableLayout tbl;
    int[][] boardNums;
    Button bt1;
    Button bt2;
    int selectNum;
    int numOfBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_card);
        tbl = findViewById(R.id.tbl);
        firstNum = 1;
        numOfBoard = 0;
        selectNum = 0;
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        board = new BoardActivity[5];   // במות הטבלאות שיש לי
        drawTable();
    }

    private void drawTable() {
        board[numOfBoard] = new BoardActivity(firstNum);
        boardNums = board[numOfBoard].getBoardNums();

        for (int i = 0; i < 4; i++) {
            TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.row_layout, null);

            int j = 0;


            ((TextView) row.findViewById(R.id.tv1)).setText("  " + boardNums[i][j]);
            j++;
            ((TextView) row.findViewById(R.id.tv2)).setText("   " + boardNums[i][j]);
            j++;
            ((TextView) row.findViewById(R.id.tv3)).setText("   " + boardNums[i][j]);
            j++;
            ((TextView) row.findViewById(R.id.tv4)).setText("   " + boardNums[i][j]);
            tbl.addView(row);
        }

        tbl.requestLayout();
    }

    @Override
    public void onClick(View v) {

        if (v == bt1) {
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


        if (v == bt2) {
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

