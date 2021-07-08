import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener,ItemListener{
    JLabel ln1,ln2,ln3,ln4,ln5,ln6,ln7,emply;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    JButton bn1,bn2;
    Choice ch1,ch2;
    
    UpdateEmployee(){
        
        super("Update Employee");
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ch2 = new Choice();
        ch2.setBounds(160,40,200,20);
       
        try{
            ConnWithDb c = new ConnWithDb();
            ResultSet rs = c.s.executeQuery("select * from employee"); 
      
            while(rs.next()){
                ch2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        emply = new JLabel("Select Empno");
        emply.setBounds(40,40,100,20);
        add(emply);
        add(ch2);
        
        ln1 = new JLabel("Name : ");
        tt1 = new JTextField(15);
        
        ln1.setBounds(40,80,100,20);
        tt1.setBounds(160,80,200,20);
        add(ln1);
        add(tt1);
       
        ch1 = new Choice();
        ch1.add("Male");
        ch1.add("Female");
       
        ln2 = new JLabel("Gender : ");
        
        ln2.setBounds(40,120,100,20);
        ch1.setBounds(160,120,200,20);
        add(ln2);
        add(ch1);
        
        ln3 = new JLabel("Address : ");
        tt3 = new JTextField(15);
        
        ln3.setBounds(40,160,100,20);
        tt3.setBounds(160,160,200,20);
        add(ln3);
        add(tt3);
        
        ln4 = new JLabel("State : ");
        tt4 = new JTextField(15);
        
        ln4.setBounds(40,200,100,20);
        tt4.setBounds(160,200,200,20);
        add(ln4);
        add(tt4); 
        
        ln5 = new JLabel("City : ");
        tt5 = new JTextField(15);
        
        ln5.setBounds(40,240,100,20);
        tt5.setBounds(160,240,200,20);
        add(ln5);
        add(tt5);
        
        ln6 = new JLabel("Email : ");
        tt6 = new JTextField(15);
        
        ln6.setBounds(40,280,100,20);
        tt6.setBounds(160,280,200,20);
        add(ln6);
        add(tt6);
        
        ln7 = new JLabel("Phone : ");
        tt7= new JTextField(15);
        
        ln7.setBounds(40,320,100,20);
        tt7.setBounds(160,320,200,20);
        add(ln7);
        add(tt7);
        
        bn1 =new JButton("Update");
        bn2 = new JButton("Delete");
        
        bn1.setBounds(40,400,150,30);
        bn2.setBounds(200,400,150,30);
        add(bn1);
        add(bn2);
        
        bn1.setBackground(Color.BLACK);
        bn1.setForeground(Color.WHITE);
        
        bn2.setBackground(Color.BLACK);
        bn2.setForeground(Color.WHITE);
        
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        
        ch2.addItemListener(this);
        
        setVisible(true);
        setSize(400,550);
        setLocation(600,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==bn1){
            String a = tt1.getText();
            String b = ch1.getSelectedItem();
            String c = tt3.getText();
            String d = tt4.getText();
            String e = tt5.getText();
            String f = tt6.getText();
            String g = tt7.getText();
            String qr = "update employee set name='"+f+"',gender='"+b+"',address='"+f+"',state='"+d+"',city='"+f+"',email='"+f+"',phone='"+g+"'   where id="+ch2.getSelectedItem();
       
            try{
                ConnWithDb c1 = new ConnWithDb();
                c1.s.executeUpdate(qr);
                JOptionPane.showMessageDialog(null,"Employee Updated");
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==bn2){
            try{
                ConnWithDb c1 = new ConnWithDb();
                c1.s.executeUpdate("delete from employee where id="+ch2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Employee Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            ConnWithDb c1 = new ConnWithDb();
            ResultSet rs = c1.s.executeQuery("select * from employee where id="+ch2.getSelectedItem());
            
            if(rs.next()){
                tt1.setText(rs.getString("name"));
                tt3.setText(rs.getString("address"));
                tt4.setText(rs.getString("state"));
                tt5.setText(rs.getString("city"));
                tt6.setText(rs.getString("email"));
                tt7.setText(rs.getString("phone"));
            }
        }catch(Exception ee){
           ee.printStackTrace();
        }
    
    }
    
    public static void main(String[] args){
        new UpdateEmployee();
    }
    
}