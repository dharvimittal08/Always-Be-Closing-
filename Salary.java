import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener{
    JLabel ln1,ln2,ln3,ln4,ln5,ln6,ln7;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    JButton bn1,bn2;
    Choice ch2;
    
    Salary(){
        
        super("Set Salary");
       
        setLayout(new GridLayout(8,2,20,20));
        ch2 = new Choice();
       
        try{
           ConnWithDb c = new ConnWithDb();
            ResultSet rs = c.s.executeQuery("select * from employee");
      
            while(rs.next()){
                ch2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        add(new JLabel("  Select Empno"));
        add(ch2);
        
        ln1 = new JLabel("  HRA");
        tt1 = new JTextField(15);
        add(ln1);
        add(tt1);
       
        ln3 = new JLabel("  DA");
        tt3 = new JTextField(15);
        add(ln3);
        add(tt3);
        
        ln4 = new JLabel("  MED");
        tt4 = new JTextField(15);
        add(ln4);
        add(tt4); 
       
        ln5 = new JLabel("  PF");
        tt5 = new JTextField(15);
        add(ln5);
        add(tt5);
        
        ln6 = new JLabel("  Basic Salary");
        tt6 = new JTextField(15);
        add(ln6);
        add(tt6);
       
        bn1 =new JButton("Submit");
        bn1.setBackground(Color.BLACK);
        bn1.setForeground(Color.WHITE);
        
        bn2 = new JButton("Cancel");
        bn2.setBackground(Color.BLACK);
        bn2.setForeground(Color.WHITE);
        
        add(bn1);
        add(bn2);
       
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        
        
        setSize(450,550);
        setLocation(500,200);
        setVisible(true);
       
        
        getContentPane().setBackground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String hra = tt1.getText();
        String id = ch2.getSelectedItem();
        String da = tt3.getText();
        String med = tt4.getText();
        String pf = tt5.getText();
        String basic = tt6.getText();
        String qr = "insert into salary values("+ id +","+hra+","+da+","+med+","+pf+","+basic+")";
       
        try{
            ConnWithDb c1 = new ConnWithDb();
            c1.s.executeUpdate(qr);
            JOptionPane.showMessageDialog(null,"Salary updated");
            this.setVisible(false);
        }catch(Exception e){   
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Salary();
    }
}