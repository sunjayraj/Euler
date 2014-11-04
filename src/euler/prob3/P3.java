package euler.prob3;

import java.util.Arrays;

public class P3 {
    public static void main(String[] args) {
        long it = 317584931803l;
        long SQRT = ((int)Math.sqrt(it)) + 1;
        System.out.println("sqrt = "+ SQRT);
        System.out.println("sqrt^2 = "+ SQRT*SQRT);

        boolean isprime[] = new boolean[(int) (SQRT+1)];
        Arrays.fill(isprime, true);
        isprime[2] = true; setprimes(isprime, 2, SQRT);
        isprime[3] = true; setprimes(isprime, 3, SQRT);
        for (int i = 5; i <= SQRT; i += 2) {
        	if(isprime[i]) setprimes(isprime, i, SQRT);
        	
        }
        long out = 0;
        for (int i = (int) SQRT; i > 2; i--) {
            if (isprime[i] && (it % i) == 0) {
                System.out.println(i);
                break;
            }
        }
//        for (int i = 2; i < SQRT; ++i) {
//            if (isprime[i] && (it % i) == 0) {
//                out = Math.max(i, out);
//            }
//        }
        
        System.out.println(primo(it));
        System.out.println(primo(45));
    }

    public static long primo(long x)
    {
       long a = 2;
       while ( x > 1 )
       {
           if ( ( x % a ) == 0 )
           {
               x = x / a;
           }
           else
           {
              a++;
           }
       }
       return a;
    }
    
    private static void setprimes(boolean[] isprime, int n, long sQRT) {
		for (int i = 2*n; i <= sQRT; i += n) 
			isprime[i] = false;
	}
}