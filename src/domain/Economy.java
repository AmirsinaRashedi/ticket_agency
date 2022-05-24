package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Economy extends PlaneSection {
    private boolean middleSeatAvailable;
    private int previousMiddleSeat;

    public Economy() {
        super(90);
        previousMiddleSeat = 1;
    }

    public void findSeat() {
        if (seatsAvailable) {
            try {
                Scanner intInput = new Scanner(System.in);
                boolean seatReserved;

                System.out.print("enter the seat number you want to reserve: ");
                int choice = intInput.nextInt();

                if (choice > 0 && choice < 91) {

                    seatReserved = reserveSeat(choice);

                    if (!seatReserved) {
                        System.out.println("the seat you chose is taken.please select the type of seat uou like.");
                        findNextAvailableSeat();
                    } else
                        System.out.println("your seat number is E" + choice);

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
        System.out.println("3- middle seat");
        System.out.print("choose: ");
        Scanner intInput = new Scanner(System.in);
        int choice = intInput.nextInt();
        switch (choice) {
            case 1:
                if (windowSeatAvailable) {
                    int seatNumber = findWindowSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is E" + seatNumber);
                    else
                        System.out.println("no window seats available in economy");
                } else
                    System.out.println("no window seats available in economy");
                break;
            case 2:
                if (aisleSeatAvailable) {
                    int seatNumber = findAisleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is E" + seatNumber);
                    else
                        System.out.println("no aisle seats available in economy");
                } else
                    System.out.println("no aisle seats available in economy");
                break;
            case 3:
                if (middleSeatAvailable) {
                    int seatNumber = findMiddleSeat();
                    if (seatNumber != 0)
                        System.out.println("your seat number is E" + seatNumber);
                    else
                        System.out.println("no middle seats available in economy");
                } else
                    System.out.println("no middle seats available in economy");
                break;
            default:
                System.out.println("invalid input");
        }
    }

    private int findMiddleSeat() {
        for (int seat = previousMiddleSeat; seat < 90; seat++) {
            if (seat % 6 == 1 || seat % 6 == 4) {
                if (!seats[seat]) {
                    previousMiddleSeat = seat;
                    seats[seat] = true;
                    return seat + 1;
                }
            }
        }
        middleSeatAvailable = false;
        return 0;
    }

    private int findAisleSeat() {
        for (int seat = previousAisleSeat; seat < 90; seat++) {
            if (seat % 6 == 2 || seat % 6 == 3) {
                if (!seats[seat]) {
                    previousAisleSeat = seat;
                    seats[seat] = true;
                    return seat + 1;
                }
            }
        }
        aisleSeatAvailable = false;
        return 0;
    }

    private int findWindowSeat() {
        for (int seat = previousWindowSeat; seat < 90; seat++) {
            if (seat % 6 == 0 || seat % 6 == 5) {
                if (!seats[seat]) {
                    previousWindowSeat = seat;
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
