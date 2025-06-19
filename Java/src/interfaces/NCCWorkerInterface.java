package interfaces;
enum WeekDay{
    // only these objects can be called
    SUNDAY("sun",0), MONDAY("mon",1), TUESDAY("tue",2), WEDNESDAY("wed",3), THURSDAY("thu",4), FRIDAY("fri",5), SATURDAY("sat",6);
    String name;
    int number;
    WeekDay(String name, int number){
        this.name=name;
        this.number=number;
    }
}
interface NCCWorker{
    String getRank(); // cadet, corporal, sergeant
    int getBatch(); // year like 2018, 2019
    String getZone(); // north, east, west, south
}
class Student implements NCCWorker{
    String name, rank, zone;
    int batch;

    public Student(String name, String rank, String zone, int batch) {
        this.name = name;
        this.rank=rank;
        this.batch=batch;
        this.zone=zone;
    }
    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public int getBatch() {
        return batch;
    }

    @Override
    public String getZone() {
        return zone;
    }

    public void showDetails(){
        System.out.println("Name: "+name);
        System.out.println("Rank: "+rank);
        System.out.println("Zone: "+zone);
        System.out.println("Batch: "+batch);
    }
}
public class NCCWorkerInterface {
    public static void main(String[] args){
        Student ncc1=new Student("Sasank","Subedar","South",2025);
        ncc1.showDetails();
    }
}