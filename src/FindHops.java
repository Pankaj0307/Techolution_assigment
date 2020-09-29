import java.util.Arrays;
import java.util.Scanner;

public class FindHops {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter number of compartments : ");
        int noOfCompartments = sc1.nextInt();
        //initialize the array with the entered noOfCompartments size
        int[] arrCompartments = new int[noOfCompartments];
        System.out.println("Enter JETPACK threshold value for each compartment : ");
        for (int index = 0; index < noOfCompartments; index++) {
            arrCompartments[index] = sc1.nextInt();
        }
        System.out.println("Entered values for each compartment : " + Arrays.toString(arrCompartments));

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter value of compartment, where thesis paper is hidden : ");
        int compartment = sc2.nextInt();

        int hopsToReach = hops(arrCompartments, 0, compartment - 1);
        if (hopsToReach == -1) {
            System.out.println("Not possible.");
        } else if (hopsToReach == 0) {
            System.out.println("Please enter valid compartment number.");
        } else {
            System.out.println("Minimum hops required to find thesis paper : " + hopsToReach);
        }

    }

    private static int hops(int[] arrCompartments, int start, int compartment) {
        if (arrCompartments.length < compartment) {
            return 0;
        }
        if (start == compartment) {
            return 0;
        }
        if (arrCompartments[0] == 0) {
            return -1;
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = start + 1; i <= compartment && i <= start + arrCompartments[start]; i++) {
            int hops = hops(arrCompartments, i, compartment);
            if (hops != Integer.MAX_VALUE && hops + 1 < minimum) {
                minimum = hops + 1;
            }
        }
        return minimum;
    }
}