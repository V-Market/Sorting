assertEquals("test", "test")

/*
def x = "42"
assertNotNull "x must not be null", x
assertNull null
assertSame x, x
 */

class TestingSortMethod extends GroovyTestCase {

    void testQuickSort(int[] array) {
        def qs = new QuickSort()
        assertTrue(qs.sortM(array).equals(array.sort(false) { it }))
    }

    void testMergeSort(int[] array) {
        assertTrue(MergeSort.sortM(array).equals(array.sort(false) { it }))
    }

    void testBubbleSort(int[] array) {
        assertTrue(BubbleSort.sortM(array).equals(array.sort(false) { it }))
    }

    void testHeapSort(int[] array) {
        assertTrue(HeapSort.sortM(array).equals(array.sort(false) { it }))
    }

    void testQuickSortJava(int[] array) {
        assertTrue(HeapSortJava.sortM(array).equals(array.sort(false) { it }))
    }
    void testMergeSortJava(int[] array) {
        def msj = new MergeSortJava();
        assertTrue(MergeSortJava.sortM(array).equals(array.sort(false) { it }))
    }

}