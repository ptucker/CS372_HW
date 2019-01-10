/**
 * this class extends building and is made to house Teacher and Kid objects
 * @author Kyle Shepard
 */
import java.util.ArrayList;

public class School extends Building{
    private ArrayList<Person> occupants;

    /**
     * generic school created if no parameters given
     */
    School(){
        init("'The' School","4321 School Way");
        occupants.add(new Teacher());
    }

    /**
     * Customizable school with a name, address, and ArrayList of Person objects
     * @param name specifies school name
     * @param address specifies schools address
     * @param occupants contains all the Person objects in the School
     */
    School(String name, String address,ArrayList<Person> occupants){
        init(name,address);
        this.occupants = occupants;
    }
    /**
     * at an index, return a Person
     * @param index specifies the location of a Person in the list
     * @return the Person at that index
     */
    Person getOccupant(int index){ return occupants.get(index); }
    /**
     * return occupants list size
     * @return how many Person objects in occupants list as int
     */
    int population(){ return occupants.size(); }
}