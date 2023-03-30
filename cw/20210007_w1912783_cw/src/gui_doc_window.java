import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class gui_doc_window extends WestminsterSkinConsultationManager implements ActionListener{
    public JButton sort_button,reset_button,back_button;
    public DefaultTableModel model;

    public JTable table;

    public JScrollPane sp;
    public JFrame frame;

    public JLabel label;


    public String []col = {"NAME", "SURNAME", "DATE OF BIRTH", "MOBILE NUMBER", "LICENSE NUMBER", "SPECIALISATION"};
    gui_doc_window() throws IOException {
        WestminsterSkinConsultationManager gui = new WestminsterSkinConsultationManager();


        //To Create the table
        model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        table.setBounds(35,100,800,300);
        table.setModel(model);
        for (Doctor doctor : doctor_a){
            String[] details = {doctor.getName(), doctor.getSurname(), String.valueOf(doctor.getDate_of_birth()), doctor.getMobile_no(), doctor.getLicence_no(), doctor.getSpecialisation()};
            model.addRow(details);

        }





        //To create the Topic name by using the JLabel Class
        label = new JLabel();
        label.setText("ALL OF DOCTOR'S DETAILS");
        label.setBounds(500, -85, 250, 250);

        label.setFont(new Font("Arial Font", Font.BOLD,16));


        //To create a sort_button
        //Sort l_o_doc_button
        sort_button = new JButton();
        sort_button.setBounds(1075,450,100,50);
        sort_button.addActionListener((ActionListener) this);
        sort_button.setText("Sort");
        sort_button.setForeground(Color.BLACK);
        sort_button.setFocusable(false);
        sort_button.setHorizontalTextPosition(JButton.CENTER);
        sort_button.setBackground(Color.decode("#90EE90"));

        //Reset l_o_doc_button
        reset_button = new JButton();
        reset_button.setBounds(965,450,100,50);
        reset_button.addActionListener((ActionListener) this);
        reset_button.setText("Reset");
        reset_button.setForeground(Color.BLACK);
        reset_button.setFocusable(false);
        reset_button.setHorizontalTextPosition(JButton.CENTER);
        reset_button.setBackground(Color.decode("#90EE90"));

        //Back l_o_doc_button
        back_button = new JButton();
        back_button.setBounds(15,450,100,50);
        back_button.addActionListener((ActionListener) this);
        back_button.setText("Back");
        back_button.setForeground(Color.BLACK);
        back_button.setFocusable(false);
        back_button.setHorizontalTextPosition(JButton.CENTER);
        back_button.setBackground(Color.decode("#90EE90"));




        //To create ScrollPane

        sp=new JScrollPane(table);
        table.setGridColor(Color.black);


        //To create a Frame
        frame = new JFrame("MyTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setBounds(60,80,1050,333);
        frame.add(label);
        frame.add(sp);
        frame.add(reset_button);
        frame.add(sort_button);
        frame.add(back_button);
        frame.setLayout(null);
        frame.setSize(1200,700);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.decode("#04cc82"));




    }

    //sort l_o_doc_button to sort the table
    public void sort_button(JTable table){
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(doctor_a.size());

        int columnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort() ;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sort_button){
           sort_button(table);

        }

        if(e.getSource() == reset_button){
            try {
                new gui_doc_window();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();

        }

        if(e.getSource() == back_button){
            new gui_menu();
            frame.dispose();
        }
    }
}
