import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.sql.*; 

public class UserLogin extends JFrame implements ActionListener{  
    JLabel ln1,ln2;  
    JTextField tt1;  
    JPasswordField tt2;  
    JButton bn1,bn2; 
    
    UserLogin(){
        super("Login Page");  
        setLayout(new BorderLayout()); 
        tt2 = new JPasswordField(10); 
        tt1 = new JTextField(10);
        JLabel la = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\Picture4.png")));   
        
        bn1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        bn2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\cancel.png")));
        
        bn1.addActionListener(this);  
        bn2.addActionListener(this);

        JPanel pn1,pn2,pn3,pn4;
        pn1=new JPanel();
        pn2=new JPanel();
        pn3=new JPanel();
        pn4=new JPanel();       
        
        add(la,BorderLayout.WEST);  

        pn2.add(new JLabel("User Name  "));
        pn2.add(tt1);
        pn2.add(new JLabel("Password  "));
        pn2.add(tt2);
        add(pn2,BorderLayout.CENTER); 

        pn4.add(bn1);
        pn4.add(bn2);

        add(pn4,BorderLayout.SOUTH);  

      
        setSize(400,250);  
        setLocation(600,400); 
        setVisible(true); 

    }
    public void actionPerformed(ActionEvent ae){ 
        try
        {
            ConnWithDb c1=new ConnWithDb();
            String x=tt1.getText(); 
            String y=tt2.getText();
            
            String qr="select * from login where username='"+x+"' and password='"+y+"'";  
            
            ResultSet rs=c1.s.executeQuery(qr); 
            if(rs.next()){
                new MainScreen().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Login");  
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new UserLogin();
    }
}