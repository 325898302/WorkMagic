package com.example.workmagic;

public class MagicBoard {
    private int rashi;
    private int[][] table = new int[4][4];

    public int[][] getTable() {
        return table;
    }

    public MagicBoard(int rashi) {
        this.rashi = rashi;
        int x= rashi;
        int count = 0;

        for (int i = 0; i< 4; i++) {
            for (int j = 0; j< 4; j++) {
                    table[i][j]= x;
                    x++;
                    count++;

                    if (count%rashi == 0) {
                        x += rashi;
                    }

            }
        }

    }


}

