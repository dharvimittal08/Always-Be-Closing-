import java.awt.*;
import javax.swing.*;

class Splash{
    public static void main(String s[]){
        
        sframe fr1 = new sframe("Always Be Closing (ABC)"); 
        fr1.setVisible(true); 
        int i;
        int n=1;
        for(i=2;i<=600;i+=4,n+=1){
            
            fr1.setLocation((800-((i+n)/2) ),500-(i/2));
            fr1.setSize(i+n,i);
            
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
}

class sframe extends JFrame implements Runnable{
    Thread tt1; 
    sframe(String s1){
        super(s1); 
        setLayout(new FlowLayout()); 
       
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/Splash_2.jpeg"));
       
        Image i1 = c1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel m1 = new JLabel(i2);
        add(m1);
        tt1= new Thread(this);
        tt1.start(); 
    }
    public void run(){
        try{
            Thread.sleep(7000); 
            this.setVisible(false); 
            UserLogin fn1 = new UserLogin();
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}