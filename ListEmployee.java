import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListEmployee extends JFrame implements ActionListener{
  
    JTable jc1;
    JButton bn1;
    String h1[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};  // 1-D array
    String d2[][]=new String[20][8];  // 2-D array where 20 is no of rows and 8 no of columns
    int i=0,j=0;
    
    ListEmployee(){
        super("View Employees");
        
        setSize(1000,400);
        setLocation(450,200);

        try{
            String qr="select * from employee";
            ConnWithDb c1=new ConnWithDb();
            ResultSet rs=c1.s.executeQuery(qr);  // rs.next moves from column to column
            while(rs.next()){
                // i = 0 j = 0
                d2[i][j++]=rs.getString("id"); // getstring is used when we have to pick a selected item from column
                d2[i][j++]=rs.getString("name");
                d2[i][j++]=rs.getString("gender");
                d2[i][j++]=rs.getString("address");
                d2[i][j++]=rs.getString("state");
                d2[i][j++]=rs.getString("city");
                d2[i][j++]=rs.getString("email");
                d2[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            jc1=new JTable(d2,h1);  // first 2-D array then 1-D array otherwise it will throw error

        }
        catch(Exception e){}
        
        bn1=new JButton("Print");
        add(bn1,"South");
        JScrollPane s1=new JScrollPane(jc1);  // for scroll bar
        add(s1);
        
        bn1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           jc1.print();  // for printing
        }catch(Exception e){}
    }
     
    public static void main(String s[]){
        new ListEmployee().setVisible(true);
    }
}