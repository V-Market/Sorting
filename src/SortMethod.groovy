/**
 * Created by Gabriel on 24/03/2015.
 */
abstract class SortMethod {
    String sortName
    Report report

    public SortMethod(String sortName,long instanceSize){
        this.sortName=sortName
        this.report = new Report(instanceSize)
    }
    abstract sortM(items)
}
