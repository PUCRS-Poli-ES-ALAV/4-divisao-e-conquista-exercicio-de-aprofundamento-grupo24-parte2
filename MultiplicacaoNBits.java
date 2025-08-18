import java.lang.Math;

public class MultiplicacaoNBits {

    public static long multiply(long x,long y, long n)
    {
        if (n==1)
        {
            System.out.printf("x = %d; y = %d; RETURN = %d%n",x,y,x*y);
            return x*y;
        }
        else
        {
            long m = -Math.floorDiv(-n,2);        // n/2
            long a = Math.floorDiv(x,1<<m);      // x/2^m
            long b = x % 1 << m;
            long c = Math.floorDiv(y,1 << m);
            long d = y % 1 << m;
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            System.out.printf("%nx = %d; y = %d; n = %d%na = %d; b = %d; c = %d; d = %d%ne = %d; f = %d; g = %d; h = %d%n%n",x,y,n,a,b,c,d,e,f,g,h);
            return (1<<(2*m))*e + (1<<m)*(g + h) + f;  //2^(2m)*e + 2^m*(g + h) + f
            //z2 * B^2m + z1 * B^m + z0
            //z0 = f
            //z1 = g + h
            //z2 = e
            //e * B^2m + (g+h) * B^m + f
        }
    }
    public static void main(String[] args) {
        System.out.println(multiply(101, 10, 3));
    }

}
