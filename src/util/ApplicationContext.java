package util;

import domain.BusinessClass;
import domain.Economy;

import java.util.Scanner;

public class ApplicationContext {
    private BusinessClass businessClass;
    private Economy economy;

    public ApplicationContext() {
        businessClass = new BusinessClass();
        economy = new Economy();
    }

    public void findSeat() {
        System.out.println();
        System.out.println("1- Business");
        System.out.println("2- Economy");
        System.out.print("choose: ");
        Scanner intInput = new Scanner(System.in);
        int choice = intInput.nextInt();
        switch (choice) {
            case 1:
                businessClass.findSeat();
                break;
            case 2:
                economy.findSeat();
                break;
            default:
                System.out.println("invalid input");
        }
    }

    public void printSeats() {
        System.out.println();
        businessClass.printSeats();
        economy.printSeats();
        System.out.println();
    }
}
