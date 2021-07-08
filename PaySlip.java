import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaySlip extends JFrame implements ActionListener{

    Choice ch1;
    JTextArea tt1;  
    JButton bn1;

    PaySlip(){
        
        setSize(800,700);
        setLocation(400,150);
        ch1 = new Choice();
        try{
            ConnWithDb c = new ConnWithDb();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                ch1.add(rs.getString("id"));
            }
        }catch(Exception e) { }
    
        setLayout(new BorderLayout());
        
        JPanel pn1 = new JPanel();
        pn1.add(new JLabel("Select Id"));
        pn1.add(ch1);
        add(pn1,"North");
        // c1.addItemListener(this);
    
        tt1 = new JTextArea(30,80);
        JScrollPane jsp = new JScrollPane(tt1);
     
        Font ft1 = new Font("arial",Font.BOLD,20);
        tt1.setFont(ft1);
        
        bn1 = new JButton("Generate Pay Slip");
    
        add(bn1,"South");
        add(jsp,"Center");
        bn1.addActionListener(this);
    
    }
   
    public void actionPerformed(ActionEvent e) {
     
        try{
            ConnWithDb c = new ConnWithDb();
         
            ResultSet rs = c.s.executeQuery("select * from employee where id="+ch1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();
         
            rs = c.s.executeQuery("select * from salary where id="+ch1.getSelectedItem());
            double gross=0;
            double net=0;
 
            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            tt1.setText(" ----------------   PAY SLIP FOR THE MONTH OF "+month+" ,2019  ------------------------");
            tt1.append("\n");
            
            if(rs.next()){
          
                tt1.append("\n     Employee ID "+rs.getString("id"));
                tt1.append("\n     Employee Name "+name);
 
                tt1.append("\n----------------------------------------------------------------");
                tt1.append("\n");

                double hra = rs.getDouble("hra");
                tt1.append("\n                  HRA         : "+hra);
                double da  = rs.getDouble("da");
                tt1.append("\n                  DA          : "+da);
                double med  = rs.getDouble("med");
                tt1.append("\n                  MED         : "+med);
                double pf  = rs.getDouble("pf");
                tt1.append("\n                  PF          : "+pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra+da+med+pf+basic;
                net = gross - pf;
                tt1.append("\n                  BASIC SALARY : "+basic);

                tt1.append("\n-------------------------------------------------------");
                tt1.append("\n");
 
                tt1.append("\n       GROSS SALARY :"+gross+"    \n       NET SALARY : "+net);
                tt1.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));   
                tt1.append("\n -------------------------------------------------");
                tt1.append("\n");
                tt1.append("\n");    
                tt1.append("\n");
                tt1.append("   (  Signature  )      ");

            }
        }catch(Exception ee) {
            ee.printStackTrace();
        }
 
   
    }
    public static void main(String[] args){
        new PaySlip().setVisible(true);
    }
}