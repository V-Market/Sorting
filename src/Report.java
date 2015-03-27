/**
 * Created by Gabriel on 24/03/2015.
 */
class Report {
    private long instanceSize;
    private long comparisons;
    private long movements;
    private double time;

    public Report(long instanceSize){
        this.instanceSize=instanceSize;  //Tamaño de la lista
        this.comparisons=0;             //Numero de comparaciones hechas
        this.movements=0;                //Numero de movimientos hechos
        this.time=0.0;                   //Tiempo de ejecucion
    }

    //Metodo para añadir comparaciones al reporte
    void addComparisons (long k){
        this.comparisons+=k;
    }
    //Metodo para añadir movimientos al reporte
    void addMovements(long k){
        this.movements+=k;
    }
    //Metodo para colocar el tiempo de ejecucion
    void setTime(double time) {
        this.time = time;
    }

    public String getReportString(){
        return comparisons+"\t"+movements+"\t"+time+"\n";
    }

    //toString para la impresion del reporte
    @Override
    public String toString(){

        return ("Instance Size: " + instanceSize
        + "\nComparisons: " + comparisons
        + "\nMovements: "+ movements
        + "\nTime: "+time+ " ms");
    }
}
