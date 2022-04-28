package com.example.workmagic;

public class Board {
    private int firstNum;
    private int[][] boardNums;
    private boolean isNumInBoard;

    public Board(int firstNum) {
        this.firstNum = firstNum;
        this.boardNums = new int[4][4];
        this.isNumInBoard = false;
        BuildTable();
    }

    private int[][] BuildTable() {
        int x = firstNum;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardNums[i][j] = x;
                x++;
                count++;

                if (count % firstNum == 0) {
                    x += firstNum;
                }
            }
        }
        return boardNums;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int[][] getBoardNums() {
        return boardNums;
    }

    public void setBoardNums(int[][] arr) {
        this.boardNums = arr;
    }

    public boolean getIsNumInBoard() {
        return this.isNumInBoard;
    }

    public void setIsNumInBoard(boolean isNumInBoard) {
        this.isNumInBoard = isNumInBoard;
    }


    @Override
    public String toString() {
        return "Board {" + "firstNum=" + firstNum + ", isNumInBoard=" + isNumInBoard + '}';
    }
}
