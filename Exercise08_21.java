import java.util.Scanner;
public class Exercise08_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int cityNum = input.nextInt();
        double[][] cities = new double[cityNum][2];
        System.out.print("Enter the coordinates of the cities: ");
        for(int i = 0; i < cityNum; ++i) {
            for(int j = 0; j < 2; ++j) {
                cities[i][j] = input.nextDouble();
            }
        }
        double[] central = findCentral(cities);
        double citySum = distanceSum(cities, central);
        System.out.println("The central city is at (" + central[0] + ", " + central[1] + ")");
        System.out.printf("The total distance to all other cities is %.2f", citySum);
    }

    public static double[] findCentral(double[][] m) {
        double[] central = {m[0][0], m[0][1]};
        double minimum = distanceBetweenPts(0, m[0][0], 0, m[0][1]);
        for(int i = 0; i < m.length; ++i) {
            double currDist = distanceBetweenPts(0, m[i][0], 0, m[i][1]);
            if(Math.min(currDist, minimum) != minimum) {
                central[0] = m[i][0];
                central[1] = m[i][1];
                minimum = currDist;
            }
        }
        return central;
    }

    public static double distanceSum(double[][] cities, double[] central) {
        double sum = 0;
        for(int i = 0; i < cities.length; ++i) {
            if(i == central[0])
                continue;
            sum += distanceBetweenPts(central[0], cities[i][0], central[1], cities[i][1]);
        }
        return sum;
    }

    public static double distanceBetweenPts(double x1, double x2, double y1, double y2) {
        double term1 = Math.pow(x2 - x1, 2);
        double term2 = Math.pow(y2 - y1, 2);
        return Math.sqrt(term1 + term2);
    }
}
