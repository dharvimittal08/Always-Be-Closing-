import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListAttendance extends JFrame implements ActionListener{
  
    JTable jc1;
    JButton bn1;
    String h1[]={"Emp id","Date Time","First Half","Second Half"};
    String d2[][]=new String[15][4];  
    int i=0,j=0;
    
    ListAttendance(){
        super("View Employees Attendence");
        setSize(800,300);
        setLocation(450,150);

        try{
            String q="select * from attendence";
            ConnWithDb c1=new ConnWithDb();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d2[i][j++]=rs.getString("id");
                d2[i][j++]=rs.getString("date_tm");
                d2[i][j++]=rs.getString("f_half");
                d2[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }
        
            jc1=new JTable(d2,h1);

        }catch(Exception e){}
        
        bn1=new JButton("Print");
        add(bn1,"South");
        JScrollPane s=new JScrollPane(jc1);
        add(s);
        
        bn1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            jc1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new ListAttendance().setVisible(true);
    }
}