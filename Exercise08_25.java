import java.util.Scanner;
public class Exercise08_25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] m = new double[3][3];
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                m[i][j] = input.nextDouble();
            }
        }

        if(isMarkov(m))
            System.out.println("It is a Markov matrix");
        else
            System.out.println("It is not a Markov matrix");

    }

    public static boolean isMarkov(double[][] m) {
        for(int i = 0; i < m.length; ++i) {
            for(int j = 0; j < m[i].length; ++j) {
                if(m[i][j] > 1 || m[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
