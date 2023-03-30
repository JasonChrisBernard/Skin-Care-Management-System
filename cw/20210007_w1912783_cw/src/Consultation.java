import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends Patient{
    private String doctor_id;
    //Private Class Attributes
    private LocalDate date;
    private LocalTime s_time;
    private LocalTime e_time;
    private String cost;
    private String notes;



    //Class Constructor
    public Consultation(String name, String surname, LocalDate date_of_birth, String mobile_no, String id,String doc_id,LocalDate date, LocalTime s_time, LocalTime e_time, String cost, String notes){
        super(name, surname, date_of_birth, mobile_no,id);
        this.doctor_id = doc_id;
        this.date = date;
        this.s_time = s_time;
        this.e_time = e_time;
        this.cost = cost;
        this.notes = notes;
    }



    //Getters
    public String getDoctor_id(){return this.doctor_id;}
    public LocalDate getDate(){
        return this.date;
    }
    public LocalTime getS_time(){
        return this.s_time;
    }
    public LocalTime getE_time(){
        return this.e_time;
    }
    public String getCost(){
        return this.cost;
    }
    public String getNotes(){
        return this.notes;
    }

    //Setters
    public void setDoctor_id(String doctor_id){
        this.doctor_id = doctor_id;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setS_time(LocalTime time) {
        this.s_time = time;
    }

    public void setE_time(LocalTime e_time) {
        this.e_time = e_time;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
