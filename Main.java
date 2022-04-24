import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Main extends JPanel implements Runnable{

    private AllLevels allLevels;
    Level currLevel;
    Tube currDeselectedTube;
    Tube currSelectedTube;
    int currSelectedTubeIndex;
    private int currNumTubes;
    int millis=3;

    public void initData(){
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
        currNumTubes=9;
        currLevel=allLevels.getLevels()[10];
        currSelectedTube=null;
    }
    
    public Main(){
        start();
        initData();
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                //coords of click
                int click_x = e.getX();
                int click_y = e.getY();

                //5 tubes
                if(currNumTubes==5){
                    //tube 1
                    if (click_x >= 75 && click_x <= 125 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[0].getIsSelected()){ //this tube is already selected, so we deselect
                            currLevel.getTubes()[0].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[0];
                        }else if(currSelectedTube==null){ //nothing is selected, so we select this tube
                            if(!currLevel.getTubes()[0].isComplete() && !currLevel.getTubes()[0].isEmpty()){
                                currLevel.getTubes()[0].select();
                                currSelectedTube=currLevel.getTubes()[0];
                                currSelectedTubeIndex=0;
                            }
                        }else{ //another tube is already selected, want to pour into this tube
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[0].topColor()) || currLevel.getTubes()[0].topColor()==(null)) 
                                && !currLevel.getTubes()[0].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[0]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 2
                    else if (click_x >= 175 && click_x <= 225 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[1].getIsSelected()){
                            currLevel.getTubes()[1].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[1];
                        }else if(currSelectedTube==null){
                            if(!currLevel.getTubes()[1].isComplete() && !currLevel.getTubes()[1].isEmpty()){
                                currLevel.getTubes()[1].select();
                                currSelectedTube=currLevel.getTubes()[1];
                                currSelectedTubeIndex=1;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[1].topColor()) || currLevel.getTubes()[1].topColor()==(null)) 
                                && !currLevel.getTubes()[1].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[1]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 3
                    else if (click_x >= 275 && click_x <= 325 && click_y >= 160 && click_y <= 340)
                    {
                         if(currLevel.getTubes()[2].getIsSelected()){ 
                            currLevel.getTubes()[2].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[2];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[2].isComplete() && !currLevel.getTubes()[2].isEmpty()){
                                currLevel.getTubes()[2].select();
                                currSelectedTube=currLevel.getTubes()[2];
                                currSelectedTubeIndex=2;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[2].topColor()) || currLevel.getTubes()[2].topColor()==(null)) 
                                && !currLevel.getTubes()[2].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[2]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 4, second row
                    else if (click_x >= 125 && click_x <= 175 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[3].getIsSelected()){ 
                            currLevel.getTubes()[3].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[3];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[3].isComplete() && !currLevel.getTubes()[3].isEmpty()){
                                currLevel.getTubes()[3].select();
                                currSelectedTube=currLevel.getTubes()[3];
                                currSelectedTubeIndex=3;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[3].topColor()) || currLevel.getTubes()[3].topColor()==(null)) 
                                && !currLevel.getTubes()[3].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[3]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 5, second row 
                    else if (click_x >= 225 && click_x <= 275 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[4].getIsSelected()){ 
                            currLevel.getTubes()[4].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[4];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[4].isComplete() && !currLevel.getTubes()[4].isEmpty()){
                                currLevel.getTubes()[4].select();
                                currSelectedTube=currLevel.getTubes()[4];
                                currSelectedTubeIndex=4;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[4].topColor()) || currLevel.getTubes()[4].topColor()==(null)) 
                                && !currLevel.getTubes()[4].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[4]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                }

                //7 tubes
                else if (currNumTubes == 7)
                {
                    //tube 1
                    if (click_x >= 50 && click_x <= 100 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[0].getIsSelected()){ 
                            currLevel.getTubes()[0].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[0];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[0].isComplete() && !currLevel.getTubes()[0].isEmpty()){
                                currLevel.getTubes()[0].select();
                                currSelectedTube=currLevel.getTubes()[0];
                                currSelectedTubeIndex=0;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[0].topColor()) || currLevel.getTubes()[0].topColor()==(null)) 
                                && !currLevel.getTubes()[0].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[0]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 2
                    else if (click_x >= 135 && click_x <= 185 && click_y >= 160 && click_y <= 340)
                    {
                         if(currLevel.getTubes()[1].getIsSelected()){ 
                            currLevel.getTubes()[1].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[1];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[1].isComplete() && !currLevel.getTubes()[1].isEmpty()){
                                currLevel.getTubes()[1].select();
                                currSelectedTube=currLevel.getTubes()[1];
                                currSelectedTubeIndex=1;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[1].topColor()) || currLevel.getTubes()[1].topColor()==(null)) 
                                && !currLevel.getTubes()[1].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[1]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 3
                    else if (click_x >= 220 && click_x <= 270 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[2].getIsSelected()){ 
                            currLevel.getTubes()[2].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[2];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[2].isComplete() && !currLevel.getTubes()[2].isEmpty()){
                                currLevel.getTubes()[2].select();
                                currSelectedTube=currLevel.getTubes()[2];
                                currSelectedTubeIndex=2;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[2].topColor()) || currLevel.getTubes()[2].topColor()==(null)) 
                                && !currLevel.getTubes()[2].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[2]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 4
                    else if (click_x >= 305 && click_x <= 355 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[3].getIsSelected()){ 
                            currLevel.getTubes()[3].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[3];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[3].isComplete() && !currLevel.getTubes()[3].isEmpty()){
                                currLevel.getTubes()[3].select();
                                currSelectedTube=currLevel.getTubes()[3];
                                currSelectedTubeIndex=3;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[3].topColor()) || currLevel.getTubes()[3].topColor()==(null)) 
                                && !currLevel.getTubes()[3].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[3]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 5, second row
                    else if (click_x >= 90 && click_x <= 140 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[4].getIsSelected()){ 
                            currLevel.getTubes()[4].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[4];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[4].isComplete() && !currLevel.getTubes()[4].isEmpty()){
                                currLevel.getTubes()[4].select();
                                currSelectedTube=currLevel.getTubes()[4];
                                currSelectedTubeIndex=4;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[4].topColor()) || currLevel.getTubes()[4].topColor()==(null)) 
                                && !currLevel.getTubes()[4].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[4]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 6, second row
                    else if (click_x >= 175 && click_x <= 225 && click_y >= 395 && click_y <= 575)
                    {
                         if(currLevel.getTubes()[5].getIsSelected()){ 
                            currLevel.getTubes()[5].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[5];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[5].isComplete() && !currLevel.getTubes()[5].isEmpty()){
                                currLevel.getTubes()[5].select();
                                currSelectedTube=currLevel.getTubes()[5];
                                currSelectedTubeIndex=5;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[5].topColor()) || currLevel.getTubes()[5].topColor()==(null)) 
                                && !currLevel.getTubes()[5].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[5]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 7, second row
                    else if (click_x >= 260 && click_x <= 310 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[6].getIsSelected()){ 
                            currLevel.getTubes()[6].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[6];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[6].isComplete() && !currLevel.getTubes()[6].isEmpty()){
                                currLevel.getTubes()[6].select();
                                currSelectedTube=currLevel.getTubes()[6];
                                currSelectedTubeIndex=6;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[6].topColor()) || currLevel.getTubes()[6].topColor()==(null)) 
                                && !currLevel.getTubes()[6].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[6]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    
                }
                else if (currNumTubes == 9)
                {
                    //tube 1
                    if (click_x >= 35 && click_x <= 85 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[0].getIsSelected()){ 
                            currLevel.getTubes()[0].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[0];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[0].isComplete() && !currLevel.getTubes()[0].isEmpty()){
                                currLevel.getTubes()[0].select();
                                currSelectedTube=currLevel.getTubes()[0];
                                currSelectedTubeIndex=0;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[0].topColor()) || currLevel.getTubes()[0].topColor()==(null)) 
                                && !currLevel.getTubes()[0].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[0]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 2
                    else if (click_x >= 105 && click_x <= 155 && click_y >= 160 && click_y <= 340)
                    {
                         if(currLevel.getTubes()[1].getIsSelected()){ 
                            currLevel.getTubes()[1].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[1];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[1].isComplete() && !currLevel.getTubes()[1].isEmpty()){
                                currLevel.getTubes()[1].select();
                                currSelectedTube=currLevel.getTubes()[1];
                                currSelectedTubeIndex=1;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[1].topColor()) || currLevel.getTubes()[1].topColor()==(null)) 
                                && !currLevel.getTubes()[1].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[1]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 3
                    else if (click_x >= 175 && click_x <= 225 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[2].getIsSelected()){ 
                            currLevel.getTubes()[2].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[2];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[2].isComplete() && !currLevel.getTubes()[2].isEmpty()){
                                currLevel.getTubes()[2].select();
                                currSelectedTube=currLevel.getTubes()[2];
                                currSelectedTubeIndex=2;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[2].topColor()) || currLevel.getTubes()[2].topColor()==(null)) 
                                && !currLevel.getTubes()[2].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[2]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 4
                    else if (click_x >= 245 && click_x <= 295 && click_y >= 160 && click_y <= 340)
                    {
                        if(currLevel.getTubes()[3].getIsSelected()){ 
                            currLevel.getTubes()[3].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[3];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[3].isComplete() && !currLevel.getTubes()[3].isEmpty()){
                                currLevel.getTubes()[3].select();
                                currSelectedTube=currLevel.getTubes()[3];
                                currSelectedTubeIndex=3;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[3].topColor()) || currLevel.getTubes()[3].topColor()==(null)) 
                                && !currLevel.getTubes()[3].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[3]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 5
                    else if (click_x >= 315 && click_x <= 365 && click_y >= 160 && click_y <= 340)
                    {
                         if(currLevel.getTubes()[4].getIsSelected()){ 
                            currLevel.getTubes()[4].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[4];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[4].isComplete() && !currLevel.getTubes()[4].isEmpty()){
                                currLevel.getTubes()[4].select();
                                currSelectedTube=currLevel.getTubes()[4];
                                currSelectedTubeIndex=4;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[4].topColor()) || currLevel.getTubes()[4].topColor()==(null)) 
                                && !currLevel.getTubes()[4].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[4]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 6, second row
                    else if (click_x >= 55 && click_x <= 105 && click_y >= 395 && click_y <= 575)
                    {
                         if(currLevel.getTubes()[5].getIsSelected()){ 
                            currLevel.getTubes()[5].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[5];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[5].isComplete() && !currLevel.getTubes()[5].isEmpty()){
                                currLevel.getTubes()[5].select();
                                currSelectedTube=currLevel.getTubes()[5];
                                currSelectedTubeIndex=5;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[5].topColor()) || currLevel.getTubes()[5].topColor()==(null)) 
                                && !currLevel.getTubes()[5].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[5]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 7, second row
                    else if (click_x >= 135 && click_x <= 185 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[6].getIsSelected()){ 
                            currLevel.getTubes()[6].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[6];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[6].isComplete() && !currLevel.getTubes()[6].isEmpty()){
                                currLevel.getTubes()[6].select();
                                currSelectedTube=currLevel.getTubes()[6];
                                currSelectedTubeIndex=6;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[6].topColor()) || currLevel.getTubes()[6].topColor()==(null)) 
                                && !currLevel.getTubes()[6].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[6]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 8, second row
                    else if (click_x >= 215 && click_x <= 265 && click_y >= 395 && click_y <= 575)
                    {
                        if(currLevel.getTubes()[7].getIsSelected()){ 
                            currLevel.getTubes()[37].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[7];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[7].isComplete() && !currLevel.getTubes()[7].isEmpty()){
                                currLevel.getTubes()[7].select();
                                currSelectedTube=currLevel.getTubes()[7];
                                currSelectedTubeIndex=7;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[7].topColor()) || currLevel.getTubes()[7].topColor()==(null)) 
                                && !currLevel.getTubes()[7].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[7]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                    //tube 9, second row
                    else if (click_x >= 295 && click_x <= 345 && click_y >= 395 && click_y <= 575)
                    {
                         if(currLevel.getTubes()[8].getIsSelected()){ 
                            currLevel.getTubes()[8].deselect();
                            currSelectedTube=null;
                            currDeselectedTube=currLevel.getTubes()[8];
                        }else if(currSelectedTube==null){ 
                            if(!currLevel.getTubes()[8].isComplete() && !currLevel.getTubes()[8].isEmpty()){
                                currLevel.getTubes()[8].select();
                                currSelectedTube=currLevel.getTubes()[8];
                                currSelectedTubeIndex=8;
                            }
                        }else{ 
                            if ((currSelectedTube.topColor().equals(currLevel.getTubes()[8].topColor()) || currLevel.getTubes()[8].topColor()==(null)) 
                                && !currLevel.getTubes()[8].isFull())
                            {
                                currSelectedTube.pourTo(currLevel.getTubes()[8]);
                                currSelectedTube=null;
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currLevel.getTubes()[currSelectedTubeIndex];
                            }else{
                                currLevel.getTubes()[currSelectedTubeIndex].deselect();
                                currDeselectedTube=currSelectedTube;
                                currSelectedTube=null;
                            }
                        }
                    }
                }
                //every time something on the screen is supposed to change
                //you need to say repaint();
                //this reruns paintComponent()
                repaint();
            }
        });
    }

    public void run(){
        try{
            while(true){
                raiseTube();
                unraiseTube();
                repaint();
                try{
                    Thread.sleep(millis);
                }catch(InterruptedException e){}
            }
        }catch (Exception e){}
    }

    //don't change this method
    public void start(){
        new Thread(this).start();
    }

    //5, 5, 5m, 7, 7, 7m, 9, 9, 9m, 9, 9, 9m
    //this method draws everything.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //System.out.println(currLevel.getTubes()[0].isEmpty());
        currLevel.drawTubes(g);
    }

    //raises tube when selected
    public void raiseTube(){
        millis=3;
        if(currSelectedTube!=null && currSelectedTube.getY()!=currSelectedTube.getOriginalY()-20){
            currSelectedTube.setY(currSelectedTube.getY()-1);
        }
    }

    //unraises tube when deselected
    public void unraiseTube(){
        millis=3;
        if(currDeselectedTube!=null && currDeselectedTube.getY()!=currDeselectedTube.getOriginalY()){
            currDeselectedTube.setY(currDeselectedTube.getY()+1);
        }else{
            currDeselectedTube=null;
        }
    }

    public void shakeTube(){
        millis=1;
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