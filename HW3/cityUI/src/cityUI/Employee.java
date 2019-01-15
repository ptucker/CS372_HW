package cityUI;


/**
 * the purpose of this interface is to ensure that Person objects that want to be paid must implements the methods from this interface
 * @author Kyle Shepard
 */
public interface Employee{
    /**
     * implemenation should just be printing a message that employee with ID# whatever was paid
     */
    void payEmployee();
    /**
     * return employee ID
     * @return Employee ID number
     */
    int getID();
}