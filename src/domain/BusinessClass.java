package domain;

import java.util.Scanner;

public class BusinessClass {
    private boolean[] seats;
    private boolean aisleSeatAvailable;
    private boolean windowSeatAvailable;
    private int previousAisleSeat;
    private int previousWindowSeat;

    public BusinessClass() {
        seats = new boolean[20];
        initSeats();
        aisleSeatAvailable = true;
        windowSeatAvailable = true;
        previousWindowSeat = 0;
        previousAisleSeat = 1;
    }

    private void initSeats() {
        for (int i = 0; i < 20; i++)
            seats[i] = false;
    }

    public void findSeat() {
        System.out.println();
        System.out.println("1- window seat");
        System.out.println("2- aisle seat");
        System.out.print("choose: ");
        Scanner intInput = new Scanner(System.in);
        int choice = intInput.nextInt();
        switch (choice) {
            case 1:
                if (windowSeatAvailable) {
                    int seatNumber = findWindowSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is " + seatNumber);
                    else
                        System.out.println("no window seats available in business class");
                } else
                    System.out.println("no window seats available in business class");
                break;
            case 2:
                if (aisleSeatAvailable) {
                    int seatNumber = findAisleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is " + seatNumber);
                    else
                        System.out.println("no aisle seats available in business class");
                } else
                    System.out.println("no aisle seats available in business class");
                break;
            default:
                System.out.println("invalid input");
        }
    }

    private int findAisleSeat() {
        for (int seat = previousAisleSeat; seat < 20; seat++) {
            if (seat % 4 == 1 || seat % 4 == 2) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    previousAisleSeat = seat;
                    return seat + 1;
                }
            }
        }
        aisleSeatAvailable = false;
        return 0;
    }

    private int findWindowSeat() {
        for (int seat = previousWindowSeat; seat < 20; seat++) {
            if (seat % 4 == 0 || seat % 4 == 3) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    previousWindowSeat = seat;
                    return seat + 1;
                }
            }

        }
        windowSeatAvailable = false;
        return 0;
    }

    public void printSeats() {
        for (int i = 0; i < 20; i++) {
            if (i % 4 == 0)
                System.out.println();
            if (seats[i])
                System.out.print("X");
            else
                System.out.print("O");
            if (i % 2 == 1)
                System.out.print("   ");
            else
                System.out.print(" ");
        }
    }
}
