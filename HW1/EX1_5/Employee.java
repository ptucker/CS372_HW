public class Employee{

    static int IDPool = 1;

    private int ID;
    private String name;
    private String hireDate;
    private String position;
    private String manager;

    public Employee(){
        this.ID = IDPool++;
        this.name = "unknown";
        this.hireDate = "January 1st, 1970";
        this.position = "unknown";
        this.manager = "unknown";
    }

    public Employee(String name, String hireDate, String position, String manager){
        this.ID = IDPool++;
        this.name = name;
        this.hireDate = hireDate;
        this.position = position;
        this.manager = manager;
    }

    int getID(){ return ID; }
    String getName(){ return name; }
    String getHireDate(){ return hireDate; }
    String getPosition(){ return position; }
    String getManager(){ return manager; }

    public String toString(){
        return String.format(name + ", with ID number " + ID + " is a(n) " + position + " under the manager " + manager + ". He/she was hired " + hireDate);
    }
}