import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        WestminsterSkinConsultationManager console = new WestminsterSkinConsultationManager();
        console.doc_details();
        while (true) {

            System.out.println("------SKIN CONSULTATION SYSTEM MENU------\n" +
                    "1) Add Doctor \n" +
                    "2) Delete Doctor \n" +
                    "3) List of Doctors \n" +
                    "4) Save  into a file \n" +
                    "5) Display GUI");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the option :");
            String option = scanner.nextLine();

                    if (Objects.equals(option, "1")) {
                        console.add_doc();
                    }
                    else if(Objects.equals(option, "2")){
                        console.delete_doc();
                    }
                    else if (Objects.equals(option, "3")) {

                        console.list_of_doctors();

                    }
                    else if (Objects.equals(option, "4")) {
                        console.save_file();

                    }

                    else if (Objects.equals(option, "5")) {
                        new gui_menu();
                    }

                    else {
                        System.out.println("Invalid Option");
                    }




            }


        }


    }
