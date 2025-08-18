import java.util.Random;

public class VectorMaxer {

    private static long counter = 0;

    public static long maxVal1(long A[], int n)
    {
        long max = A[0];
        for (int i = 1; i < n; i++)
        {
            counter++;
            if( A[i] > max ) max = A[i];
        }
        return max;
    }

    public static long maxVal2(long A[], int init, int end)
    {
        counter++;
        if (end - init <= 1) return A[init] > A[end-1] ? A[init] : A[end-1];
        else
        {
            int m = (init + end)/2;
            long v1 = maxVal2(A,init,m);
            long v2 = maxVal2(A,m+1,end);
            return v1 > v2 ? v1 : v2;
        }
    }
    public static long[] geraVetor(int nroPares, int nroImpares){
        long [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {

            res = new long[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        System.out.println();
        System.out.println("------- Normal -------");
        System.out.println();

        long[] vet32 = geraVetor(16, 16);
        long st = System.nanoTime();
        maxVal1(vet32, 32);
        long end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vet2048 = geraVetor(1024, 1024);
        st = System.nanoTime();
        maxVal1(vet2048, 2048);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vet1048576 = geraVetor(1048576/2, 1048576/2);
        st = System.nanoTime();
        maxVal1(vet1048576, 1048576);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vetSIM = geraVetor(Integer.MAX_VALUE/20, Integer.MAX_VALUE/20);
        st = System.nanoTime();
        maxVal1(vetSIM, (Integer.MAX_VALUE/20)*2);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        // DIVIDE E CONQUISTA
        System.out.println();
        System.out.println("------- Divisao e Conquista -------");
        System.out.println();
        counter = 0;
        long[] vet32CEC = geraVetor(16, 16);
        st = System.nanoTime();
        maxVal2(vet32CEC, 0, 32);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vet2048CEC = geraVetor(1024, 1024);
        st = System.nanoTime();
        maxVal2(vet2048CEC, 0, 2048);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vet1048576CEC = geraVetor(1048576/2, 1048576/2);
        st = System.nanoTime();
        maxVal2(vet1048576CEC, 0, 1048576);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);

        counter = 0;
        long[] vetSIMCEC = geraVetor(Integer.MAX_VALUE/20, Integer.MAX_VALUE/20);
        st = System.nanoTime();
        maxVal2(vetSIMCEC, 0, ((Integer.MAX_VALUE/20)*2)-1);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %d microS%n",(end-st)/1000);
    }
}
