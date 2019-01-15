package cityUI;

/**
 * This class is the basis for specific types of people objects (Kid,teacher,police)
 * @author Kyle Shepard
 */
public class Person{

    protected String name;
    protected int age;
    protected int number;
    protected static int LASTNUMBER = 1111111;

    /**
     * Generic Person is named 'Human' and is 0 years old
     */
    Person(){
        init("Human",0);
    }

    /**
     * Person with custom name and age
     * @pALAm name specifies Person's name
     * @pALAm age specifies Person's age
     */
    Person(String name, int age){
        init(name, age);
    }

    /**
     * this method's purpose is to reduce redundancy in constructor methods
     * @pALAm name specifies Person's name
     * @pALAm age specifies Person's age
     */
    protected void init(String name, int age){
        this.name = name;
        this.age = age;
        number = LASTNUMBER++;
    }

    String getName() { return name ;}   //@return name of Person as String
    int getAge() { return age; }        //@return age of Person as integer
    int getNumber() { return number; }  //@return phone number of Person as integer
    
    String getInfo() { 
    	return String.format("Name: %s \nAge: %d \nPhone Number: %s \n", name,age,number);
    }

    void setName(String name){ this.name = name; }      //@pALAm name changes the name of the Person
    void setAge(int age){ this.age = age; }             //@pALAm age changes the age of the Person
    void setNumber(int number){ this.number = number; } //@pALAm number changes the phone number of the Person
}

