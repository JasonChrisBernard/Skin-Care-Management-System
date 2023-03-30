import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class gui_menu extends JFrame implements ActionListener {
    JButton l_o_doc_button, add_consultation_button,view_consultation_button;
    JLabel label;
    WestminsterSkinConsultationManager gui = new WestminsterSkinConsultationManager();
     gui_menu(){
         //Topic
         label = new JLabel();
         label.setText("Main Menu");
         label.setBounds(140, -85, 250, 250);

         label.setFont(new Font("Arial Font", Font.BOLD,35));
         //To create the list of doctors button
         l_o_doc_button = new JButton();
         l_o_doc_button.setBounds(100,130,250,100);
         l_o_doc_button.addActionListener(this);
         l_o_doc_button.setText("List of Doctors");
         l_o_doc_button.setForeground(Color.BLACK);
         l_o_doc_button.setFocusable(false);
         l_o_doc_button.setHorizontalTextPosition(JButton.CENTER);
         l_o_doc_button.setBackground(Color.decode("#90EE90"));

         //To create the add consultation details button
         add_consultation_button = new JButton();
         add_consultation_button.setBounds(100,270,250,100);
         add_consultation_button.addActionListener(this);
         add_consultation_button.setText("Add Consultation");
         add_consultation_button.setForeground(Color.BLACK);
         add_consultation_button.setFocusable(false);
         add_consultation_button.setHorizontalTextPosition(JButton.CENTER);
         add_consultation_button.setBackground(Color.decode("#90EE90"));

         //To create the consultant details button
         view_consultation_button = new JButton();
         view_consultation_button.setBounds(100,410,250,100);
         view_consultation_button.addActionListener(this);
         view_consultation_button.setText("View Consultation");
         view_consultation_button.setForeground(Color.BLACK);
         view_consultation_button.setFocusable(false);
         view_consultation_button.setHorizontalTextPosition(JButton.CENTER);
         view_consultation_button.setBackground(Color.decode("#90EE90"));





         //To create the frame
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLayout(null);
         this.setSize(500,700);
         this.getContentPane().setBackground(Color.decode("#04cc82"));
         this.setVisible(true);
         this.add(label);
         this.add(l_o_doc_button);
         this.add(add_consultation_button);
         this.add(view_consultation_button);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == l_o_doc_button){

             try {
                  new gui_doc_window();
             } catch (IOException ex) {
                 throw new RuntimeException(ex);
             }


         }

         if(e.getSource() == add_consultation_button){
             new gui_check_cons_window();
             this.dispose();

         }

        if(e.getSource() == view_consultation_button){
            new gui_view_consultation();
            this.dispose();

        }


    }
}
