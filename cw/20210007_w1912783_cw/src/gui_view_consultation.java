import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class gui_view_consultation extends JFrame implements ActionListener {
    private DefaultTableModel model;

    private JTable table;

    private JScrollPane sp;
    private final JButton button;

    private final JLabel view;
    String name;
    String surname;
    String d_o_b;
    String mobile_no;
    String id;



    public String []col = {"NAME", "SURNAME", "DATE OF BIRTH", "MOBILE NUMBER","PATIENT ID","DOCTOR ID","CONSULTATION DATE","START TIME","END TIME","COST"};



    gui_view_consultation(){



        //To create the topic
        view = new JLabel();
        view.setText("View Consultation Details");
        view.setBounds(470, -85, 500, 200);
        view.setFont(new Font("Arial Font", Font.BOLD,30));

        model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        table.setBounds(35, 100, 800, 250);
        table.setModel(model);



        ArrayList<String> temp_a = new ArrayList<>();
        try {
            String temp;

            BufferedReader readFile =new BufferedReader(new FileReader("details_temp.txt"));

            while (((temp= readFile.readLine()) != null)){
                temp_a.add(temp);

            }


            while ( 0 < (temp_a.size()/ gui_check_cons_window.consultation_a.size())) {

                gui_check_cons_window.consultation_a.add(new Consultation(temp_a.get(0),temp_a.get(1), LocalDate.parse(temp_a.get(2)),temp_a.get(3),temp_a.get(4),temp_a.get(5),LocalDate.parse(temp_a.get(6)), LocalTime.parse(temp_a.get(7)),LocalTime.parse(temp_a.get(8)),temp_a.get(9),temp_a.get(10)));
                temp_a.subList(0, gui_check_cons_window.consultation_a.size()).clear();
                System.out.println(gui_check_cons_window.consultation_a);

            }

            readFile.close();
        }


        catch (Exception ignored) {

        }

        for (Consultation consultation : gui_check_cons_window.consultation_a) {
        String[] details = {consultation.getName(),consultation.getSurname(), String.valueOf(consultation.getDate_of_birth()),consultation.getMobile_no(),consultation.getId(),consultation.getDoctor_id(), String.valueOf(consultation.getDate()), String.valueOf(consultation.getS_time()), String.valueOf(consultation.getE_time()),consultation.getCost()};
        model.addRow(details);


        }


        //To create ScrollPane
        sp = new JScrollPane(table);
        sp.setBounds(60, 80, 1150, 333);

        table.setGridColor(Color.black);




        //To create a button
        //add consultation
        button = new JButton();
        button.setBounds(60,580,200,50);
        button.addActionListener((ActionListener) this);
        button.setText("Add Consultation");
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setBackground(Color.decode("#90EE90"));


        //To create the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200,820);
        this.getContentPane().setBackground(Color.decode("#04cc82"));
        this.setVisible(true);
        this.add(view);
        this.add(button);
        this.add(sp);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){

           // gui_check_cons_window.consultation_a.add(new Consultation(check.date,check.s_time,check.e_time,check.cost,check.notes);
            //gui_check_cons_window.consultation_a.add(new Consultation( check.date, check.s_time,check.e_time,check.cost,check.notes));
            this.dispose();




            /*for (Consultation consultation : gui_check_cons_window.consultation_a) {
                //System.out.println(patient);
                System.out.println(consultation.getDate());
                System.out.println(consultation.getS_time());
                System.out.println(consultation.getE_time());
                System.out.println(consultation.getCost());
                System.out.println(consultation.getNotes());


            }*/



        }



    }
}
