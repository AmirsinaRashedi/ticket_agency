package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusinessClass extends PlaneSection {

    public BusinessClass() {
        super(20);
    }

    public void findSeat() {
        if (seatsAvailable) {
            try {
                Scanner intInput = new Scanner(System.in);
                boolean seatReserved;

                System.out.print("enter the seat number you want to reserve: ");
                int choice = intInput.nextInt();

                if (choice > 0 && choice < 21) {

                    seatReserved = reserveSeat(choice);

                    if (!seatReserved) {
                        System.out.println("the seat you chose is taken.please select the type of seat uou like.");
                        findNextAvailableSeat();
                    } else
                        System.out.println("your seat number is B" + choice);

                } else {
                    System.out.println("the seat you chose dose not exist.please select the type of seat uou like");
                    findNextAvailableSeat();
                }


            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } else
            System.out.println("no seats available");

    }

    protected void findNextAvailableSeat() {
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
                        System.out.println("your seat number is B" + seatNumber);
                    else
                        System.out.println("no window seats available in business class");
                } else
                    System.out.println("no window seats available in business class");
                break;
            case 2:
                if (aisleSeatAvailable) {
                    int seatNumber = findAisleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is B" + seatNumber);
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
