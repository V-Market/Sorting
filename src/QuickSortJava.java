/**
 * MarrayNUZarrayM
 */
import java.util.Random;

public class QuickSortJava extends SortMethod {

    QuickSortJava(String sortName, long instanceSize) {
        super(sortName, instanceSize);
    }
    int comp;
    int mov;
    @Override
    public int[] sortM(int[] items) {
        comp = 0;
        mov = 0;
        long ini = System.currentTimeMillis();
        items = quickSort(items, 0, items.length);
        long fin = System.currentTimeMillis();
        super.report.addComparisons(comp);
        super.report.addMovements(mov);
        super.report.setTime(fin-ini);
        return items;
    }
    private int[] quickSort(int[] array, int izq, int der ){
        int pivote=array[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        comp++;
        while(i<j){            // mientras no se crucen las búsquedas
            while(array[i]<=pivote && i<j) {
                i++; // busca elemento mayor que pivote
                comp++;
            }
            while(array[j]>pivote) {
                comp++;
                j--;
            }         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado                      
                aux= array[i];                  // los intercambia
                array[i]=array[j];
                array[j]=aux;
                mov++;      //un intercambio es 1 movimiento
            }
        }
        mov++;
        array[izq]=array[j]; // se coloca el pivote en su lugar de forma que tendremos
        array[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quickSort(array,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quickSort(array,j+1,der); // ordenamos subarray derecho
        return array;
    }
}
