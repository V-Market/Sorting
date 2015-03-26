/**
 * Created by Gabriel on 25/03/2015.
 */
public class MergeSortJava extends SortMethod{

    MergeSortJava(String sortName, long instanceSize) {
        super(sortName, instanceSize);
    }

    @Override
    public int[] sortM(int[] array)
    {
        if(array.length > 1)
        {
            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];
            for(int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];
            for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];
            arr1 = sortM(arr1);
            arr2 = sortM(arr2);

            int i = 0, j = 0, k = 0;
            while(arr1.length != j && arr2.length != k)
            {
                if(arr1[j] < arr2[k])
                {
                    array[i] = arr1[j];
                    i++;
                    j++;
                }
                else
                {
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }
            while(arr1.length != j)
            {
                array[i] = arr1[j];
                i++;
                j++;
            }
            while(arr2.length != k)
            {
                array[i] = arr2[k];
                i++;
                k++;
            }
        }
        return array;
    }
}
