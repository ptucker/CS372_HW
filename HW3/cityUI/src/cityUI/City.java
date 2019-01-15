package cityUI;


/**
 * This class models a city object, which has a name, buildings for people to be in, and an 'outside'
 * @author Kyle Shepard
 */
import java.util.ArrayList;

public class City{
    private String name;
    CityHall cityhall;  //contains police officers
    School school;  //contains teachers and children
    ArrayList<Person> people;   //stores all people not in school or city hall
    /**
     * creates a generic city with name "unknown" and default buildings and 'outside'(people ArrayList)
     */
    City(){
        name = "unknown";
        cityhall = new CityHall();
        school = new School();
        people.add(new Person());
    }

    /**
     * fully featured constructor with pALAmeters for an entirely customized city
     * @pALAm name specifies name of the city
     * @pALAm cityhall contains an entire CityHall object filled with Police objects
     * @pALAm school contains an entire School object filled with Teacher and Kid objects
     * @pALAm people contains all people roaming about town
     */
    City(String name, CityHall cityhall, School school, ArrayList<Person> people){
        this.name = name;
        this.cityhall = cityhall;
        this.school = school;
        this.people = people;
    }

    /**
     * Prints the names of the City Hall and School objects
     */
    void listBuildingNames(){
        System.out.println("City Hall:\n" + cityhall.getName());
        System.out.println("Schools:\n" + school.getName());
    }

    /**
     * calls the method for printing out the list of each person in school, city hall, or outside
     */
    void listPeople(){
        listCityHallPeople();
        listSchoolPeople();
        listCityPeople();
    }

    /**
     * prints out a list of all Police currently in city hall
     */
    void listCityHallPeople(){
        System.out.printf("\nOccupants of %s:\n",cityhall.getName());

        for (int i = 0; i < cityhall.population(); i++) {
            System.out.println(cityhall.getOccupant(i).getName());
        }
    }

    /**
     * prints a list of all Kids and Teachers in the school
     */
    void listSchoolPeople(){
        System.out.printf("\nOccupants of %s:\n",school.getName());

        for(int i = 0; i < school.population(); i++){
            System.out.println(school.getOccupant(i).getName());
        }
    }

    /**
     * prints a list of any Person roaming about town (and prints a special message if it notices a Kid is skipping school!)
     */
    void listCityPeople(){
        System.out.printf("\nOccupants of %s wandering about town:\n",name);
        for (int i = 0; i < people.size(); i++){
            if(people.get(i) instanceof Kid)
                System.out.println(people.get(i).getName() + " has skipped school and should not be here!");
            else
                System.out.println(people.get(i).getName());
        }
    }

    /**
     * iterates through all lists for employees, and pays them
     */
    void payEmployees(){
        for (int i = 0; i < cityhall.population(); i++) {
        	if(school.getOccupant(i) instanceof Employee)
        		((Employee)cityhall.getOccupant(i)).payEmployee();
        }

        for(int i = 0; i < school.population(); i++){
            if(school.getOccupant(i) instanceof Employee)
                ((Employee)school.getOccupant(i)).payEmployee();
        }

        for (int i = 0; i < people.size(); i++){
            if(people.get(i) instanceof Employee)
                ((Employee)people.get(i)).payEmployee();
        }
    }
}