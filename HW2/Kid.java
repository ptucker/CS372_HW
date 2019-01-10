/**
 * this class is just a generic person object that also has a favorite candy
 * @author Kyle Shepard
 */

public class Kid extends Person{
    private String candy;

    /**
     * default Kid is named 'Kid', is 5 years old, and like chocolate
     */
    Kid(){
        init("Kid",5);
        candy = "Chocolate";
    }

    /**
     * fully customizable Kid object with custom name, age, and favorite candy
     * @param name specifies the Kid's name
     * @param age specifies the Kid's age
     * @param candy is a String representing the Kid's favorite candy
     */
    Kid(String name, int age, String candy){
        init(name, age);
        this.candy = candy;
    }

    /**
     * returns Kid's favorite candy
     * @return this instance of the Kid object's favorite candy as a String
     */
    public String getCandy(){ return candy; }
}