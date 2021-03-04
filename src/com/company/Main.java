package com.company;

import java.io.*;

public class Main {
    static int buyTicket = 0;
    static int ticketPrice = 0;
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of rows:");
        int number = stringParseToInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = stringParseToInt();
        CreateMatrix matrix = new CreateMatrix(number, seats);
        String[][] array = new String[number + 1][seats + 1];
        matrix.createMatrix(array);
        TotalIncome totalIncome = new TotalIncome(number, seats);

        while (true) {
            toShowMenu();
            int menuNumber = stringParseToInt();
            if (menuNumber == 1) {
                matrix.printMatrix();
                System.out.println();
            } else if (menuNumber == 2) {
                System.out.println("Enter the number of rows:");
                int number1 = stringParseToInt();
                System.out.println("Enter the number of seats in each row:");
                int number2 = stringParseToInt();
                totalIncome.setMMatrix(array);
                totalIncome.buyTicket(number1, number2, number, seats);
                array = totalIncome.getArgs();
            } else if (menuNumber == 3){
                totalIncome.statistics();
            } else if (menuNumber == 0) {
                break;
            }
        }
    }


    public static void toShowMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static int stringParseToInt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        return Integer.parseInt(name);
    }



}

