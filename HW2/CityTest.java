/**
 * This class is for creating and testing the functionality of a city and its dependencies
 * @author Kyle Shepard
 * @version 1.0, 9 January 2019
 */
import java.util.ArrayList;
import java.util.Random;

public class CityTest{
    public static void main(String[] args){
        //Random used for giving chance for kid to skip school or police to go on patrol
        Random rnd = new Random();

        //multiple ArrayLists used for sorting different people into different buildings
        ArrayList<Person> allPeople = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Police> police = new ArrayList<>();
        ArrayList<Person> schoolPeople = new ArrayList<>();

        //police objects(sometimes on patrol but mostly at City Hall)
        allPeople.add(new Police("Jake Peralta",29,Police.Role.Patrol));
        allPeople.add(new Police("Raymond Holt",47,Police.Role.Captain));
        allPeople.add(new Police("Terry Jeffords",34,Police.Role.Sergeant));
        allPeople.add(new Police("Charles Boyle",31,Police.Role.Chief));
        allPeople.add(new Person());
        
        //teacher objects(always in schools)
        allPeople.add(new Teacher("Peter Tucker",50,true,14));
        allPeople.add(new Teacher("Kent Jones",56,true,13));
        allPeople.add(new Teacher("David Weaver",12,false,0));
        allPeople.add(new Teacher());

        //kid objects(students that are either in class or skip)
        allPeople.add(new Kid("Kyle Shepard",19,"Butterfinger"));
        allPeople.add(new Kid("Lauren Shepard",15,"Junior Mints"));
        allPeople.add(new Kid("Brooklyn Shepard",15,"Gummy Worms"));
        allPeople.add(new Kid("Some Child",8,"Dirt"));
        allPeople.add(new Kid());

        //Generic people(roam the city)
        allPeople.add(new Person("Chad",20));
        allPeople.add(new Person("Gloria",52));
        allPeople.add(new Person());

        //puts all people where they should be
        for(Person p : allPeople){
            if (p instanceof Police){
                if(rnd.nextInt(10) < 7) //70% chance for police to be in City Hall
                    police.add((Police)p);
                else
                    people.add(p);
            }
            else if (p instanceof Teacher){
                schoolPeople.add(p);    //100% chance for teachers to be at school
                //allPeople.remove(p);
            }
            else if (p instanceof Kid){
                if(rnd.nextInt(10) != 9)//90% chance for kids to be at school
                    schoolPeople.add(p);
                else
                    people.add(p);
            }
            else
                people.add(p);
        }

        //create both buildings for kids, teachers, and police to be in
        CityHall spoHall = new CityHall("Spokane City Hall", "808 W Spokane Falls Blvd", police);
        School spoSchool = new School("Whitworth", "300 W Hawthorne Rd", schoolPeople);

        //create the city with the building objects that were created
        City Spokane = new City("Spokane",spoHall,spoSchool,people);
        Spokane.listBuildingNames();
        Spokane.listPeople();
        Spokane.payEmployees();
    }
}