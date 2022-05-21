package domain;

import java.util.Scanner;

public class Economy {
    private boolean[] seats;
    private boolean windowSeatAvailable;
    private boolean aisleSeatAvailable;
    private boolean middleSeatAvailable;

    public Economy() {
        seats = new boolean[90];
        initSeats();
        windowSeatAvailable = true;
        aisleSeatAvailable = true;
        middleSeatAvailable = true;
    }

    public void findSeat() {
        System.out.println();
        System.out.println("1- window seat");
        System.out.println("2- aisle seat");
        System.out.println("3- middle seat");
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
                        System.out.println("no window seats available in economy");
                }
                break;
            case 2:
                if (aisleSeatAvailable) {
                    int seatNumber = findAisleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is " + seatNumber);
                    else
                        System.out.println("no aisle seats available in economy");
                }
                break;
            case 3:
                if (middleSeatAvailable) {
                    int seatNumber = findMiddleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is " + seatNumber);
                    else
                        System.out.println("no middle seats available in economy");
                }
                break;
            default:
                System.out.println("invalid input");
        }
    }

    private int findMiddleSeat() {
        for (int seat = 1; seat < 90; seat++) {
            if (seat % 6 == 1 || seat % 6 == 4) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    return seat + 1;
                }
            }
        }
        middleSeatAvailable = false;
        return 0;
    }

    private int findAisleSeat() {
        for (int seat = 2; seat < 90; seat++) {
            if (seat % 6 == 2 || seat % 6 == 3) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    return seat + 1;
                }
            }
        }
        aisleSeatAvailable = false;
        return 0;
    }

    private int findWindowSeat() {
        for (int seat = 0; seat < 90; seat++) {
            if (seat % 6 == 0 || seat % 6 == 5) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    return seat + 1;
                }
            }

        }
        windowSeatAvailable = false;
        return 0;
    }

    private void initSeats() {
        for (int i = 0; i < 90; i++)
            seats[i] = false;
    }

    public void printSeats() {
        for (int i = 0; i < 90; i++) {
            if (i % 6 == 0)
                System.out.println();
            if (seats[i])
                System.out.print("X");
            else
                System.out.print("O");
            if (i % 3 == 2)
                System.out.print("   ");
        }
    }
}
