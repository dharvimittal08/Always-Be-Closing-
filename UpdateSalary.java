import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSalary extends JFrame implements ActionListener,ItemListener{  
    JLabel ln1,ln2,ln3,ln4,ln5,ln6;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6;
    JButton bn1,bn2;
    Choice ch2;
    
    UpdateSalary(){
        
        setLayout(null);  
        ch2 = new Choice();
        try{
            ConnWithDb c = new ConnWithDb();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                ch2.add(rs.getString("id"));    
            }
           
        }catch(Exception e){ }
       
        JLabel empl1 = new JLabel("Select Empno");
        
        empl1.setBounds(20,20,100,20); 
        
        add(empl1);
        
        ch2.setBounds(120,20,200,20);
        add(ch2);
        
        ln1 = new JLabel("Hra");
        tt1 = new JTextField(15);
        
        ln1.setBounds(20,60,100,20);
        tt1.setBounds(120,60,200,20);
        add(ln1);
        add(tt1);
       
        ln2 = new JLabel("Da");
        tt2 = new JTextField(15);
        
        ln2.setBounds(20,100,100,20);
        tt2.setBounds(120,100,200,20);
        add(ln2);
        add(tt2);
       
        ln3 = new JLabel("Med");
        tt3 = new JTextField(15);
        
        ln3.setBounds(20,140,100,20);
        tt3.setBounds(120,140,200,20);
        add(ln3);
        add(tt3);
       
        ln4 = new JLabel("Pf");
        tt4 = new JTextField(15);
        
        ln4.setBounds(20,180,100,20);
        tt4.setBounds(120,180,200,20);
        add(ln4);
        add(tt4); 
       
        ln5 = new JLabel("basic_salary");
        tt5 = new JTextField(15);
        
        ln5.setBounds(20,220,100,20);
        tt5.setBounds(120,220,200,20);
        add(ln5);
        add(tt5);
       
        bn1 =new JButton("Update");
        bn1.setBackground(Color.BLACK);
        bn1.setForeground(Color.WHITE);
        
        bn2 = new JButton("Delete");
        bn2.setBackground(Color.BLACK);
        bn2.setForeground(Color.WHITE);
        
        bn1.setBounds(40,280,100,20);
        bn2.setBounds(200,280,100,20);
        add(bn1);
        add(bn2);
       
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        ch2.addItemListener(this);
        
        getContentPane().setBackground(Color.WHITE);
       
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
    }
    
    public void actionPerformed(ActionEvent ae){  
        
        if(ae.getSource()==bn1){ 
            String hra = tt1.getText();
            String id = ch2.getSelectedItem();
            String da = tt2.getText();
            String med = tt3.getText();
            String pf = tt4.getText();
            String basic = tt5.getText();
      
            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+ch2.getSelectedItem();
       
            try{
                ConnWithDb c1 = new ConnWithDb();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==bn2){  
            
            try{
                ConnWithDb c1 = new ConnWithDb();
                c1.s.executeUpdate("delete from salary where id="+ch2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie)  
    {
        try{
           ConnWithDb c1 = new ConnWithDb();
            ResultSet rs = c1.s.executeQuery("select * from salary where id="+ch2.getSelectedItem()); 
            if(rs.next()){
                tt1.setText(rs.getString("hra"));  
                tt2.setText(rs.getString("da"));
                tt3.setText(rs.getString("med"));
                tt4.setText(rs.getString("pf"));
                tt5.setText(rs.getString("basic_salary"));
         
            }
       }catch(Exception ee){
           ee.printStackTrace();
       }
        
        
    }
    
    public static void main(String[] args){
        new UpdateSalary();
    }
    
}