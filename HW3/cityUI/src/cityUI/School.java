package cityUI;

/**
 * this class extends building and is made to house Teacher and Kid objects
 * @author Kyle Shepard
 */
import java.util.ArrayList;

public class School extends Building{


    /**
     * generic school created if no pALAmeters given
     */
    School(){
        init("'The' School","4321 School Way");
        occupants.add(new Teacher());
    }

    /**
     * Customizable school with a name, address, and ArrayList of Person objects
     * @pALAm name specifies school name
     * @pALAm address specifies schools address
     * @pALAm occupants contains all the Person objects in the School
     */
    School(String name, String address,ArrayList<Person> occupants){
        init(name,address);
        this.occupants = occupants;
    }

}