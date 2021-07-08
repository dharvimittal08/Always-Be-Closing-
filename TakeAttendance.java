import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendance extends JFrame implements ActionListener{
    JLabel ln1,ln2,ln3,ln4,ln5,ln6,ln7;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    JButton bn1,bn2;
    Choice ch2,fsh,sfh;
    
    TakeAttendance(){
       
        setLayout(new GridLayout(4,2,50,50));
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
      
        ln1 = new JLabel("  First Half");
        fsh = new Choice();
        fsh.add("Present");
        fsh.add("Absent");
        fsh.add("Leave");
       
        add(ln1);
        add(fsh);
        
        ln2 = new JLabel("  Second Half");
        sfh = new Choice();
        sfh.add("Present");
        sfh.add("Absent");
        sfh.add("Leave");
       
        add(ln2);
        add(sfh);
       
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
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String a = fsh.getSelectedItem();
        String b = sfh.getSelectedItem();
        String d = new java.util.Date().toString(); 
        String id=ch2.getSelectedItem();
        String qr = "insert into attendence values("+ id +",'"+d+"','"+a+"','"+b+"')";
       
        try{
            ConnWithDb c1 = new ConnWithDb();
            c1.s.executeUpdate(qr);
            JOptionPane.showMessageDialog(null,"Attendence confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public static void main(String s[]){
        new TakeAttendance();
    }
}