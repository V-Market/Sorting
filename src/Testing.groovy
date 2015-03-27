assertEquals("test", "test")

/*
def x = "42"
assertNotNull "x must not be null", x
assertNull null
assertSame x, x
 */

import java.util.Arrays;
import java.util.Random;

class TestingSortMethod extends GroovyTestCase {
    def testOne
    def testTwo
    def testThree
    def testFour
    def testFive

    def inicialize(){
        Random rand = new Random()
        testOne = []
        testTwo = [0]

        size = 1000+1000*rand.nextDouble()
        items = new int[size]

        for (int i = 0;i<size;i++){
            items[i]=rand.nextInt(size+1)
        }
        testThree = items.clone()

        size = 10000+10000*rand.nextDouble()
        items = new int[size]

        for (int i = 0;i<size;i++){
            items[i]=rand.nextInt(size+1)
        }
        testFour = items.clone()
        size = 100000+100000*rand.nextDouble()
        items = new int[size]

        for (int i = 0;i<size;i++){
            items[i]=rand.nextInt(size+1)
        }
        testFive = items.clone()

        def bs=new BubbleSort("Bubble Sort",size)
        def qs = new QuickSort("Quick Sort",size)
        def ms = new MergeSort("Merge Sort",size)
        def hs = new HeapSort("Heap Sort",size)
        def msj = new MergeSortJava("Merge sort / java",size)
        def qsj = new QuickSortJava("Quick sort / java",size)


    }
    def testSRT(SortMethod sortMethod){
        assertEquals "Must be equals", testOne.sort(false), sortMethod.sortM(testOne)
        assertEquals "Must be equals", testTwo.sort(false), sortMethod.sortM(testTwo)
        assertEquals "Must be equals", testThree.sort(false), sortMethod.sortM(testThree)
        assertEquals "Must be equals", testFour.sort(false), sortMethod.sortM(testFour)
        assertEquals "Must be equals", testFive.sort(false), sortMethod.sortM(testFive)
    }

    def testAllSrtMeth(int[] array) {
        def qs = new QuickSort()
        def ms = new MergeSort()
        def hp = new HeapSort()
        def bs = new BubbleSort()
        def msj = new MergeSortJava()
        def qsj = new QuickSortJava()
        sortMeth = [qs,ms,hp,bs,msj,qsj]
        sortMeth.each {testSRT(it)}
    }


}