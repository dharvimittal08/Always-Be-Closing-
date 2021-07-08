import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame implements ActionListener {
       
    MainScreen(){
        setSize(2000,1100);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon ig1 = new ImageIcon(ClassLoader.getSystemResource("icon/Picture2.png"));
        Image ig2 = ig1.getImage().getScaledInstance(700,800,Image.SCALE_DEFAULT);
        ImageIcon ig3 = new ImageIcon(ig2);
        JLabel ln1 = new JLabel(ig3);
        add(ln1);
    
        JMenuBar mnb = new JMenuBar();
        setJMenuBar(mnb);
        JMenu mn1 = new JMenu("Master");
        mn1.setForeground(Color.blue);
    
        JMenuItem tt1 = new JMenuItem("New Employee");
    
        tt1.setForeground(Color.blue);
        tt1.setFont(new Font("monospaced",Font.PLAIN,12));
        tt1.setMnemonic('N');
        tt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        tt1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon/users.png")));
        

    
        JMenuItem tt3 = new JMenuItem("Salary");
        tt3.setForeground(Color.blue);
        tt3.setFont(new Font("monospaced",Font.PLAIN,12));
        tt3.setMnemonic('S');
        tt3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        tt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    
    
    
        JMenuItem tt4 = new JMenuItem("List Employee");
      
        tt4.setForeground(Color.blue);
        tt4.setFont(new Font("monospaced",Font.PLAIN,12));
        tt4.setMnemonic('L');
        tt4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedule.png")));
        tt4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    
    
    
    
        mn1.add(tt1);
        //m1.add(t2);
        mn1.add(tt3);
        mn1.add(tt4);
        mnb.add(mn1);
    
        tt1.addActionListener(this);
        //t2.addActionListener(this);
        tt3.addActionListener(this);
        tt4.addActionListener(this);
        
        JMenu edit =new JMenu("Update");
        edit.setForeground(Color.RED);
   
        mnb.add(edit);
        JMenuItem set1 = new JMenuItem("Update Salary");
        set1.setForeground(Color.blue);
        set1.setFont(new Font("monospaced",Font.PLAIN,12));
        set1.setMnemonic('U');
        set1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon/viewschd.png")));
        set1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
    
        edit.add(set1);
    
        JMenuItem set2 = new JMenuItem("Update Employee");
   
        set2.setForeground(Color.blue);
        set2.setFont(new Font("monospaced",Font.PLAIN,12));
        set2.setMnemonic('p');
        set2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/emps.png")));
        set2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
   
        
        edit.add(set2);
        JMenuItem set3 = new JMenuItem("Take Attendence");

        set3.setForeground(Color.blue);
        set3.setFont(new Font("monospaced",Font.PLAIN,12));
        set3.setMnemonic('T');
        set3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/atten.PNG")));
        set3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
   
    
        edit.add(set3);
        
        set1.addActionListener(this);
        set2.addActionListener(this);
        set3.addActionListener(this);
        JMenu rep =new JMenu("Reports");
        rep.setForeground(Color.blue);
    
        mnb.add(rep);
        JMenuItem pn1 = new JMenuItem("Generate PaySlip");
   
    
        pn1.setForeground(Color.blue);
        pn1.setFont(new Font("monospaced",Font.PLAIN,12));
        pn1.setMnemonic('G');
        pn1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.png")));
        pn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

        rep.add(pn1);
        JMenuItem pn2 = new JMenuItem("List Attendence");
   
        pn2.setForeground(Color.blue);
        pn2.setFont(new Font("monospaced",Font.PLAIN,12));
        pn2.setMnemonic('A');
        pn2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schd.png")));
        pn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        rep.add(pn2);
        pn1.addActionListener(this);
        pn2.addActionListener(this);
 
        JMenu util =new JMenu("Utilities");
        util.setForeground(Color.red);
    
        mnb.add(util);
        JMenuItem u1 = new JMenuItem("Notepad");
    
    
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon/notepad.png")));
   
        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setMnemonic('o');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        util.add(u1);
        JMenuItem u2 = new JMenuItem("Calculator");
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
  
        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
 
    
    
    
    
        util.add(u2);
        JMenuItem u3 = new JMenuItem("Web Browser");
        //u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
  
        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        util.add(u3);
   
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        
        JMenu m8_=new JMenu("About Us");
        m8_.setForeground(Color.blue);
        mnb.add(m8_);
        JMenuItem m8i1_=new JMenuItem("About Us");
        m8_.add(m8i1_);
        m8i1_.setForeground((Color.blue));
        m8i1_.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1_.setMnemonic('Y');
        m8i1_.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/help.PNG")));
        m8i1_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        m8i1_.addActionListener(this);

    
    
        JMenu m8=new JMenu("Exit");
        m8.setForeground(Color.red);
        mnb.add(m8);
        JMenuItem m8i1=new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/delete.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
      
        if(msg.equals("New Employee"))
            new NewEmployee().setVisible(true);
        else if(msg.equals("List Employee"))
            new ListEmployee().setVisible(true);
        else if(msg.equals("Update Employee"))
            new UpdateEmployee().setVisible(true);
        else if(msg.equals("Salary"))
            new Salary().setVisible(true);
        else if(msg.equals("Update Salary"))
            new UpdateSalary().setVisible(true);
        else if(msg.equals("About Us"))
            new AboutUs().setVisible(true);
        else if(msg.equals("Notepad")){
            try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Calculator")){
            try{
               Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Web Browser")){
            try{
               Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Take Attendence")){
            new TakeAttendance().setVisible(true);
        }
        else if(msg.equals("Exit"))
            System.exit(0);
        else if(msg.equals("Generate PaySlip"))
            new PaySlip().setVisible(true);
        else if(msg.equals("List Attendence"))
            new ListAttendance().setVisible(true);
        
    }
    
    public static void main(String[] args){
        new MainScreen().setVisible(true);
    }
    
}