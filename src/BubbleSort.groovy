/**
 * Created by Gabriel on 24/03/2015.
 */
class BubbleSort extends SortMethod{

    BubbleSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    def sortM(Object items) {
        def comp = 0
        def mov = 0
        def aux
        def len = items.size()
        //Se cuenta desde el inicio del algoritmo
        def ini = System.currentTimeMillis()
        for(i in 0..len-2){
            for (j in 0..len-2-i){
                if(items[j]>items[j+1]){
                    aux= items[j + 1]
                    items[j + 1] =items[j]
                    items[j]=aux
                }
                comp+=1
                mov+=3
            }
        }
        //hasta el fin del algoritmo
        def fin= System.currentTimeMillis()
        //Se añaden las comparaciones, movimientos y tiempo
        //final de ejecucion al reporte
        this.report.addComparisons(comp)
        this.report.addMovements(mov)
        this.report.setTime(fin-ini)
    }
}
