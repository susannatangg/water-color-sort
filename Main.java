import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Main extends JPanel implements Runnable{

    private AllLevels allLevels;
    private Level currLevel;
    private int currLevelIndex;
    private Tube currDeselectedTube;
    private Tube currSelectedTube;
    private int currSelectedTubeIndex;
    private int currNumTubes;
    private int millis=3;
    private String currPage;
    private int buttonY;
    private int restartButtonY;

    public void initData(){
        //5, 5, 5m, 7, 7, 7m, 9, 9, 9m, 9, 9, 9m
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
        allLevels = new AllLevels(levels);
        currPage="gamePage";
        buttonY=475;
        restartButtonY=20;
    }
    
    public Main(){
        start();
        initData();
        currLevelIndex=0;
        currLevel=allLevels.getLevels()[currLevelIndex];
        currNumTubes=currLevel.getNumTubes();
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                //coords of click
                int click_x = e.getX();
                int click_y = e.getY();
                if(currPage.equals("gamePage")){
                    currLevel=allLevels.getLevels()[currLevelIndex];
                    currNumTubes=currLevel.getNumTubes();
                    for (int i=0; i<currNumTubes; i++){
                        Tube currTube=currLevel.getTubes()[i];
                        if(click_x>=currTube.getTubeX() && click_x<=currTube.getTubeX()+50 && click_y>=currTube.getTubeY() && click_y<=currTube.getTubeY()+180){
                            if(currLevel.getTubes()[i].getIsSelected()){ //this tube is already selected, so we deselect
                                currLevel.getTubes()[i].deselect();
                                currSelectedTube=null;
                                currDeselectedTube=currLevel.getTubes()[i];
                            }else if(currSelectedTube==null){ //nothing is selected, so we select this tube
                                if(!currLevel.getTubes()[i].isComplete() && !currLevel.getTubes()[i].isEmpty()){
                                    currLevel.getTubes()[i].select();
                                    currSelectedTube=currLevel.getTubes()[i];
                                    currSelectedTubeIndex=i;
                                }
                            }else{ //another tube is already selected, want to pour into this tube
                                if ((currSelectedTube.topColor().equals(currLevel.getTubes()[i].topColor()) || currLevel.getTubes()[i].topColor()==(null)) 
                                    && !currLevel.getTubes()[i].isFull())
                                {
                                    //pourTube(currSelectedTube,currLevel.getTubes()[i]);
                                    currSelectedTube.pourTo(currLevel.getTubes()[i]);
                                    currSelectedTube=null;
                                    currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                    currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                                }else{
                                    currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                    currDeselectedTube=currSelectedTube;
                                    currSelectedTube=null;
                                }
                                if(currLevel.getTubes()[i].isComplete()){
                                    currLevel.incrementNumCompleteTubes();
                                }
                            }
                        }
                    }
                }
                finishedLevel();
                repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e){
                super.mousePressed(e);
                int press_x=e.getX();
                int press_y=e.getY();
                if(currPage.equals("finishedPage") && press_x>=100 && press_x<=300 && press_y>=475 && press_y<=545){
                    buttonY+=3;
                    repaint();
                }
                if(currPage.equals("gamePage") && press_x>=20 && press_x<=100 && press_y>=20 && press_y<=60){
                    restartButtonY+=3;
                    initData();
                    currLevel=allLevels.getLevels()[currLevelIndex];
                    currNumTubes=currLevel.getNumTubes();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e){
                super.mouseReleased(e);
                int release_x=e.getX();
                int release_y=e.getY();
                if(currPage.equals("finishedPage")){
                    if(release_x>=100 && release_x<=300 && release_y>=475 && release_y<=545){
                        buttonY-=3;
                        currLevelIndex++;
                        currSelectedTube=null;
                        currPage="gamePage";
                    }
                    repaint();
                }
                if(currPage.equals("gamePage") && release_x>=20 && release_x<=100 && release_y>=20 && release_y<=60){
                    restartButtonY-=3;
                    currSelectedTube=null;
                    repaint();
                }
            }
        });
    }

    public void run(){
        try{
            while(true){
                raiseTube();
                unraiseTube();
                try{
                    Thread.sleep(millis);
                }catch(InterruptedException e){}
            }
        }catch (Exception e){}
    }

    public void start(){
        new Thread(this).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        allLevels.getLevels()[currLevelIndex].drawTubes(g);
        drawRestartButton(g);
        drawLevelNum(g);
        if(currPage.equals("finishedPage")){
            drawFinishedPage(g);
        }
    }

    public void drawLevelNum(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        if(currLevelIndex>=9){
            g.drawString("LEVEL "+(currLevelIndex+1), 130, 138);
        }else{
            g.drawString("LEVEL "+(currLevelIndex+1), 138, 138);
        }
    }

    public void drawRestartButton(Graphics g){
        Color darkOrange = new Color(176, 91, 0);
        g.setColor(darkOrange);
        g.fillRoundRect(20,25,70, 35,10,10);  
        g.setColor(Color.ORANGE);
        g.fillRoundRect(20,restartButtonY,70,35,10,10); 
        Image restart = Toolkit.getDefaultToolkit().getImage("restart.png");
        //Image newImage = restart.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //Graphics2D g2d = newImage.createGraphics();
        g.drawImage(restart,41,restartButtonY+4,25,25,this);
    }

    public void finishedLevel(){
        if(allLevels.getLevels()[currLevelIndex].isComplete()){
            currPage="finishedPage";
        }
    }

    public void drawFinishedPage(Graphics g){
        //makes background transparent
        g.setColor(new Color(0,0,0,180));
        g.fillRect(0,0,400,700);

        //congrats banner
        g.setColor(new Color(207, 101, 93));
        g.fillRect(0,105,400,100);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.drawString("CONGRATULATIONS", 43, 167);

        //next button
        Color darkOrange = new Color(176, 91, 0);
        g.setColor(darkOrange);
        g.fillRoundRect(100,482,200,70,25,25);  
        g.setColor(Color.ORANGE);
        g.fillRoundRect(100,buttonY,200,70,25,25);  
        
        //outline 
        //g.setColor(Color.BLACK);
        //g.drawRoundRect(100,475,200,70,25,25);
        // Graphics2D g2 = (Graphics2D) g;
        // Color darkOrange = new Color(255, 102, 0);
        // g2.setColor(darkOrange);
        // g2.setStroke(new BasicStroke(3));
        // g2.drawRoundRect(100,475,200,70,10,10);
        // g2.draw(new Line2D.Float(100,475,300,475));
        // g2.draw(new Line2D.Float(100,545,300,545));
        // g2.draw(new Line2D.Float(100,475,100,545));
        // g2.draw(new Line2D.Float(300,475,300,545));
        
        //text
        g.setColor(new Color(66, 38, 6));
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        g.drawString("NEXT", 147, buttonY+50 );
    }

    public void raiseTube(){
        millis=3;
        if(currSelectedTube!=null && currSelectedTube.getY()!=currSelectedTube.getOriginalY()-25){
            currSelectedTube.setY(currSelectedTube.getY()-1);
        }
        repaint();
    }

    public void unraiseTube(){
        millis=3;
        if(currDeselectedTube!=null && currDeselectedTube.getY()!=currDeselectedTube.getOriginalY()){
            currDeselectedTube.setY(currDeselectedTube.getY()+1);
        }else{
            currDeselectedTube=null;
        }
        repaint();
    }

    public void pourTube(Tube fromTube, Tube toTube){
        millis=3;
        int toX=toTube.getTubeX()-20;
        int toY=toTube.getTubeY()-50;
        int fromX=fromTube.getTubeX();
        int fromY=fromTube.getTubeY();
        int slopeNumerator=toY-fromY;
        int slopeDenominator=toX-fromX;
        if(fromTube.getTubeX()!=toX && fromTube.getTubeY()!=toY){
            fromTube.setTubeX(fromTube.getTubeX()+slopeDenominator);
            fromTube.setTubeY(fromTube.getTubeY()+slopeNumerator);
        }
        repaint();
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
        myFrame.setResizable(false);
    }
}