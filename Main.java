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

    //5, 5, 5m, 7, 7, 7m, 9, 9, 9m, 9, 9, 9m
    public void play(Graphics g){
        Level[] levels = {
            MakeLevel.level1(), 
            MakeLevel.level2(),
            MakeLevel.level3(),
            MakeLevel.level4(),
            MakeLevel.level5(),
            MakeLevel.level6(),
            MakeLevel.level7(),
            MakeLevel.level8(),
            MakeLevel.level9(),
            MakeLevel.level10(),
            MakeLevel.level11(),
            MakeLevel.level12()};
        AllLevels allLevels = new AllLevels(levels);
        allLevels.getLevels()[10].drawTubes(g);
    }

    //this method draws everything.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // Color[] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN};
        // Tube t = new Tube(colors, false);
        // Tube[] tubes = {t,t,t,t,t,t,t,t,t};
        // Level l = new Level(tubes,4,false);
        // l.drawTubes(g);
        play(g);
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