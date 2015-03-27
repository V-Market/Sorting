
import java.util.Arrays;
import java.util.Random;

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
        assertEquals "Must be equals", testOne.sort(false), sortMethod.sortM(testOne)
        assertEquals "Must be equals", testTwo.sort(false), sortMethod.sortM(testTwo)
        assertEquals "Must be equals", testThree.sort(false), sortMethod.sortM(testThree)
        assertEquals "Must be equals", testFour.sort(false), sortMethod.sortM(testFour)
        assertEquals "Must be equals", testFive.sort(false), sortMethod.sortM(testFive)
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


}