import BubbleSort
import HeapSort
import MergeSortJava
import MergeSort
import QuickSort
import QuickSortJava
import java.util.Arrays;
import java.util.Random;
import junit.framework.Test
import groovy.util.AllTestSuite


class TestingSortMethod extends GroovyTestCase {

    def testOne
    def testTwo
    def testThree
    def testFour
    def testFive

    public TestingSortMethod(){
        inicialize();
    }

    def inicialize(){
        Random rand = new Random()
        testOne = []
        testTwo = [0]

        def size = 1000
        def items = new int[size]

        for (int i = 0;i<size;i++){
            items[i]=rand.nextInt(size+1)
        }
        testThree = items.clone()

        size = 10000
        items = new int[size]

        for (int i = 0;i<size;i++){
            items[i]=rand.nextInt(size+1)
        }
        testFour = items.clone()
        size = 150000
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
    def testSRT(sortMethod){
        def integ = []
        integ = testOne
        assert "Must be equals", integ.sort() as int[] == sortMethod.sortM(testOne)
        integ = testTwo
        assert "Must be equals", integ.sort() as int[] == sortMethod.sortM(testTwo)
        integ = testThree
        assert "Must be equals", integ.sort() as int[] == sortMethod.sortM(testThree)
        integ = testFour
        assert "Must be equals", integ.sort() as int[] == sortMethod.sortM(testFour)
        integ = testFive
        assert "Must be equals", integ.sort() as int[] == sortMethod.sortM(testFive)
    }

    def testAllSrtMeth() {
        def qs = new QuickSort("Quick sort",0)
        def ms = new MergeSort("Merge sort",0)
        def hp = new HeapSort("Heap sort",0)
        def bs = new BubbleSort("Bubble sort",0)
        def msj = new MergeSortJava("Merge sort",0)
        def qsj = new QuickSortJava("Quick sort java",0)
        def sortMeth = [qs,ms,hp,bs,msj,qsj]
        sortMeth.each {testSRT(it)}
    }
    //@Test
    public static void testMethod(){
        TestingSortMethod myTest= new TestingSortMethod()
        myTest.testAllSrtMeth()
    }


}