import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class gui_add_consultation extends JFrame implements ActionListener {




    public JPanel panel;

    public JLabel label_t,patient_details,p_name,p_surname,p_d_o_b,p_mobile_no,p_id,p_note;

    public static ArrayList<Patient> patient_a = new ArrayList<Patient>();

    public JTextField b_name,b_surname,b_d_o_b,b_mobile_no,b_id,b_note;
    public JButton submit,back;

    public String name;
    public String surname;
    public String d_o_b;
    public String mobile_no;
    public String id;



    public gui_add_consultation(){


        //Create topic//

        //Add consultation
        label_t = new JLabel();
        label_t.setText("Add consultation");
        label_t.setBounds(230, -85, 500, 250);
        label_t.setFont(new Font("Arial Font", Font.BOLD,30));



        //-Patient details-//
        patient_details = new JLabel();
        patient_details.setText("Patient Details");
        patient_details.setBounds(60, 100, 500, 100);
        patient_details.setFont(new Font("Arial Font", Font.BOLD,15));









        // Name//
        p_name = new JLabel();
        p_name.setText("Name");
        p_name.setBounds(70, 88, 250, 250);
        p_name.setFont(new Font("Arial Font", Font.BOLD,12));
        b_name = new JTextField();
        b_name.setBounds(200,200,110,25);




       // panel.add(p_name);
       // panel.add(b_name);

        //Surname//
        p_surname = new JLabel();
        p_surname.setText("Surname");
        p_surname.setBounds(70, 138, 250, 250);
        p_surname.setFont(new Font("Arial Font", Font.BOLD,12));
        b_surname = new JTextField();
        b_surname.setBounds(200,250,110,25);

        //Date of Birth//
        p_d_o_b = new JLabel();
        p_d_o_b.setText("Date of Birth");
        p_d_o_b.setBounds(70, 188, 250, 250);
        p_d_o_b.setFont(new Font("Arial Font", Font.BOLD,12));
        b_d_o_b = new JTextField();
        b_d_o_b.setBounds(200,300,110,25);

        //Mobile number//
        p_mobile_no = new JLabel();
        p_mobile_no.setText("Mobile Number");
        p_mobile_no.setBounds(70, 238, 250, 250);
        p_mobile_no.setFont(new Font("Arial Font", Font.BOLD,12));
        b_mobile_no = new JTextField();
        b_mobile_no.setBounds(200,350,110,25);

        //Patient id//
        p_id = new JLabel();
        p_id.setText("Patient ID");
        p_id.setBounds(70, 288, 250, 250);
        p_id.setFont(new Font("Arial Font", Font.BOLD,12));
        b_id = new JTextField();
        b_id.setBounds(200,400,110,25);



        //Patient-Note//
        p_note = new JLabel();
        p_note.setText("Patient Note");
        p_note.setBounds(60, 350, 250, 250);
        p_note.setFont(new Font("Arial Font", Font.BOLD,15));
        b_note = new JTextField();
        b_note.setBounds(60,500,420,220);
        b_note.setPreferredSize(new Dimension(420,220));






        //Button Submit//
        submit = new JButton();
        submit.addActionListener((ActionListener) this);
        submit.setBounds(60,730,200,50);

        submit.setText("Jason");
        submit.setForeground(Color.BLACK);
        submit.setFocusable(true);
        submit.setHorizontalTextPosition(JButton.CENTER);
        submit.setBackground(Color.decode("#90EE90"));











        //--Create frame--//

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(720,820);
        this.getContentPane().setBackground(Color.decode("#04cc82"));
        this.setVisible(true);
        this.add(label_t);
        this.add(patient_details);
        this.add(submit);
        this.add(p_name);
        this.add(b_name);

        this.add(p_surname);
        this.add(b_surname);
        this.add(p_d_o_b);
        this.add(b_d_o_b);
        this.add(p_mobile_no);
        this.add(b_mobile_no);
        this.add(p_id);
        this.add(b_id);
        this.add(p_note);
        this.add(b_note);




        //frame.add(panel);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            name = b_name.getText();
            surname = b_surname.getText();
            d_o_b = b_d_o_b.getText();
            try {
                d_o_b = String.valueOf(LocalDate.parse(b_d_o_b.getText()));
            } catch (DateTimeException ex) {
                System.out.println("Date is incorrect");
            }

            mobile_no = b_mobile_no.getText();
            id = b_id.getText();



            this.dispose();

            //System.out.println(patient_a);



            //Save the data into a text file
            try {
                // Creates a BufferedWriter
                BufferedWriter output = new BufferedWriter(new FileWriter("patient_details.txt"));

                // Writes data to the file
                for (int i = 0; i < patient_a.size(); i++) {
                    output.write(patient_a.get(i).getName().toString());
                    output.write("\n");
                    output.write(patient_a.get(i).getSurname().toString());
                    output.write("\n");
                    output.write(patient_a.get(i).getDate_of_birth().toString());
                    output.write("\n");
                    output.write(patient_a.get(i).getMobile_no().toString());
                    output.write("\n");
                    output.write(patient_a.get(i).getId().toString());
                    output.write("\n");


                }
                output.close();

                System.out.println("Data is flushed to the file.");

            } catch (Exception ignored) {

            }

            //Save the data from the text file to the array
            ArrayList<String> temp_ar = new ArrayList<>();
            try {
                String temp;

                BufferedReader readFile =new BufferedReader(new FileReader("patient_details.txt"));

                while (((temp= readFile.readLine()) != null)){
                    temp_ar.add(temp);


                }


                while ( 0 < (temp_ar.size()/6)) {


                    temp_ar.subList(0,6).clear();

                }

                readFile.close();
            }


            catch (Exception ignored) {

            }


        }

    }
}
