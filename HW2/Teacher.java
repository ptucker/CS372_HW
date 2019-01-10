/**
 * this class extends Person and represents a teacher with Employee functionality, certification, and gradeLevel
 */
public class Teacher extends Person implements Employee{
    private boolean certification = false;
    private int gradeLevel;
    private static int IDs = 1;
    private int ID;

    Teacher(){
        /**
         * Generic teacher with no certification and no grade level
         */
        init("Teacher",25);
        ID = IDs++;
        gradeLevel = 0;
    }

    /**
     * Teacher constructor with custom paramters
     * @param name specifies Person name
     * @param age specifies Person age
     * @param certification specifies if teacher is certified or not
     * @param gradeLevel specifies what grade level the teacher teaches at
     */
    Teacher(String name, int age, boolean certification, int gradeLevel){
        init(name,age);
        ID = IDs++;
        this.certification = certification;
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() { return gradeLevel; }           //@return grade level the teacher teaches at
    public boolean getCertification() { return certification; } //@return whether or not the teacher is certified
    public int getID(){ return ID; }                            //@return employee ID as integer

    public void payEmployee(){                                  //void function to print name, employee ID, and a payment success message
        System.out.printf("Teacher %s with employee ID# %d paid.\n",name,ID);
    }

}