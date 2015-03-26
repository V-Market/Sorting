/**
 * Created by Gabriel on 24/03/2015.
 */

import java.util.Arrays;
import java.util.Random;

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

    public static void main(String[] args) {
        int number = 10;
        int [] list;
        Runner runner = new Runner(number);
        System.out.println( "ARREGLO INICIAL : ");
        System.out.println(Arrays.toString(runner.items));
        //------------------------------/
        //BUBBLE SORT
        list = runner.bs.sortM(runner.items);
        System.out.println(runner.bs.toString());
        System.out.println(Arrays.toString(list));
        //QUICKSORT
        list = runner.qs.sortM(runner.items);
        System.out.println(runner.qs.toString());
        System.out.println(Arrays.toString(list));
        //MERGESORT
        list = runner.ms.sortM(runner.items);
        System.out.println(runner.ms.toString());
        //MERGESORT JAVA
        list = runner.msj.sortM(runner.items);
        System.out.println(runner.msj.toString());
        System.out.println(Arrays.toString(list));
        //HEAPSORT
        list = runner.hs.sortM(runner.items);
        System.out.println(runner.hs.toString());
        System.out.println(Arrays.toString(list));
        //JAVA QUICKSORT
        list = runner.qsj.sortM(runner.items);
        System.out.println(runner.qsj.toString());
        System.out.println(Arrays.toString(list));
    }
}