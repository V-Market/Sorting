/**
 * Created by Gabriel on 24/03/2015.
 */
class BubbleSort extends SortMethod{

    BubbleSort(String sortName, long instanceSize) {
        super(sortName, instanceSize)
    }

    @Override
    int[] sortM(int[] items) {
        def comp = 0
        def mov = 0
        def aux
        def list = items.clone()
        def len = items.size()
        //Se cuenta desde el inicio del algoritmo
        def ini = System.currentTimeMillis()
        for(i in 0..len-2){
            for (j in 0..len-2-i){
                if(list[j]>list[j+1]){
                    aux= list[j + 1]
                    list[j + 1] =list[j]
                    list[j]=aux
                }
                comp+=1
                mov+=3
            }
        }
        //hasta el fin del algoritmo
        def fin= System.currentTimeMillis()

        super.report.addComparisons(comp)
        super.report.addMovements(mov)
        super.report.setTime(fin-ini)
    }
}