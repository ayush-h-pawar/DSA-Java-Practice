import java.util.Scanner;

public class SimpleInterestCalculator{
    public static void main(String args[]) {

        double p, r, t, si;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Simple Interest Calculator");
        System.out.println("Choose the option you want to calculate:");
        System.out.println("1. Calculate Simple Interest");
        System.out.println("2. Calculate Time Period");
        System.out.println("3. Calculate Rate of Interest");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter Principal Amount: ");
                p = sc.nextDouble();

                System.out.print("Enter Rate of Interest: ");
                r = sc.nextDouble();

                System.out.print("Enter Time Period: ");
                t = sc.nextDouble();

                double siValue = (p * r * t) / 100;
                System.out.println("The Total Amount is: " + (p + siValue));
                break;

            case 2:
                System.out.print("Enter Principal Amount: ");
                p = sc.nextDouble();

                System.out.print("Enter Rate of Interest: ");
                r = sc.nextDouble();

                System.out.print("Enter Simple Interest: ");
                si = sc.nextDouble();

                double time = (si * 100) / (p * r);
                System.out.println("The Time Period is: " + time);
                break;

            case 3:
                System.out.print("Enter Principal Amount: ");
                p = sc.nextDouble();

                System.out.print("Enter Time Period: ");
                t = sc.nextDouble();

                System.out.print("Enter Simple Interest: ");
                si = sc.nextDouble();

                double rate = (si * 100) / (p * t);
                System.out.println("The Rate of Interest is: " + rate + "%");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
