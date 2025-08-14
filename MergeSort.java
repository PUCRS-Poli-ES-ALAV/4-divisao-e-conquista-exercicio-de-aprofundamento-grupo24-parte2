import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {
    private static int counter = 0;

    public static List<Integer> mergeSort(List<Integer> lista)
    {
        counter++;
        if (lista.size() == 1 || lista.size() == 0) return lista;
        List<Integer> listaLeft = mergeSort(lista.subList(0, lista.size()/2));
        List<Integer> listaRigth = mergeSort(lista.subList(lista.size()/2, lista.size()));
        return merge(listaLeft, listaRigth);
    }
    private static List<Integer> merge(List<Integer> listaL, List<Integer> listaR)
    {
        counter++;
        int indexL = 0;
        int indexR = 0;
        List<Integer> merger = new ArrayList<>();
        while(indexL < listaL.size() && indexR < listaR.size())
        {
            counter++;
            if (listaL.get(indexL).compareTo(listaR.get(indexR)) < 0)
            {
                merger.add(listaL.get(indexL));
                indexL++;
            }
            else
            {
                merger.add(listaR.get(indexR));
                indexR++;
            }
        }
        if (indexL == listaL.size())
        {
            merger.addAll(listaR.subList(indexR, listaR.size()));
        }
        else if (indexR == listaR.size())
        {
            merger.addAll(listaL.subList(indexL, listaL.size()));
        }
        else
        {
            System.out.println("Algo está errado");
        }
        return merger;
    }

    public static int[] geraVetor(int nroPares, int nroImpares){
        int [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

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
        int[] vet32 = geraVetor(16, 16);
        ArrayList<Integer> ararar = new ArrayList<>();
        for (Integer i : vet32) {
            ararar.add(i);
        }
        long st = System.nanoTime();
        System.out.println(mergeSort(ararar));
        long end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %dms%n",(end-st)/1000000);

        counter = 0;
        int[] vet2048 = geraVetor(1024, 1024);
        ArrayList<Integer> ararara = new ArrayList<>();
        for (Integer i : vet2048) {
            ararara.add(i);
        }
        st = System.nanoTime();
        mergeSort(ararara);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %dms%n",(end-st)/1000000);

        counter = 0;
        int[] vet1048576 = geraVetor(1048576/2, 1048576/2);
        ArrayList<Integer> arararar = new ArrayList<>();
        for (Integer i : vet1048576) {
            arararar.add(i);
        }
        st = System.nanoTime();
        mergeSort(arararar);
        end = System.nanoTime();
        System.out.printf("Número de operacoes %d%n",counter);
        System.out.printf("Tempo levado %dms%n",(end-st)/1000000);

    }
}
