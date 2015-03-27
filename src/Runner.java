/**
 * Created by Gabriel on 24/03/2015.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Runner {

    int instanceSize;
    int[] items;
    BubbleSort bs;
    QuickSort qs;
    MergeSort ms;
    HeapSort hs;
    MergeSortJava msj;
    QuickSortJava qsj;

    //Constructor que crea un arreglo aleatorio de "instanceSize" elementos
    //entre 0 e instanceSize
    public Runner(int instanceSize){
        this.instanceSize=instanceSize;
        items = new int[instanceSize];

        Random rand = new Random();
        for (int i = 0;i<instanceSize;i++){
            items[i]=rand.nextInt(instanceSize+1);
        }
        bs=new BubbleSort("Bubble Sort",instanceSize);
        qs = new QuickSort("Quick Sort",instanceSize);
        ms = new MergeSort("Merge Sort",instanceSize);
        hs = new HeapSort("Heap Sort",instanceSize);
        msj = new MergeSortJava("Merge sort / java",instanceSize);
        qsj = new QuickSortJava("Quick sort / java",instanceSize);
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese la longitud del arrelgo a ordenar: ");
        int number = sc.nextInt();
        sc.close();

        int [] list;
        Runner runner = new Runner(number);
        //System.out.println( "ARREGLO INICIAL : ");
        //System.out.println(Arrays.toString(runner.items));
        //------------------------------/

        //BUBBLE SORT
        list = runner.bs.sortM(runner.items);
        System.out.println(runner.bs.toString());
        bw.write(runner.bs.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));
        //HEAPSORT
        list = runner.hs.sortM(runner.items);
        System.out.println(runner.hs.toString());
        bw.write(runner.hs.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));
        //QUICKSORT
        list = runner.qs.sortM(runner.items);
        System.out.println(runner.qs.toString());
        bw.write(runner.qs.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));
        //QUICKSORT JAVA
        list = runner.qsj.sortM(runner.items);
        System.out.println(runner.qsj.toString());
        bw.write(runner.qsj.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));
        //MERGESORT
        list = runner.ms.sortM(runner.items);
        System.out.println(runner.ms.toString());
        bw.write(runner.ms.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));
        //MERGESORT JAVA
        list = runner.msj.sortM(runner.items);
        System.out.println(runner.msj.toString());
        bw.write(runner.msj.getSortNameAndReport());
        //System.out.println(Arrays.toString(list));

        bw.close();

        System.out.println("---------------------");
        System.out.println("TESTING");
        System.out.println("---------------------");

        //TESTING
        TestingSortMethod tsm = new TestingSortMethod();
        tsm.testAllSrtMeth();
    }
}