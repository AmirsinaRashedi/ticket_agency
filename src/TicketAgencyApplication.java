import util.ApplicationContext;

import java.util.Scanner;

public class TicketAgencyApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        while (true) {
            System.out.println();
            System.out.println("1- add passenger");
            System.out.println("2- view seats");
            System.out.println("3- exit");
            System.out.print("choose: ");
            Scanner intInput = new Scanner(System.in);
            int choice = intInput.nextInt();
            switch (choice) {
                case 1:
                    applicationContext.findSeat();
                    break;
                case 2:
                    applicationContext.printSeats();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("invalid input");
            }
        }
    }
}
