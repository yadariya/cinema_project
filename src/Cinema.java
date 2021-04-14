import java.util.Scanner;

public class Cinema {
    public static int income = 0;
    public static int tickets = 0;
    public static int total = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Enter the number of rows:");
        a = scn.nextInt();
        System.out.println("Enter the number of seats in each row:");
        b = scn.nextInt();
        String[][] seats = new String[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                seats[i][j] = "S";
            }

        }
        if (a * b <= 60) {
            total = a * b * 10;
        } else {
            total = a / 2 * b * 10 + (a / 2 + a % 2) * b * 8;
        }
        int k = 1;
        while (k != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option;
            option = scn.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Cinema:");
                    System.out.print(" ");
                    for (int i = 1; i <= b; i++) {
                        System.out.print(" " + i);
                    }
                    System.out.println();
                    for (int i = 0; i < a; i++) {
                        System.out.print(i + 1);
                        for (int j = 0; j < b; j++) {
                            System.out.print(" " + seats[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    int m = 0;
                    while (m != 1) {
                        System.out.println("Enter a row number:");
                        int row_num;
                        row_num = scn.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat_num;
                        seat_num = scn.nextInt();
                        if (row_num > a || row_num <= 0 || seat_num > b || seat_num <= 0) {
                            System.out.println("Wrong input!");
                            System.out.println();

                        } else if (seats[row_num - 1][seat_num - 1].equals("B")) {
                            System.out.println("That ticket has already been purchased!");
                            System.out.println();
                        } else {
                            if (a * b <= 60 || row_num <= a / 2) {
                                System.out.println("Ticket price: $10");
                                System.out.println();
                                tickets++;
                                income += 10;
                                m = 1;
                                seats[row_num - 1][seat_num - 1] = "B";

                            } else {
                                System.out.println("Ticket price: $8");
                                System.out.println();
                                tickets++;
                                income += 8;
                                m = 1;
                                seats[row_num - 1][seat_num - 1] = "B";
                            }

                        }
                    }
                    break;
                case 3:
                    System.out.printf("Number of purchased tickets: %d", tickets);
                    System.out.println();
                    System.out.printf("Percentage: %.2f", tickets / (1.0 * a * b) * 100);
                    System.out.println("%");
                    System.out.printf("Current income: $%d", income);
                    System.out.println();
                    System.out.printf("Total income: $%d", total);
                    System.out.println();
                    System.out.println();
                    break;
                case 0:
                    k = 0;
                    break;

            }
        }
    }
}
