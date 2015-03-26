/**
 * Created by Gabriel on 25/03/2015.
 */
class QuickSort extends SortMethod{

    def comp = 0
    def mov = 0

    QuickSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def list = []
        list = new ArrayList( Arrays.asList(items) )
        def ini = System.currentTimeMillis()
        list = quickSort(list)
        def fin = System.currentTimeMillis()
        super.report.addComparisons(comp)
        super.report.addMovements(mov)
        super.report.setTime(fin-ini)
        return list
    }

    def quickSort(items){
        if (!items || items.size() <= 1) {
            comp+=1
            return items
        }
        def (less, more) = items[1..-1].split { it <= items[0] }
        def size = items.size()
        comp+=size
        mov+=size-1
        quickSort(less) + items[0] + quickSort(more)
    }
}