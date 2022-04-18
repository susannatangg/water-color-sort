import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Main extends JPanel implements Runnable{

    private int y=10;
    
    public Main(){
        start();
        setFocusable(true);
    }

    public void run(){
        try{
            while(true){
                repaint();
                if(y<650){
                    y++;
                }
                try{
                    Thread.sleep(4);
                }catch(InterruptedException e){}
            }
        }catch (Exception e){}
    }

    //don't change this method
    public void start(){
        new Thread(this).start();
    }

    //this method draws everything.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(50,y,50,50);
    }
    
    public static void main(String[]args){
        JFrame myFrame = new JFrame("Water Color Sort");
        Main myPanel=new Main();
        myPanel.setPreferredSize(new Dimension(400, 700));
        myPanel.setBackground(new Color(36,36,36));
        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setResizable(true);
    }
}