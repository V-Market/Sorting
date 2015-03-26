/**
 * Created by Gabriel on 25/03/2015.
 */
class QuickSort extends SortMethod{

    QuickSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def list = []
        list = new ArrayList( Arrays.asList(items) )
        list = quickSort(list)
    }

    def quickSort(items){
        if (!items || items.size() <= 1) return items
        def (less, more) = items[1..-1].split { it <= items[0] }
        quickSort(less) + items[0] + quickSort(more)
    }
}