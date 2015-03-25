/**
 * Created by Gabriel on 24/03/2015.
 */
class Report {
    long instanceSize
    long comparisons
    long movements
    double time

    public Report(long instanceSize){
        this.instanceSize=instanceSize
        this.comparisons=0
        this.movements=0
        this.time=0.0
    }

    void addComparisons (long k){
        this.comparisons+=k
    }
    void addMovements(long k){
        this.movements+=k
    }

    String toString(){
        println "Instance Size: " + instanceSize
        println "Comparisons: " + comparisons
        println "Movements: "+ movements
        println "Time: "+movements
    }

}
