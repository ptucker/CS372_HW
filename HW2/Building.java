/**
 * This class the basic framework for CityHall and School to inherit from
 * @author Kyle Shepard
 */
public class Building{
    protected String name;
    protected String address;

    /**
     * Default constructor creates generic building object by calling init()
     */
    Building(){
        init("Unnamed Building","No known address");
    }

    /**
     * this constructor allows a fully-customized Building to be created with a name and address by calling init()
     * @param name specifies the name of the building
     * @param address specifies the physical address of the building
     */
    Building(String name, String address){
        init(name,address);
    }

    /**
     * exists to reduce redundancy in constructors for Building and all child objects
     * @param name specifies the name of the building
     * @param address specifies the physical address of the building
     */
    protected void init(String name, String address){
        this.name = name;
        this.address = address;
    }
    /**
     * returns the name of the building
     * @return a String representation of the building name
     */
    public String getName(){ return name; }
    /**
     * returns the address of the building
     * @return a String representation of the address of the building
     */
    public String getAddress(){ return address; }
    
}