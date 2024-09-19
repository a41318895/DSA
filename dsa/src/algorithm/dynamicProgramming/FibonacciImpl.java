package algorithm.dynamicProgramming;

/**
 * @author Aki Chou
 */
public class FibonacciImpl {

    public static int fibonacciDPSolution(int n) {

        if(n == 0) return 0 ;
        if(n == 1) return 1 ;

        int[] result = new int[n + 1] ;

        // Pre-handle
        result[0] = 0 ;
        result[1] = 1 ;

        // Calculation
        for(int i = 2 ; i <= n ; i ++) {

            result[i] = result[i - 1] + result[i - 2] ;
        }

        return result[n] ;
    }

    public static void main(String[] args) {

        int n1 = 1 ;
        System.out.println(fibonacciDPSolution(n1));

        int n2 = 4 ;
        System.out.println(fibonacciDPSolution(n2));
    }
}
