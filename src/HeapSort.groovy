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
        /*We need to create a valid binary heap first*/
        heapify(list)

        /*Remove the biggest element in the heap and make sure heap still is valid*/
        (size - 1 .. 1).each {
            /*Remove the biggest element*/
            swap(list, 0, it)
            /*Sift down to make a valid heap*/
            siftDown(list, 0, it - 1)
        }
        return list
    }

    def heapify(list) {
        def size = list.size()
        /*Find the last parent in the heap*/
        def parent = (int)size / 2 - 1
        /*Sift down all parents starting for lowest levels up to root*/
        while (parent >= 0) {
            siftDown(list, parent--, size - 1)
        }
    }

    def siftDown(list, start, end) {
        def parent = start
        /*If there is any child for this parent, then check child(s) value to make sure parent is the biggest one*/
        while (parent * 2 + 1 <= end) {
            /*Given p is parent index, left child is in index of p*2 + 1 */
            def leftChild = parent * 2 + 1
            /*Right child is always after left child (if there is any right child)*/
            def rightChild = leftChild + 1

            /*Assume parent is the biggest value*/
            def max = parent
            /*If left child is bigger than parent then left child is a candidate to move up*/
            comp++
            if (list[leftChild] > list[max]) {
                max = leftChild
            }
            /*If right child is exist its the bigges amoung parent, left and right, then right child needs to move up*/
            comp++
            if (rightChild <= end && list[rightChild] > list[max]) {
                max = rightChild
            }
            /*If the parent is not the biggest one, swap it with biggest child and continue*/
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
