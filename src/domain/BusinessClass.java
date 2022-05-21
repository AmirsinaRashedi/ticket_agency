package domain;

import java.util.Scanner;

public class BusinessClass {
    private boolean[] seats;
    private boolean aisleSeatAvailable;
    private boolean windowSeatAvailable;

    public BusinessClass() {
        seats = new boolean[20];
        initSeats();
        aisleSeatAvailable = true;
        windowSeatAvailable = true;
    }

    private void initSeats() {
        for (int i = 0; i < 20; i++)
            seats[i] = false;
    }

    public void findSeat() {
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
                }
                break;
            case 2:
                if (aisleSeatAvailable) {
                    int seatNumber = findAisleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is " + seatNumber);
                    else
                        System.out.println("no aisle seats available in business class");
                }
                break;
            default:
                System.out.println("invalid input");
        }
    }

    private int findAisleSeat() {
        for (int seat = 1; seat < 20 && (seat % 4 == 1 || seat % 4 == 2); seat++) {
            if (!seats[seat]) {
                return seat + 1;
            }
        }
        aisleSeatAvailable = false;
        return 0;
    }

    private int findWindowSeat() {
        for (int seat = 0; seat < 20 && (seat % 4 == 0 || seat % 4 == 3); seat++) {
            if (!seats[seat]) {
                return seat + 1;
            }
        }
        windowSeatAvailable = false;
        return 0;
    }
}
