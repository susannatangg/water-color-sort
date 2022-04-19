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
        // g.setColor(Color.CYAN);
        // g.fillRect(75,135,50,180);
        // g.fillRect(175,135,50,180);
        // g.fillRect(275,135,50,180);
        // g.fillRect(125,370,50,180);
        // g.fillRect(225,370,50,180);
        // g.setColor(Color.BLUE);
        // g.fillRect(225,390,50,40);
        // g.setColor(Color.RED);
        // g.fillRect(225,430,50,40);
        // g.setColor(Color.BLUE);
        // g.fillRect(225,470,50,40);
        // g.setColor(Color.RED);
        // g.fillRect(225,510,50,40);

        // g.setColor(Color.WHITE);
        //g.setColor(Color.RED);
        //Graphics2D g2d = (Graphics2D) g.create();
        //TubeShape ts = new TubeShape(225,510,40,25);
        //g2d.setStroke(new BasicStroke(3));
        //g2d.fill(ts);
        // g2d.dispose();
        // Color[] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN};
        // Tube t = new Tube(colors, false);

        // t.drawColor(g,Color.RED,1,225,510);
        // t.drawColor(g,Color.PINK,2,225,470);
        // t.drawColor(g,Color.CYAN,3,225,430);
        // t.drawColor(g,Color.YELLOW,4,225,390);
        // t.drawTube(g,225,370);
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