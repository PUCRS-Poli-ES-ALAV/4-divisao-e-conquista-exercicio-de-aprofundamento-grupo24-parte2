import java.lang.Math;

public class MultiplicacaoNBitsComString {

    public static long iterations = 0;
    public static long ops = 0;

    public static long multiply(String x,String y, long n)
    {
        iterations++;
        if (n==1)
        {
            System.out.printf("x = %s; y = %s; RETURN = %d%n",x,y,Integer.parseInt(x)==1 && Integer.parseInt(y)==1 ? 1 : 0);
            ops++;
            return Integer.parseInt(x)==1 && Integer.parseInt(y)==1 ? 1 : 0;
        }
        else
        {
            long m = -Math.floorDiv(-n,2);        // n/2
            String a = x.substring(0, (int)m);      // x/2^m
            String b = x.substring((int)m);
            String c = y.substring(0, (int)m);
            String d = y.substring((int)m);
            ops += 5;
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            System.out.printf("%nx = %s; y = %s; n = %d%na = %s; b = %s; c = %s; d = %s%ne = %d; f = %d; g = %d; h = %d%n%n",x,y,n,a,b,c,d,e,f,g,h);
            ops += 9;
            return (1<<(2*m))*e + (1<<m)*(g + h) + f;  //2^(2m)*e + 2^m*(g + h) + f
            //z2 * B^2m + z1 * B^m + z0
            //z0 = f
            //z1 = g + h
            //z2 = e
            //e * B^2m + (g+h) * B^m + f
        }
    }
    public static void main(String[] args) {
        long time = System.nanoTime();
        System.out.println(multiply("0100100010001000100010001000100010001000100010001000100010001000", "0111101000111010001110100011101000111010001110100010100011101000", 64));
        System.out.printf("Time = %d\u03BCs %nOps = %d%nIterations = %d%n",(System.nanoTime()-time)/1000, ops, iterations);
    }

}
