package com.company;

import java.io.IOException;

public class TotalIncome {
    private static int totalIncome = 0;
    private int buyTicket = 0;
    private int ticketPrice = 0;
    private int number;
    private int seats;
    private String[][] args;

    TotalIncome(int number, int seats){
        this.number = number;
        this.seats = seats;
    }

    public void setMMatrix(String[][] args) {
        this.args = args;
    }

    public String[][] getArgs() {
        return args;
    }

    public  int setTotalIncome() {
        if (number * seats <= 60) {
            totalIncome = number * seats * 10;
        } else {
            totalIncome = number / 2 * seats * 10 + (number - number / 2) * seats * 8;
        }
        return totalIncome;
    }

    public void statistics(){
        System.out.println(String.format("Number of purchased tickets: %d", buyTicket));
        System.out.println(String.format("Percentage: %.2f%c" ,  100 * (float)buyTicket / (number * seats), '%'));
        System.out.println(String.format("Current income: $%d", ticketPrice));
        System.out.println(String.format("Total income: $%d",totalIncome));
    }

    public  void buyTicket(int number1, int number2, int number, int seats){
        CreateMatrix matrix = new CreateMatrix(number, seats);
        boolean fl = true;
        while (fl) {
            if (number1 > number || number2 > seats || number1 <= 0 || number2 <= 0) {
                System.out.println("Wrong input!");
                break;
            } else if (args[number1][number2] == "B") {
                System.out.println("That ticket has already been purchased!");
                break;
            } else {
                fl = false;
                ++buyTicket;
                args[number1][number2] = "B";
                setTicketPrice(number1);
                System.out.println();
            }
        }
    }

    public  void setTicketPrice(int number1) {
        if (number * seats <= 60) {
            System.out.print("Ticket price: ");
            System.out.println("$" + 10);
            ticketPrice += 10;
            totalIncome = number * seats * 10;
        } else {
            totalIncome = number / 2 * seats * 10 + (number - number / 2) * seats * 8;
            if ( number / 2 >= number1 ) {
                System.out.print("Ticket price: ");
                System.out.println("$" + 10);
                ticketPrice += 10;
            } else {
                System.out.print("Ticket price: ");
                System.out.println("$" + 8);
                ticketPrice += 8;
            }
        }
    }

}
