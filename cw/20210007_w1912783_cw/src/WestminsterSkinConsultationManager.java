import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    Scanner scanner = new Scanner(System.in);

    public static ArrayList<Doctor> doctor_a = new ArrayList<Doctor>(10);




    private String name;
    private String surname;
    private LocalDate d_o_b;
    private String mobile_num;
    private String license_Number;
    private String special;




    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");



    @Override
    public void doc_details() {
        ArrayList<String> temp_a = new ArrayList<>();
        try {
            String temp;

            BufferedReader readFile =new BufferedReader(new FileReader(" details.txt"));

            while (((temp= readFile.readLine()) != null)){
                    temp_a.add(temp);
                System.out.println("lol");

            }


            while ( 0 < (temp_a.size()/6)) {

                doctor_a.add(new Doctor(temp_a.get(0), temp_a.get(1), LocalDate.parse(temp_a.get(2)), temp_a.get(3), temp_a.get(4),temp_a.get(5)));
                temp_a.subList(0,6).clear();

            }

            readFile.close();
            }


        catch (Exception ignored) {

        }

        }




    @Override
    public void add_doc() {
        while (true) {
            while (true) {
                System.out.print("Enter the name:");
                name = scanner.next();
                if (name.matches("[A-Za-z]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }
            }

            while (true) {
                System.out.print("Enter the surname:");
                surname = scanner.next();
                if (surname.matches("[A-Za-z]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }
            }


            while (true) {

                    try {
                        System.out.print("Enter the date of birth:");
                        String date= scanner.next();
                        d_o_b = LocalDate.parse(date);
                        sdf.parse(String.valueOf(d_o_b));
                        break;
                    } catch (ParseException e) {
                        System.out.println("Please Enter a Valid Value");
                        e.printStackTrace();
                        ;

                    }




            }




            while (true){
                System.out.print("Enter the Mobile Number:");
                mobile_num = scanner.next();
                if (mobile_num.matches("[0-9]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }

            }

            while (true) {
                System.out.print("Enter the License Number:");
                license_Number = scanner.next();
                if (license_Number.matches("[0-9]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }
            }

            while (true) {
                System.out.print("Enter the Specialisation:");
                special = scanner.next();
                if (special.matches("[A-Za-z]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }
            }


            System.out.println();
            //Doctor doctor = new Doctor(name, surname, d_o_b, mobile_num, license_Number, special);
            doctor_a.add(new Doctor(name, surname, d_o_b, mobile_num, license_Number, special));
            //doctor_a.add(doctor.getName() + "~" + doctor.getSurname() + "~" + doctor.getDate_of_birth() + "~" + doctor.getMobile_no() + "~" + doctor.getLicence_no() + "~" + doctor.getSpecialisation());
            System.out.println("Congratulations!");
            System.out.println("You Successfully added the new Doctor");
            System.out.println("Name            ----------> " + name + '\n' +
                    "SurName         ----------> " + surname + '\n' +
                    "Date-of-Birth   ----------> " + d_o_b + '\n' +
                    "Mobile-No       ----------> " + mobile_num + '\n' +
                    "MedicalLicence  ----------> " + license_Number + '\n' +
                    "Specialisation  ----------> " + special + '\n');

            /*for(int i=0; i<doctor_a.size(); i++){
                System.out.println("-----------------------------------");
                System.out.println("            DOCTOR "+i+1);
                System.out.println("-----------------------------------");


            }*/


            System.out.println("ADD CUSTOMERS ----> A or a \n" +
                    "QUIT ----> Q or q");
            String option = scanner.next();

            if (option.equals("q") || option.equals("Q")) {
                break;
            } else if (option.equals("a") || option.equals("A")) {
                continue;

            } else {
                System.out.println("Invalid option");
            }
        }

    }








   /* private Date validateAndParseDateJava7(String dateFormat) {
        System.out.print("Enter the date of birth:");
        String d_o_b = String.valueOf(LocalDate.parse(scanner.next()));
        Date date = null;
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(d_o_b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    } */




    public void delete_doc () {
        String l_n;
            while (true) {
                System.out.print("Enter the License Number:");
                l_n = scanner.nextLine();
                if (l_n.matches("[0-9]*")) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Value");

                }
            }
            for (int i = 0; i < doctor_a.size(); i++) {
                if (doctor_a.get(i).getLicence_no().equals(l_n)) {
                    doctor_a.remove(i);
                    System.out.println("You have successfully deleted the Doctor");
                    System.out.println("Name            ----------> " + name + '\n' +
                            "SurName         ----------> " + surname + '\n' +
                            "Date-of-Birth   ----------> " + d_o_b + '\n' +
                            "Mobile-No       ----------> " + mobile_num + '\n' +
                            "MedicalLicence  ----------> " + license_Number + '\n' +
                            "Specialisation  ----------> " + special + '\n');

                    break;


                }

            }











        /*
                System.out.print("Enter the License Number:");
                String l_n = scanner.nextLine();
                for(int i=0; i<doctor_a.size(); i++) {
                    if (Objects.equals(l_n, license_Number)) {
                        doctor_a.remove(i);


                    }

                }*/







       /* while(it.hasNext()) {
            String word = it.next();
            String response = notRecognised.get(word);
            if(l_n equals (words)) {
                it.remove();*/

        }

        @Override
        public ArrayList<Doctor> list_of_doctors () throws IOException {

            int i = doctor_a.size();
            String[] a_sort =new String[i];
            for(int j=0; j<doctor_a.size(); j++){
                a_sort[j]=(doctor_a.get(j).getSurname());

            }
            Arrays.sort(a_sort);


            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------- ");
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "NAME" ,"SURNAME" , "DATE OF BIRTH" , "MOBILE NUMBER" , "LICENSE NUMBER" , "SPECIALISATION");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------- ");
            for (String a: a_sort){
                for (Doctor doc : doctor_a) {
                    if(a.equals(doc.getSurname())){
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", doc.getName() ,doc.getSurname() , doc.getDate_of_birth() , doc.getMobile_no() , doc.getLicence_no() ,doc.getSpecialisation() );
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------- ");

                    }
                }
            }








        /*try {
            File doctors_list_r = new File("Doctor's Details.txt");
            Scanner myReader = new Scanner(doctors_list_r);
            while (myReader.hasNextLine()) {
                for (int i = 0; i < doctor_a.size(); i++) {
                    myReader.readInput(doctor_a.get(i).toString());
                    myReader.write("\n");
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch(FileNotFoundException e){
                System.out.println("An error occurred.");
            }*/


            return doctor_a;
        }

        @Override
        public void save_file () throws IOException {
            try {
                // Creates a BufferedWriter
                BufferedWriter output = new BufferedWriter(new FileWriter(" details.txt"));

                // Writes data to the file
                for (int i = 0; i < doctor_a.size(); i++) {
                    output.write(doctor_a.get(i).getName().toString());
                    output.write("\n");
                    output.write(doctor_a.get(i).getSurname().toString());
                    output.write("\n");
                    output.write(doctor_a.get(i).getDate_of_birth().toString());
                    output.write("\n");
                    output.write(doctor_a.get(i).getMobile_no().toString());
                    output.write("\n");
                    output.write(doctor_a.get(i).getLicence_no().toString());
                    output.write("\n");
                    output.write(doctor_a.get(i).getSpecialisation().toString());
                    output.write("\n");

                }
                output.close();

                System.out.println("Data is flushed to the file.");

            } catch (Exception e) {
                e.getStackTrace();
            }



        }

        @Override
        public void gui () {
            gui_menu gui = new gui_menu();
        }

}