/**
 * Created by Gabriel on 24/03/2015.
 */

import java.util.Random

class Runner {

    long instanceSize
    def items = []
    BubbleSort bs
    //Aqui irian las otras declaraciones de ordenamientos

    public Runner(long instanceSize){
        this.instanceSize=instanceSize
        Random rand = new Random()
        (1..instanceSize).each{
            items << rand.nextInt((int)instanceSize+1)
        }

        bs=new BubbleSort("Bubble Sort",instanceSize);
        //Aqui irian las otras instancias de ordenamiento
    }

    static void main(String[] args) {
        int number = 10
        Runner runner = new Runner(number);
        println runner.items
        runner.bs.sortM(runner.items)
        println runner.items
        println runner.bs.report.toString()
    }
}
