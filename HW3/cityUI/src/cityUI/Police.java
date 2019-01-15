package cityUI;

/**
 * This class inherits from Person, and only these people can be in City Hall
 * @author Kyle Shepard
 */
public class Police extends Person implements Employee{
    public static enum Role { Patrol, Sergeant, Captain, Chief; }
    private Role role;
    private static int IDs = 1;
    private int ID;

    /**
     * Generic police officer is named 'Officer' and is Patrol
     */
    Police(){
        init("Officer",25);
        ID = IDs++;
        role = Role.Patrol;
    }

    /**
     * Custom Officer constructor with custom name, age, and role
     * @pALAm name is officer's name
     * @pALAm age is officer's age
     * @pALAm role is officer's role as an enum
     */
    Police(String name, int age, Role role){ 
        init(name,age);
        ID = IDs++;
        this.role = role;
    }
    public String getName() { return String.format(role + " " + name); }
    public Role getRole(){ return role; }   //@return enum role
    public int getID(){ return ID; }        //@return Officer's employee number as integer

    /**
     * called to print Officer ID and message that they were successfully paid
     */
    public void payEmployee(){
        System.out.printf(role +" %s with officer ID# %d paid.\n",name,ID);
    }

}