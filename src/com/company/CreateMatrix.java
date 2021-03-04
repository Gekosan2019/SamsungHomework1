package com.company;

public class CreateMatrix {
    private int number;
    private int seats;
    private String[][] array;
    CreateMatrix(int number,int seats) {
        this.number = number;
        this.seats = seats;
    }

    public void createMatrix(String[][] array){
        this.array = array;
        for (int i = 1; i < seats + 1; ++i) {
            array[0][i] = Integer.toString(i);
        }
        for (int i = 1; i < number + 1; ++i) {
            array[i][0] = Integer.toString(i);
            for (int j = 1; j < seats + 1; ++j) {
                array[i][j] = "S";
            }
        }
    }
    public String[][] getMatrix() {
        return array;
    }

    public void printMatrix() {
        System.out.println("Cinema:");
        for (int i = 0; i < number + 1; ++i) {
            for (int j = 0; j < seats + 1; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
