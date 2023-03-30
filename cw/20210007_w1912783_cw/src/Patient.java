import java.time.LocalDate;
import java.time.LocalTime;

public class Patient extends Person{
    // Private Class Attribute
    private String id;

    //Class Constructor
    public Patient(String name, String surname, LocalDate date_of_birth, String mobile_no, String id) {
        super(name, surname, date_of_birth, mobile_no);
        this.id = id;
    }

    //Getters to access one private attribute
    public String getId(){
        return this.id;
    }

    //Setters
    public void setId(String id){
        this.id = id;
    }

}
