/**
 * Created by Gabriel on 25/03/2015.
 */
public class MergeSortJava extends SortMethod{

    MergeSortJava(String sortName, long instanceSize) {
        super(sortName, instanceSize);
    }
    int mov;
    int comp;
    public int[] mergeSort(int[] array) {
        mov = 0;
        comp = 0;
        if (array.length > 1) {
            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];
            for (int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];
            for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];
            arr1 = sortM(arr1);
            arr2 = sortM(arr2);

            int i = 0, j = 0, k = 0;
            while (arr1.length != j && arr2.length != k) {
                if (arr1[j] < arr2[k]) {
                    array[i] = arr1[j];
                    i++;
                    j++;
                    comp++;
                    mov++;
                } else {
                    array[i] = arr2[k];
                    i++;
                    k++;
                    mov++;
                }
            }
            while (arr1.length != j) {
                array[i] = arr1[j];
                i++;
                j++;
                mov++;
            }
            while (arr2.length != k) {
                array[i] = arr2[k];
                i++;
                k++;
                mov++;
            }
        }
        return array;
    }
    @Override
    public int[] sortM(int[] array){
        int []list = new int[array.length];
        double ini = System.currentTimeMillis();
        list = mergeSort(list);
        double fin = System.currentTimeMillis();
        super.report.addComparisons(comp);
        super.report.addMovements(mov);
        super.report.setTime(fin-ini);
        return list;
    }
}
