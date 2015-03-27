/**
 * Created by Gabriel on 24/03/2015.
 */
abstract class SortMethod {
    String sortName;
    Report report;

    public SortMethod(String sortName,long instanceSize){
        this.sortName=sortName;
        this.report = new Report(instanceSize);
    }

    //toString con el nombre del ordenamiento
    //mas su respectivo reporte

    public String getSortNameAndReport(){
        return sortName+"\t"+report.getReportString();
    }

    @Override
    public String toString(){
        return  ("-------------------\n"
                + "* "+sortName
                + "\n-------------------\n"
                + report.toString());
    }

    public abstract int[] sortM(int[] items);
}
