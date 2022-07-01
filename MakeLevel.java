import java.awt.*;
//JAVA DOCS DONE
/**
 * Creates all of the Levels. Each level is an array of tubes. 
 * Each tube is a Stack of Colors. 
 * We call MakeLevel in Main to create all of the Levels.
 */
public class MakeLevel {

    /**
     * Generates level 1 with 5 tubes
     * @return level level1
     */
    public static Level level1(){
        //5 tubes
        //tube 1
        Color[] colors1 = {Color.PINK,Color.GREEN,Color.BLUE,Color.PINK};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.GREEN,Color.GREEN,Color.BLUE,Color.PINK};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.BLUE,Color.PINK,Color.GREEN,Color.BLUE};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {null,null,null,null};
        Tube tube4 = new Tube(colors4,false);
        Tube tube5 = new Tube(colors4,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5};
        Level level = new Level(tubes,3,false);
        return level;
    }

    /**
     * Generates level 2 with 5 test tubes
     * @return level level2
     */
    public static Level level2()
    {
        //5 test tubes
        Color[] colors1 = {Color.ORANGE,Color.ORANGE,Color.RED,Color.BLUE};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.BLUE,Color.ORANGE,Color.RED,Color.BLUE};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.RED,Color.BLUE,Color.ORANGE,Color.RED};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {null,null,null,null};
        Tube tube4 = new Tube(colors4,false);
        Tube tube5 = new Tube(colors4,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5};
        Level level = new Level(tubes, 3, false);
        return level;
    }

    /**
     * Generates level 3 with 5 test tubes, it is a mystery level
     * @return level level3
     */
    public static Level level3()
    {
        //5 test tubes, mystery
        Color[] colors1 = {Color.BLUE,Color.PINK,Color.YELLOW,Color.YELLOW};
        Tube tube1 = new Tube(colors1,true);
        Color[] colors2 = {Color.YELLOW,Color.BLUE,Color.PINK,Color.YELLOW};
        Tube tube2 = new Tube(colors2,true);
        Color[] colors3 = {Color.BLUE,Color.PINK,Color.BLUE,Color.PINK};
        Tube tube3 = new Tube(colors3,true);
        Color[] colors4 = {null,null,null,null};
        Tube tube4 = new Tube(colors4,true);
        Tube tube5 = new Tube(colors4,true);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5};
        Level level = new Level(tubes,3, true);
        return level;
    }

    /**
     * generates level with 7 tubes
     * @return level level7
     */
    public static Level level4(){
        //7 tubes
        Color[] colors1 = {Color.BLUE,Color.PINK,Color.GREEN,Color.GREEN};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.ORANGE,Color.BLUE,Color.PINK,Color.BLUE};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.BLUE,Color.ORANGE,Color.RED,Color.GREEN};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.ORANGE,Color.GREEN,Color.RED,Color.PINK};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.RED,Color.ORANGE,Color.RED,Color.PINK};
        Tube tube5 = new Tube(colors5,false);
        Color[] colorsNull = {null,null,null,null};
        Tube tube6 = new Tube(colorsNull,false);
        Tube tube7 = new Tube(colorsNull,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7};
        Level level = new Level(tubes,5,false);
        return level;
    }

    /**
     * generates level with 7 tubes
     * @return level level5
     */
    public static Level level5(){
        //7 tubes
        Color[] colors1 = {Color.RED,Color.GREEN,Color.GREEN,Color.GREEN};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.YELLOW,Color.RED,Color.PINK,Color.GREEN};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.PINK,Color.YELLOW,Color.RED,Color.RED};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.BLUE,Color.PINK,Color.YELLOW,Color.PINK};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.BLUE,Color.BLUE,Color.BLUE,Color.YELLOW};
        Tube tube5 = new Tube(colors5,false);
        Color[] colorsNull = {null,null,null,null};
        Tube tube6 = new Tube(colorsNull,false);
        Tube tube7 = new Tube(colorsNull,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7};
        Level level = new Level(tubes,5,false);
        return level;
    }

    /**
     * Generates level with 7 tubes, is a mystery level
     * @return level level6
     */
    public static Level level6()
    {
        //7 tubes, mystery level
        Color[] colors1 = {Color.GREEN,Color.YELLOW,Color.RED,Color.YELLOW};
        Tube tube1 = new Tube(colors1,true);
        Color[] colors2 = {Color.BLUE,Color.BLUE,Color.RED,Color.YELLOW};
        Tube tube2 = new Tube(colors2,true);
        Color[] colors3 = {Color.PINK,Color.PINK,Color.BLUE,Color.YELLOW};
        Tube tube3 = new Tube(colors3,true);
        Color[] colors4 = {Color.GREEN,Color.PINK,Color.RED,Color.BLUE};
        Tube tube4 = new Tube(colors4,true);
        Color[] colors5 = {Color.GREEN,Color.RED,Color.GREEN,Color.PINK};
        Tube tube5 = new Tube(colors5,true);
        Color[] colorsNull = {null,null,null,null};
        Tube tube6 = new Tube(colorsNull,true);
        Tube tube7 = new Tube(colorsNull,true);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6, tube7};
        Level level = new Level(tubes, 5, true);
        return level;
    }
    
    /**
     * 
     * @return
     */
    public static Level level7(){
        //9 tubes
        Color[] colors1 = {Color.BLUE,Color.PINK,Color.GREEN,Color.RED};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.ORANGE,Color.GREEN,Color.GREEN,Color.CYAN};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.PINK,Color.GRAY,Color.ORANGE,Color.RED};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.GREEN,Color.RED,Color.BLUE,Color.CYAN};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.CYAN,Color.PINK,Color.GRAY,Color.CYAN};
        Tube tube5 = new Tube(colors5,false);
        Color[] colors6 = {Color.PINK,Color.ORANGE,Color.BLUE,Color.GRAY};
        Tube tube6 = new Tube(colors6,false);
        Color[] colors7 = {Color.GRAY,Color.RED,Color.BLUE,Color.ORANGE};
        Tube tube7 = new Tube(colors7,false);
        Color[] colorsNull = {null,null,null,null};
        Tube tube8 = new Tube(colorsNull,false);
        Tube tube9 = new Tube(colorsNull,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7,tube8,tube9};
        Level level = new Level(tubes,7,false);
        return level;
    }

    /**
     * generates level with 9 tubes
     * @return level level8
     */
    public static Level level8()
    {
        //9 tubes
        Color[] colors1 = {Color.PINK,Color.GREEN,Color.GREEN,Color.PINK};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.CYAN,Color.PINK,Color.YELLOW,Color.PINK};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.MAGENTA,Color.BLUE,null,null};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.GRAY,Color.YELLOW,Color.BLUE,Color.GRAY};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.BLUE,Color.CYAN,Color.GRAY,null};
        Tube tube5 = new Tube(colors5,false);
        Color[] colors6 = {Color.CYAN,Color.GRAY,Color.GREEN,Color.CYAN};
        Tube tube6 = new Tube(colors6, false);
        Color[] colors7 = {Color.GREEN,Color.YELLOW,Color.YELLOW,Color.BLUE};
        Tube tube7 = new Tube(colors7, false);
        Color[] colors8 = {Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,null};
        Tube tube8 = new Tube(colors8, false);
        Color[] colorsNull = {null, null, null, null};
        Tube tube9 = new Tube(colorsNull, false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7, tube8, tube9};
        Level level = new Level(tubes,7,false);
        return level;
    }

    /**
     * generates level with 9 tubes, is mystery level
     * @return level level9
     */
    public static Level level9()
    {
        //9 tubes mystery
        Color[] colors1 = {Color.RED,Color.PINK,Color.PINK,Color.RED};
        Tube tube1 = new Tube(colors1,true);
        Color[] colors2 = {Color.CYAN,Color.RED,Color.MAGENTA,Color.RED};
        Tube tube2 = new Tube(colors2,true);
        Color[] colors3 = {Color.ORANGE,Color.GREEN,Color.ORANGE,Color.ORANGE};
        Tube tube3 = new Tube(colors3,true);
        Color[] colors4 = {Color.GRAY,Color.MAGENTA,Color.GREEN,Color.GRAY};
        Tube tube4 = new Tube(colors4,true);
        Color[] colors5 = {Color.GREEN,Color.CYAN,Color.GRAY,Color.ORANGE};
        Tube tube5 = new Tube(colors5,true);
        Color[] colors6 = {Color.CYAN,Color.GRAY,Color.PINK,Color.CYAN};
        Tube tube6 = new Tube(colors6,true);
        Color[] colors7 = {Color.PINK,Color.MAGENTA,Color.MAGENTA,Color.GREEN};
        Tube tube7 = new Tube(colors7,true);
        Color[] colorsNull = {null,null,null,null};
        Tube tube8 = new Tube(colorsNull,true);
        Tube tube9 = new Tube(colorsNull,true);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7,tube8,tube9};
        Level level = new Level(tubes,7,true);
        return level;
        
        
    }

    /**
     * generates level with 9 tubes
     * @return level level10
     */
    public static Level level10(){
        //9 tubes
        Color[] colors1 = {Color.GRAY,Color.BLUE,Color.BLUE,Color.BLUE};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.BLUE,Color.GRAY,Color.PINK,Color.ORANGE};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.GRAY,Color.ORANGE,Color.GRAY,Color.GREEN};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.RED,Color.ORANGE,Color.GREEN,Color.PINK};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.RED,Color.CYAN,Color.PINK,Color.RED};
        Tube tube5 = new Tube(colors5,false);
        Color[] colors6 = {Color.ORANGE,Color.CYAN,Color.GREEN,Color.CYAN};
        Tube tube6 = new Tube(colors6,false);
        Color[] colors7 = {Color.PINK,Color.GREEN,Color.CYAN,Color.RED};
        Tube tube7 = new Tube(colors7,false);
        Color[] colorsNull = {null,null,null,null};
        Tube tube8 = new Tube(colorsNull,false);
        Tube tube9 = new Tube(colorsNull,false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7,tube8,tube9};
        Level level = new Level(tubes,7,false);
        return level;
    }
    /**
     * generates level with 9 tubes
     * @return level level11
     */
    public static Level level11(){
        //9 tubes
        Color[] colors1 = {Color.ORANGE,Color.YELLOW,Color.GREEN,Color.ORANGE};
        Tube tube1 = new Tube(colors1,false);
        Color[] colors2 = {Color.GRAY,Color.GREEN,Color.PINK,Color.BLUE};
        Tube tube2 = new Tube(colors2,false);
        Color[] colors3 = {Color.GREEN,Color.GRAY,Color.BLUE,Color.GREEN};
        Tube tube3 = new Tube(colors3,false);
        Color[] colors4 = {Color.ORANGE,Color.PINK,Color.YELLOW,Color.MAGENTA};
        Tube tube4 = new Tube(colors4,false);
        Color[] colors5 = {Color.BLUE,Color.MAGENTA,Color.ORANGE,Color.BLUE};
        Tube tube5 = new Tube(colors5,false);
        Color[] colors6 = {Color.PINK,Color.GRAY,Color.MAGENTA,Color.PINK};
        Tube tube6 = new Tube(colors6, false);
        Color[] colors7 = {Color.MAGENTA,Color.GRAY,Color.YELLOW,Color.YELLOW};
        Tube tube7 = new Tube(colors7, false);
        Color[] colorsNull = {null, null, null, null};
        Tube tube8 = new Tube(colorsNull, false);
        Tube tube9 = new Tube(colorsNull, false);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7, tube8, tube9};
        Level level = new Level(tubes,7,false);
        return level;
    }
    
    /**
     * generates level with 9 tubes, mystery level
     * last level in the game
     * @return level level12
     */
    public static Level level12()
    {
        //9 tubes, mystery
        Color[] colors1 = {Color.BLUE,Color.ORANGE,Color.YELLOW,Color.CYAN};
        Tube tube1 = new Tube(colors1,true);
        Color[] colors2 = {Color.GREEN,Color.BLUE,Color.YELLOW,Color.BLUE};
        Tube tube2 = new Tube(colors2,true);
        Color[] colors3 = {Color.ORANGE,Color.CYAN,Color.PINK,Color.PINK};
        Tube tube3 = new Tube(colors3,true);
        Color[] colors4 = {Color.GREEN,Color.BLUE,Color.GREEN,Color.CYAN};
        Tube tube4 = new Tube(colors4,true);
        Color[] colors5 = {Color.RED,Color.PINK,Color.ORANGE,Color.RED};
        Tube tube5 = new Tube(colors5,true);
        Color[] colors6 = {Color.CYAN,Color.GREEN,Color.RED,Color.ORANGE};
        Tube tube6 = new Tube(colors6,true);
        Color[] colors7 = {Color.YELLOW,Color.RED,Color.PINK,Color.YELLOW};
        Tube tube7 = new Tube(colors7,true);
        Color[] colorsNull = {null,null,null,null};
        Tube tube8 = new Tube(colorsNull,true);
        Tube tube9 = new Tube(colorsNull,true);
        Tube[] tubes = {tube1,tube2,tube3,tube4,tube5,tube6,tube7,tube8,tube9};
        Level level = new Level(tubes,7,true);
        return level;

    }
}
