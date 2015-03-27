/**
 * Created by Gabriel on 25/03/2015.
 */
class HeapSort extends SortMethod{

    def comp = 0
    def mov = 0

    HeapSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def list = []
        list = new ArrayList( Arrays.asList(items) )
        def ini = System.currentTimeMillis()
        list = heapSort(list)
        def fin = System.currentTimeMillis()
        super.report.addComparisons(comp)
        super.report.addMovements(mov)
        super.report.setTime(fin-ini)
        return list
    }

    def heapSort(list) {
        def size = list.size()

        comp++
        if (size < 2) {
            return list
        }
        //Se crea un heap binario
        heapify(list)

        //se remueve el elemento mas grande y se verifica que el heap siga siendo valido
        (size - 1 .. 1).each {
            //Se remueve el elemento mas grande
            swap(list, 0, it)
            //Se arregla el heap
            siftDown(list, 0, it - 1)
        }
        return list
    }

    def heapify(list) {
        def size = list.size()
        //Encontrar la raiz del heap
        def parent = (int)size / 2 - 1
        //Se arregla el heap desde los niveles mas bajos a la raiz
        while (parent >= 0) {
            siftDown(list, parent--, size - 1)
        }
    }

    def siftDown(list, start, end) {
        def parent = start
        //Si el padre tiene hijos se verifican y se comprueba si alguno es mayor que su padre
        while (parent * 2 + 1 <= end) {
            def leftChild = parent * 2 + 1
            def rightChild = leftChild + 1

            //Se asume que el padre es el maximo
            def max = parent
            //Si el hijo izquierdo es mayor que su padre , es candidato para subir
            comp++
            if (list[leftChild] > list[max]) {
                max = leftChild
            }
            //Si el hijo derecho es mayor a su padre y a su hermano , este debe subir
            comp++
            if (rightChild <= end && list[rightChild] > list[max]) {
                max = rightChild
            }
            //Si el papa no es el mayor , sube el hijo candidato
            comp++
            if (max != parent) {
                swap(list, parent, max)
                parent = max
            } else {
                break
            }
        }
    }

    def swap(list, i, j) {
        def temp = list[i]
        list[i]  = list[j]
        list[j]  = temp
        mov+=1
    }
}
