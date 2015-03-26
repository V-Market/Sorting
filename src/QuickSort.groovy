/**
 * Created by Gabriel on 25/03/2015.
 */
class QuickSort extends SortMethod{

    QuickSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }
    def comp = 0
    def mov = 0
    //se pueden definir como variables globales pero no entiendo
    // donde deberia contar 1 movimiento o una comparacion :v

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
    }

    def quickSort(items){
        if (!items || items.size() <= 1) return items
        def (less, more) = items[1..-1].split { it <= items[0] }
        quickSort(less) + items[0] + quickSort(more)
    }
}