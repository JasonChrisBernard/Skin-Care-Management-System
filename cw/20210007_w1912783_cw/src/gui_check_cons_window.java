import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class gui_check_cons_window extends JFrame implements ActionListener {

    static Object[] details;
    JButton l_o_doc_button, consultation_button;
    public DefaultTableModel model;

    public JTable table;

    public JScrollPane sp;
    public JFrame frame;


    private final JLabel label;
    private final JLabel cost_l;
    private final JLabel p_mobile_no;
    private final JLabel p_id;
    private final JLabel p_note;

    private final JLabel p_license_no;
    private final JButton add_cons;
    private final JButton view_cons;
    private final JTextField date_t;
    //private JTextField time_st;
    //private JTextField time_end;
    private final JTextArea b_note;

    private final JComboBox<String> st_1;
    private final JComboBox<String> st_2;

    private final JComboBox<String> et_1;
    private final JComboBox<String> et_2;


    final static ArrayList<Patient> patient_a = new ArrayList<Patient>();

    public JTextField b_name,b_surname,b_d_o_b,b_mobile_no,b_id;
    public JButton submit,back;

    private String name;
    private String surname;
    private LocalDate d_o_b;
    private String mobile_no;
    private String id;

    private String mobile_num;

    private String license_Number;

    private String special;

    public static ArrayList<Consultation> consultation_a = new ArrayList<Consultation>();


    private LocalDate date;
    private LocalTime s_time;


    private LocalTime e_time;

    private String duration;

    private String cost;

    private String notes;

    private String hrs;
    private String mins;


    private final JComboBox<String> comboBox_doc;

    public String[] col = {"NAME", "SURNAME", "DATE OF BIRTH", "MOBILE NUMBER", "LICENSE NUMBER", "SPECIALISATION"};

    gui_check_cons_window() {


        //To create the Topic name by using the JLabel Class
        label = new JLabel();
        label.setText("Check Doctor's Availability");
        label.setBounds(400, -85, 500, 250);
        label.setFont(new Font("Arial Font", Font.BOLD, 30));


        //To Create the table
        model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        table.setBounds(35, 100, 800, 250);
        table.setModel(model);


        for (Doctor doctor : WestminsterSkinConsultationManager.doctor_a) {
            String[] details = {doctor.getName(), doctor.getSurname(), String.valueOf(doctor.getDate_of_birth()), doctor.getMobile_no(), doctor.getLicence_no(), doctor.getSpecialisation()};
            model.addRow(details);
            String[] doctor_id = {doctor.getLicence_no()};

        }


        //To create ScrollPane
        sp = new JScrollPane(table);
        table.setGridColor(Color.black);

        //Code functionality

        /*
        //To create the list of doctors button
        l_o_doc_button = new JButton();
        l_o_doc_button.setBounds(100,130,250,100);
        l_o_doc_button.addActionListener((ActionListener) this);
        l_o_doc_button.setText("List of Doctors");
        l_o_doc_button.setForeground(Color.BLACK);
        l_o_doc_button.setFocusable(false);
        l_o_doc_button.setHorizontalTextPosition(JButton.CENTER);
        l_o_doc_button.setBackground(Color.decode("#90EE90"));

        //To create the consultant details button
        add_consultation_button = new JButton();
        add_consultation_button.setBounds(100,270,250,100);
        add_consultation_button.addActionListener(this);
        add_consultation_button.setText("Consultation");
        add_consultation_button.setForeground(Color.BLACK);
        add_consultation_button.setFocusable(false);
        add_consultation_button.setHorizontalTextPosition(JButton.CENTER);
        add_consultation_button.setBackground(Color.decode("#90EE90"));
           */

        // Name//
        JLabel p_name = new JLabel();
        p_name.setText("Name");
        p_name.setBounds(60, 328, 250, 250);
        p_name.setFont(new Font("Arial Font", Font.BOLD,12));
        b_name = new JTextField();
        b_name.setBounds(110,440,110,25);

        //Surname//
        //private final JLabel label_t;
        //private final JLabel patient_details;
        JLabel p_surname = new JLabel();
        p_surname.setText("Surname");
        p_surname.setBounds(260, 328, 250, 250);
        p_surname.setFont(new Font("Arial Font", Font.BOLD,12));
        b_surname = new JTextField();
        b_surname.setBounds(320,440,150,25);

        //Date of Birth//
        JLabel p_d_o_b = new JLabel();
        p_d_o_b.setText("Date of Birth");
        p_d_o_b.setBounds(500, 328, 250, 250);
        p_d_o_b.setFont(new Font("Arial Font", Font.BOLD,12));
        b_d_o_b = new JTextField();
        b_d_o_b.setBounds(590,440,110,25);

        //Mobile number//
        p_mobile_no = new JLabel();
        p_mobile_no.setText("Mobile Number");
        p_mobile_no.setBounds(730, 328, 250, 250);
        p_mobile_no.setFont(new Font("Arial Font", Font.BOLD,12));
        b_mobile_no = new JTextField();
        b_mobile_no.setBounds(830,440,110,25);

        //Patient id//
        p_id = new JLabel();
        p_id.setText("Patient ID");
        p_id.setBounds(970, 328, 250, 250);
        p_id.setFont(new Font("Arial Font", Font.BOLD,12));
        b_id = new JTextField();
        b_id.setBounds(1030,440,110,25);



        //To create the combo box

        String [] doc = new String[WestminsterSkinConsultationManager.doctor_a.size()];
        for(int i = 0; WestminsterSkinConsultationManager.doctor_a.size()>i; i++){
            doc[i]= WestminsterSkinConsultationManager.doctor_a.get(i).getLicence_no();
        }




        //J combo box license no
        p_license_no = new JLabel();
        p_license_no.setText("License Number");
        p_license_no.setBounds(60, 378, 250, 250);
        p_license_no.setFont(new Font("Arial Font", Font.BOLD, 12));
        comboBox_doc = new JComboBox<>(doc);
            comboBox_doc.setBounds(300, 490, 75, 25);


        String[] hrs = { "HH","08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21","22" };
        String[] mins = { "MM","00", "05", "10", "15","20", "25", "30", "35","40", "45", "50", "55","60"};
        String[] duration = { "HH","00", "01", "02", "03","04", "05", "06", "07","08", "09", "10", "11","12"};


        //To create the text field and label_t for date and time_st

        //Date
        JLabel date_l = new JLabel();
        date_l.setText("Consultation Date");
        date_l.setBounds(420, 378, 250, 250);
        date_l.setFont(new Font("Arial Font", Font.BOLD, 12));
        date_t = new JTextField();
        date_t.setBounds(530, 490, 75, 25);


        //Time
        //Start time
        JLabel time_stl = new JLabel();
        time_stl.setText("Start Time");
        time_stl.setBounds(630, 378, 250, 250);
        /*time_stl.setFont(new Font("Arial Font", Font.BOLD, 12));
        time_st = new JTextField();
        time_st.setBounds(700, 490, 75, 25);*/
        st_1 =new JComboBox<>(hrs);
        st_1.setBounds(700, 490, 75, 25);
        st_2 =new JComboBox<>(mins);
        st_2.setBounds( 800, 490, 75, 25);



        //End time
        JLabel time_enl = new JLabel();
        time_enl.setText("End Time");
        time_enl.setBounds(900, 378, 250, 250);
        et_1 =new JComboBox<>(hrs);
        et_1.setBounds( 1000, 490, 75, 25);
        et_2 =new JComboBox<>(mins);
        et_2.setBounds( 1100, 490, 75, 25);

        /*time_enl.setFont(new Font("Arial Font", Font.BOLD, 12));
        time_end = new JTextField();
        time_end.setBounds(850, 490, 75, 25);*/

        //Cost
        cost_l = new JLabel();
        cost_l.setText("25");
        cost_l.setBounds(850, 378, 250, 250);

        //Notes
        p_note = new JLabel();
        p_note.setText("Patient Note :");
        p_note.setBounds(130, 450, 250, 250);
        p_note.setFont(new Font("Arial Font", Font.BOLD,15));
        b_note = new JTextArea();
        b_note.setBounds(240,560,420,220);
        b_note.setPreferredSize(new Dimension(420,220));


        //To create a button
        //add consultation
        add_cons = new JButton();
        add_cons.setBounds(30, 740, 200, 50);
        add_cons.addActionListener((ActionListener) this);
        add_cons.setText("Add Consultation");
        add_cons.setForeground(Color.BLACK);
        add_cons.setFocusable(false);
        add_cons.setHorizontalTextPosition(JButton.CENTER);
        add_cons.setBackground(Color.decode("#90EE90"));

        //check consultation
        view_cons = new JButton();
        view_cons.setBounds(770, 740, 200, 50);
        view_cons.addActionListener((ActionListener) this);
        view_cons.setText("View Consultation");
        view_cons.setForeground(Color.BLACK);
        view_cons.setFocusable(false);
        view_cons.setHorizontalTextPosition(JButton.CENTER);
        view_cons.setBackground(Color.decode("#90EE90"));

        //back button
        JButton back_button = new JButton();
        back_button.setBounds(980, 740, 200, 50);
        back_button.addActionListener((ActionListener) this);
        back_button.setText("Back");
        back_button.setForeground(Color.BLACK);
        back_button.setFocusable(false);
        back_button.setHorizontalTextPosition(JButton.CENTER);
        back_button.setBackground(Color.decode("#90EE90"));


        //To create the frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1200, 830);
        frame.getContentPane().setBackground(Color.decode("#04cc82"));
        frame.setVisible(true);
        frame.add(label);
        sp.setBounds(60, 80, 1050, 333);
        frame.add(sp);
        frame.add(comboBox_doc);
        frame.add(p_name);
        frame.add(b_name);
        frame.add(p_surname);
        frame.add(b_surname);
        frame.add(p_d_o_b);
        frame.add(b_d_o_b);
        frame.add(p_mobile_no);
        frame.add(b_mobile_no);
        frame.add(p_license_no);
        frame.add(date_t);
        frame.add(date_l);
        frame.add(time_stl);
        frame.add(st_1);
        frame.add(st_2);
        frame.add(time_enl);
        frame.add(et_1);
        frame.add(et_2);

        /*frame.add(time_st);

        frame.add(time_end);*/
        frame.add(p_id);
        frame.add(b_id);
        frame.add(p_note);
        frame.add(b_note);
        frame.add(cost_l);
        frame.add(add_cons);
        frame.add(view_cons);
        frame.add(back_button);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_cons) {
            try {
                date = LocalDate.parse(date_t.getText());
            } catch (DateTimeException ex) {
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT DATE", "title", JOptionPane.ERROR_MESSAGE);
            }
            if(date.isBefore(LocalDate.parse("2023-01-10"))){
                JOptionPane.showMessageDialog(null, "PAST DATE IS NOT ACCEPTED", "title", JOptionPane.ERROR_MESSAGE);
            }

            hrs = (String) st_1.getSelectedItem();
            mins = (String) st_2.getSelectedItem();
            s_time = LocalTime.parse(hrs + ":" + mins + ":00");

            try {
                s_time = LocalTime.parse(hrs + ":" + mins + ":00");
            } catch (DateTimeException ex) {
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT DATE", "title", JOptionPane.ERROR_MESSAGE);

            }



            hrs = (String) et_1.getSelectedItem();
            mins = (String) et_2.getSelectedItem();
            e_time = LocalTime.parse(hrs + ":" + mins + ":00");

            try {
                e_time = LocalTime.parse(hrs + ":" + mins + ":00");

            } catch (DateTimeException ex) {
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT TIME", "title", JOptionPane.ERROR_MESSAGE);

            }
            cost = cost_l.getText();
            notes = b_note.getText();


            for (Consultation consultation : consultation_a) {
                //System.out.println(patient);
                System.out.println(consultation.getDate());
                System.out.println(consultation.getS_time());
                System.out.println(consultation.getE_time());
                System.out.println(consultation.getCost());
                System.out.println(consultation.getNotes());
            }

            String doc_id = (String) comboBox_doc.getSelectedItem();


            name = b_name.getText();
            surname = b_surname.getText();
            if(!name.matches("[A-Za-z]*") || !surname.matches("[A-Za-z]*")) {
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT VALUE", "title", JOptionPane.ERROR_MESSAGE);

            }


            try {
                d_o_b = LocalDate.parse(b_d_o_b.getText());
            } catch (DateTimeException ex) {
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT DATE", "title", JOptionPane.ERROR_MESSAGE);

            }

            if(d_o_b.isAfter(LocalDate.parse("2023-01-10"))){
                JOptionPane.showMessageDialog(null, "FUTURE DATE IS NOT ACCEPTED", "title", JOptionPane.ERROR_MESSAGE);
            }

            id = b_id.getText();
            mobile_no = b_mobile_no.getText();
            if(!mobile_no.matches("[0-9]*") || !id.matches("[0-9]*")){
                JOptionPane.showMessageDialog(null, "PLS ENTER THE CORRECT VALUE", "title", JOptionPane.ERROR_MESSAGE);

            }








            patient_a.add(new Patient(name, surname, d_o_b, mobile_no, id));

            for (Patient patient : patient_a) {
                //System.out.println(patient);
                System.out.println(patient.getName());
                System.out.println(patient.getSurname());
                System.out.println(patient.getDate_of_birth());
                System.out.println(patient.getMobile_no());
                System.out.println(patient.getId());
            }

            WestminsterSkinConsultationManager.doctor_a.add(new Doctor(name, surname, d_o_b, mobile_num, license_Number, special));
            for (Doctor doc : WestminsterSkinConsultationManager.doctor_a){
                System.out.println(doc.getName());
                System.out.println(doc.getSurname());
                System.out.println(doc.getDate_of_birth());
                System.out.println(doc.getMobile_no());
                System.out.println(doc.getLicence_no());
                System.out.println(doc.getSpecialisation());

            }System.out.println(String.valueOf(doc_id));

            consultation_a.add(new Consultation(name, surname, d_o_b, mobile_no, id,doc_id,date, s_time, e_time, cost, notes));
            System.out.println(consultation_a);

            for (Consultation consultation : consultation_a){
                System.out.println(consultation.getName());
                System.out.println(consultation.getSurname());
                System.out.println(consultation.getDate_of_birth());
                System.out.println(consultation.getMobile_no());
                System.out.println(consultation.getId());
                System.out.println(consultation.getDoctor_id());
                System.out.println(consultation.getDate());
                System.out.println(consultation.getS_time());
                System.out.println(consultation.getE_time());
                System.out.println(consultation.getCost());
                System.out.println(consultation.getNotes());





            }

            try {
                // Creates a BufferedWriter
                BufferedWriter output = new BufferedWriter(new FileWriter("details_temp.txt"));

                // Writes data to the file
                for (int i = 0; i < consultation_a.size(); i++) {
                    output.write(consultation_a.get(i).getName().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getSurname().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getDate_of_birth().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getMobile_no().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getId().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getDoctor_id().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getDate().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getS_time().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getE_time().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getCost().toString());
                    output.write("\n");
                    output.write(consultation_a.get(i).getNotes().toString());
                    output.write("\n");


                }
                output.close();

                System.out.println("Data is flushed to the file.");

            } catch (Exception ignored) {

            }

            //Save the data into a text file





        }



        if (e.getSource() == view_cons){
            new gui_view_consultation();
            frame.dispose();
        }




            /*File doctors_list_r = new File(" details.txt");
            Scanner myReader = new Scanner(doctors_list_r);
            while (myReader.hasNext()) {
                String name = myReader.next();
                String surname = myReader.next();
                LocalDate d_o_b = LocalDate.parse(myReader.next());
                String mobile_num = myReader.next();
                String license_Number = myReader.next();
                String special = myReader.next();

                doctor_a.add(new Doctor(name, surname, d_o_b, mobile_num, license_Number, special));

            }frame.dispose();

            myReader.close();
        */


        }
























}

