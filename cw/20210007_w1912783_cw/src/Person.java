import java.time.LocalDate;

public class Person {
    //Class Attributes
    private String name;
    private String surname;
    private LocalDate date_of_birth;
    private String mobile_no;

    //Class Constructor
    public Person(String name,String surname,LocalDate date_of_birth,String mobile_no){
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.mobile_no = mobile_no;
    }

    //Getters to access the private attributes
    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public LocalDate getDate_of_birth(){
        return this.date_of_birth;
    }

    public String getMobile_no(){
        return this.mobile_no;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate_of_birth(LocalDate date_of_birth){

        this.date_of_birth = date_of_birth;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    //Behavior Functionality




}
