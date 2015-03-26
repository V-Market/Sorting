/**
 * Created by Gabriel on 25/03/2015.
 */
class MergeSort extends SortMethod {

    MergeSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def list = []
        list = new ArrayList( Arrays.asList(items) )
        list = mergeSort(list)
    }

    def mergeSort(def list){
        if (list.size() <= 1)return list
        def center = list.size() / 2 -1
        def left  = list[0..center]
        def right = list[center+1..-1]
        merge(mergeSort(left), mergeSort(right))
    }

    def merge(def left, def right){
        def sorted = []
        while(left.size() > 0 && right.size() > 0) {

            if (left.get(0) <= right.get(0)) {
                sorted << left.remove(0)
            } else {
                sorted << right.remove(0)
            }
        }
        sorted = sorted + left + right
        return sorted
    }
}

