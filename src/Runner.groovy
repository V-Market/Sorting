/**
 * Created by Gabriel on 24/03/2015.
 */

import java.util.Random

class Runner {

    long instanceSize
    def items = []
    BubbleSort bs
    //Aqui irian las otras declaraciones de ordenamientos
    //EJEMPLO QUICKSORT
    //QuickSort qs

    //Constructor que crea un arreglo aleatorio de "instanceSize" elementos
    //entre 0 e instanceSize
    public Runner(long instanceSize){
        this.instanceSize=instanceSize
        Random rand = new Random()
        (1..instanceSize).each{
            items << rand.nextInt((int)instanceSize+1)
        }

        bs=new BubbleSort("Bubble Sort",instanceSize)
        //Aqui irian las otras instancias de ordenamiento
        //EJEMPLO QUICKSORT
        //qs = new QuickSort("Quick Sort",instanceSize)
    }

    static void main(String[] args) {
        int number = 10
        Runner runner = new Runner(number);
        println "ARREGLO INICIAL : "
        println runner.items
        //------------------------------/
        //Aqui se pondrian las distintas ejecuciones y resultados de los reportes
        runner.bs.sortM(runner.items)
        println runner.bs.toString()
        //EJEMPLO QUICKSORT
        //runner.qs.sortM(runner.items)
        //println runner.qs.toString()
    }
}