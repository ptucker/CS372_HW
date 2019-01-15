package cityUI;

import java.util.ArrayList;

/**
 * This class the basic framework for CityHall and School to inherit from
 * @author Kyle Shepard
 */
public class Building{
    protected String name;
    protected String address;
    protected ArrayList<Person> occupants;
    /**
     * Default constructor creates generic building object by calling init()
     */
    Building(){
        init("Unnamed Building","No known address");
        occupants.add(new Person());
    }

    /**
     * this constructor allows a fully-customized Building to be created with a name and address by calling init()
     * @pALAm name specifies the name of the building
     * @pALAm address specifies the physical address of the building
     */
    Building(String name, String address,ArrayList<Person> occupants){
        init(name,address);
        this.occupants = occupants;
    }

    /**
     * exists to reduce redundancy in constructors for Building and all child objects
     * @pALAm name specifies the name of the building
     * @pALAm address specifies the physical address of the building
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
    
    /**
     * at an index, return a Person
     * @pALAm index specifies the location of a Person in the list
     * @return the Person at that index
     */
    Person getOccupant(int index){ return occupants.get(index); }
    
    /**
     * return occupants list size
     * @return how many Person objects in occupants list as int
     */
    int population(){ return occupants.size(); }
    
    void addOccupant(Person p) {
    	occupants.add(p);
    }
    
    void removeOccupant(int index) {
    	occupants.remove(index);
    }
}