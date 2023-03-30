import java.time.LocalDate;

public class Doctor extends Person{
    //Private Class Attributes
    private String licence_no;
    private String specialisation;

    //Class Constructor
    public Doctor(String name, String surname, LocalDate date_of_birth, String mobile_no, String licence_no, String specialisation) {
        super(name, surname, date_of_birth, mobile_no);
        this.licence_no = licence_no;
        this.specialisation = specialisation;

    }

    //Getters to access the private attributes

    public String getLicence_no(){return this.licence_no;}

    public String getSpecialisation(){
        return this.specialisation;
    }

    //Setters

    public void setLicence_no(String licence_no){
        this.licence_no = licence_no;
    }

    public void setSpecialisation(String Specialisation){
        this.specialisation = Specialisation;
    }

    public String toString() {
        return  this.getName() + ' ' +
                this.getSurname() + ' ' +
                this.getDate_of_birth() + ' ' +
                this.getMobile_no() + ' ' +
                licence_no + ' ' +
                specialisation +' ';
    }


}


