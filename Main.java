import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
// DONE WITH JAVADOCS
/**
 * This is the Main class that we run. 
 * It contains all the graphic and animation elements. 
 * It also contains the game algorithm and runs the game.
 */
public class Main extends JPanel implements Runnable{

    private AllLevels allLevels;
    private Level currLevel;
    private int currLevelIndex=0;
    private Tube currDeselectedTube;
    private Tube currSelectedTube;
    private int currSelectedTubeIndex;
    private int currNumTubes;
    private int millis=3;
    private String currPage;
    private int buttonY;
    private int restartButtonY;
    private int fromTubeIndex;
    private int toTubeIndex;
    private double dy;
    private double dx;
    private double hypotenuse;
    private double toX,toY;
    private double currX,currY;
    private int step = 0;
    private int currI=-1;

    /**
     * make 12 individual levels and set currentpage to gamepage
     * generates restartbutton
     */
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
    
    /**
     * deals with loading the tube layout for the specific level 
     * in the array 
     * pouring animation, after level is done loads finishedpage
     */
    public Main(){
        initData();
        start();
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
                if(currPage.equals("gamePage") && step==0){
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
                                    fromTubeIndex=currSelectedTubeIndex;
                                    toTubeIndex=i;
                                    toX=currLevel.getTubes()[i].getTubeX()-70;
                                    toY=currLevel.getTubes()[i].getTubeY()-50;
                                    double fromX=currSelectedTube.getTubeX();
                                    double fromY=currSelectedTube.getTubeY();
                                    dy=toY-fromY;
                                    dx=toX-fromX;
                                    currX=fromX;
                                    currY=fromY;
                                    hypotenuse=Math.sqrt((dy*dy)+(dx*dx));
                                    currI=i;
                                    step++;
                                    pourTube();
                                }else{
                                    currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                    currDeselectedTube=currSelectedTube;
                                    currSelectedTube=null;
                                }
                            }
                        }
                    }
                }
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

    /**
     * runs the game
     * includes animations of raising, unraising, pouring
     */
    public void run(){
        try{
            while(true){
                raiseTube();
                unraiseTube();
                pourTube();
                try{
                    Thread.sleep(millis);
                }catch(InterruptedException e){}
            }
        }catch (Exception e){}
    }

    /**
     * starts the game
     */
    public void start(){
        new Thread(this).start();
    }

    /**
     * GUI component, draws finishedpage,
     * restartbutton, level number
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        allLevels.getLevels()[currLevelIndex].drawTubes(g);
        drawRestartButton(g);
        drawLevelNum(g);
        if(currPage.equals("finishedPage")){
            drawFinishedPage(g);
        }
    }

    /**
     * draws the graphic to show level number
     * @param g graphics
     */
    public void drawLevelNum(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        if(currLevelIndex>=9){
            g.drawString("LEVEL "+(currLevelIndex+1), 130, 138);
        }else{
            g.drawString("LEVEL "+(currLevelIndex+1), 138, 138);
        }
    }

    /**
     * draws the restart button
     * @param g graphics
     */
    public void drawRestartButton(Graphics g){
        Color darkOrange = new Color(176, 91, 0);
        g.setColor(darkOrange);
        g.fillRoundRect(20,25,70, 35,10,10);  
        g.setColor(Color.ORANGE);
        g.fillRoundRect(20,restartButtonY,70,35,10,10); 
        Image restart = Toolkit.getDefaultToolkit().getImage("restart.png");
        g.drawImage(restart,41,restartButtonY+4,25,25,this);
    }

    /**
     * finishedpage is currentpage after level is complete
     */
    public void finishedLevel(){
        if(allLevels.getLevels()[currLevelIndex].isComplete() && step==0){
            currPage="finishedPage";
        }
    }

    /**
     * draw finished page with 
     * congratulations banner and next button
     * @param g graphics
     */
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
        //text
        g.setColor(new Color(66, 38, 6));
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        g.drawString("NEXT", 147, buttonY+50 );
    }

    /**
     * animation for raising the tube when selected
     */
    public void raiseTube(){
        millis=3;
        if(currSelectedTube!=null && currSelectedTube.getTubeY()!=currSelectedTube.getOriginalY()-25 && step==0){
            currSelectedTube.setTubeY(currSelectedTube.getTubeY()-1);
        }
        repaint();
    }
    /**
     * animation for unraising the tube when deselected
     */
    public void unraiseTube(){
        millis=3;
        if(currDeselectedTube!=null && currDeselectedTube.getTubeY()!=currDeselectedTube.getOriginalY()){
            currDeselectedTube.setTubeY(currDeselectedTube.getTubeY()+1);
        }else{
            currDeselectedTube=null;
        }
        repaint();
    }

    /**
     * pouring tube animation 
     * step 0 = don't move
     * step 1 = move to the position of other tube
     * step 2 = move tube back
     */
    public void pourTube(){
        millis=2;
        if(step==1 && (int)currY!=toY){
            double incrementX=dx/hypotenuse;
            double incrementY=dy/hypotenuse;
            currX+=incrementX;
            currY+=incrementY;
            currLevel.getTubes()[fromTubeIndex].setTubeX(currX);
            currLevel.getTubes()[fromTubeIndex].setTubeY(currY);
            repaint();
        }
        else if(step==1 && (int)currY==toY){
            step=2;
        }

        if(step==2 && currI!=-1){
            currLevel.getTubes()[currSelectedTubeIndex].pourTo(currLevel.getTubes()[currI]);
            step=3;
        }
        
        if(currSelectedTube!=null){
            double origX=currLevel.getTubes()[fromTubeIndex].originalLoc.getX();
            double origY=currLevel.getTubes()[fromTubeIndex].originalLoc.getY();
            if(step==3 && (int)currY!=(int)origY){
                dy=currY-origY;
                dx=currX-origX;
                hypotenuse=Math.sqrt((dy*dy)+(dx*dx));
                double incrementX=dx/hypotenuse;
                double incrementY=dy/hypotenuse;
                currX-=incrementX;
                currY-=incrementY;
                currLevel.getTubes()[fromTubeIndex].setTubeX(currX);
                currLevel.getTubes()[fromTubeIndex].setTubeY(currY);
                repaint();
            }else if(step==3 && (int)currY==origY){
                step=0;
                currSelectedTube=null;
                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                if(currLevel.getTubes()[currI].isComplete()){
                    currLevel.incrementNumCompleteTubes();
                }
                finishedLevel();
                repaint();
            }
        }
    }

    /**
     * generates window for the game each time we run
     * @param args
     */
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