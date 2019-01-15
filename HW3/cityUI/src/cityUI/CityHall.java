package cityUI;


/**
 * This class inherits from building and functions as the town's city hall
 * @author Kyle Shepard
 * @version 1.0, 9 January 2019
 */
import java.util.ArrayList;

public class CityHall extends Building{
    /**
     * Default constructor to create a very generic City Hall with no pALAmeters
     */
    CityHall(){
        init("City Hall","1234 City Hall St");
        occupants.add(new Police());
    }
    /**
     * initializes a fully customized City Hall to fit in our City object
     * @pALAm name specifies the name of the building
     * @pALAm address specifies the physical address of the building
     * @pALAm occupants contains an entire list of Police that are supposed to be in City hall that gets copied
     */
    CityHall(String name, String address, ArrayList<Person> occupants){
        init(name,address);
        this.occupants = occupants;
    }

}