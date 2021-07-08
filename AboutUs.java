import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame{

	private JPanel contentPane;

        public static void main(String[] args) {
            new AboutUs().setVisible(true);			
	}
    
        public AboutUs() {
            
            super("Always Be Closing (ABC)");
            setBackground(new Color(173, 216, 230));
            setBounds(500, 250, 700, 500);
		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            


            JLabel ln3 = new JLabel("Always");
            ln3.setForeground(new Color(0, 250, 154));
            ln3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            ln3.setBounds(140, 40, 200, 55);
            contentPane.add(ln3);

            JLabel ln4 = new JLabel("Be Closing");
            ln4.setForeground(new Color(127, 255, 0));
            ln4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            ln4.setBounds(70, 90, 405, 40);
            contentPane.add(ln4);

            JLabel ln5 = new JLabel("(ABC)");
            ln5.setForeground(new Color(30, 144, 255));
            ln5.setFont(new Font("red", Font.BOLD, 25));
            ln5.setBounds(185, 140, 100, 21);
            contentPane.add(ln5);


            JLabel ln6 = new JLabel("Developed By :  Sanjana and Dharvi");
            ln6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            ln6.setBounds(20, 198, 600, 35);
            contentPane.add(ln6);

            JLabel ln7 = new JLabel("Roll Number - E20CSE051 and E20CSE018");
            ln7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            ln7.setBounds(20, 260, 600, 34);
            contentPane.add(ln7);

            JLabel ln8 = new JLabel("Contact : E20CSE051@bennett.edu.in and");
            ln8.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            ln8.setBounds(20, 290, 600, 34);
            contentPane.add(ln8);
            
            JLabel l18 = new JLabel("E20CSE018@bennett.edu.in");
            l18.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l18.setBounds(110, 320, 600, 34);
            contentPane.add(l18);

            JLabel ln9 = new JLabel("Education - B.Tech (Computer Science)");
            ln9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            ln9.setBounds(20, 350, 600, 34);
            contentPane.add(ln9);
            
            
            JLabel l10 = new JLabel("Phone - +91 9999 999999");
            l10.setForeground(new Color(47, 79, 79));
            l10.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
            l10.setBounds(20, 400, 600, 34);
            contentPane.add(l10);
                
                
            contentPane.setBackground(Color.WHITE);
	}
        

}