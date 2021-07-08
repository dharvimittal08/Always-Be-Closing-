import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewEmployee extends JFrame implements ActionListener{
    JLabel ln1,ln2,ln3,ln4,ln5,ln6,ln7;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    JButton bn1,bn2;
    Choice ch1; 
    
    NewEmployee(){
        
        super("New Employee");
        
        setSize(600,650);
        setLocation(600,200);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel pn1= new JPanel();
        pn1.setBackground(Color.WHITE);
      
        pn1.setLayout(new GridLayout(8,2,10,40)); 
        ln1 = new JLabel("Name");
        tt1 = new JTextField(15);
        pn1.add(ln1);
        pn1.add(tt1);
       
        ch1 = new Choice();
        ch1.add("Male");
        ch1.add("Female");
        ch1.add("other");
       
        ln2 = new JLabel("Gender");
        pn1.add(ln2);
        pn1.add(ch1);
        ln3 = new JLabel("Address");
        tt3 = new JTextField(15);
        pn1.add(ln3);
        pn1.add(tt3);
        ln4 = new JLabel("State");
        tt4 = new JTextField(15);
        pn1.add(ln4);
        pn1.add(tt4); 
        ln5 = new JLabel("City");
        tt5 = new JTextField(15);
        pn1.add(ln5);
        pn1.add(tt5);
        ln6 = new JLabel("Email");
        tt6 = new JTextField(15);
        pn1.add(ln6);
        pn1.add(tt6);
        ln7 = new JLabel("Phone");
        tt7= new JTextField(15);
        pn1.add(ln7);
        pn1.add(tt7);
        bn1 =new JButton("Submit");
        bn2 = new JButton("Cancel");
        pn1.add(bn1);
        pn1.add(bn2);
       
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/New_Employee.jpg"))),"West");
        add(pn1,"Center");
       
        bn1.addActionListener(this);
        bn1.setBackground(Color.BLACK);
        bn1.setForeground(Color.WHITE);
        
        bn2.addActionListener(this);
        bn2.setBackground(Color.BLACK);
        bn2.setForeground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String a = tt1.getText();
        String b = ch1.getSelectedItem(); 
        String c = tt3.getText();
        String d = tt4.getText();
        String e = tt5.getText();
        String f = tt6.getText();
        String g = tt7.getText();
        String qr = "insert into employee values(null,'"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')"; 
       
        try{
            ConnWithDb c1 = new ConnWithDb();
            c1.s.executeUpdate(qr);
            JOptionPane.showMessageDialog(null,"Employee Created");
            this.setVisible(false);  
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    public static void main(String s[]){
        new NewEmployee().setVisible(true);
    }
}