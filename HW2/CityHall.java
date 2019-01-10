/**
 * This class inherits from building and functions as the town's city hall
 * @author Kyle Shepard
 * @version 1.0, 9 January 2019
 */
import java.util.ArrayList;

public class CityHall extends Building{
    private ArrayList<Police> occupants;
    /**
     * Default constructor to create a very generic City Hall with no parameters
     */
    CityHall(){
        init("City Hall","1234 City Hall St");
        occupants.add(new Police());
    }
    /**
     * initializes a fully customized City Hall to fit in our City object
     * @param name specifies the name of the building
     * @param address specifies the physical address of the building
     * @param occupants contains an entire list of Police that are supposed to be in City hall that gets copied
     */
    CityHall(String name, String address, ArrayList<Police> occupants){
        init(name,address);
        this.occupants = occupants;
    }
    /**
     * return Police object by index in the list of Police
     * @param index specifies the location at which a certain Police exists in the occupants list
     * @return the corresponding Police object
     */
    Police getOccupant(int index){ return occupants.get(index); }
    /**
     * report the size of the occupant list
     * @return the number of elements in the occupants ArrayList
     */
    int population(){ return occupants.size(); }
}