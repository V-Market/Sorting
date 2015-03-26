/**
 * Created by Gabriel on 25/03/2015.
 */
class MergeSort extends SortMethod {

    def comp = 0
    def mov = 0

    MergeSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def list = []
        list = new ArrayList( Arrays.asList(items) )

        def ini = System.currentTimeMillis()
        list = mergeSort(list)
        def fin = System.currentTimeMillis()
        super.report.addComparisons(comp)
        super.report.addMovements(mov)
        super.report.setTime(fin-ini)
        return list
    }

    def mergeSort(def list){
        comp += 1
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
            comp+=1
            mov+=1
        }
        sorted = sorted + left + right
        mov+=left.size()+right.size()
        return sorted
    }
}