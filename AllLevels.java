//JAVADOCS 
/**
 * This class constructs all the levels of the whole game. 
 * It will be an array of Levels. 
 * We create this object in Main to initialize all levels.
 */
public class AllLevels {

    private Level[] levels;
    private int numLevels;
    private int levelsCompleted;

    /**
     * Creates an array of all levels in the game.
     * Includes number of levels and number of levels completed
     */
    public AllLevels(Level[] levels){
        this.numLevels = levels.length;
        this.levels = levels;
        this.levelsCompleted = 0;
    }
    /**
     * returns levels in the array
     * @return levels in array
     */
    public Level[] getLevels(){
        return levels;
    }
    /**
     * gets number of levels in array
     * @return numLevels number of levels in array

     */
    public int getNumLevels(){
        return numLevels;
    }
    /**
     * gets number of completed levels in array
     * @return levelsCompleted # of complete levels
     */
    public int getLevelsCompleted(){
        return levelsCompleted;
    }
    /**
     * sets number of levels completed to int n
     * @return n number to be set to
     */
    public void setLevelsCompleted(int n){
        levelsCompleted=n;
    }
    /**
     * Determines whether if all levels in the game are completed
     * If all of the levels in the array are completed, all levels are completed
     * This means the game is beat.
     * @return whether or not all levles in the game are complete
     */
    public boolean allLevelsCompleted()
    {
        boolean complete = true;
        for (Level l : levels)
        {
            if (!l.isComplete())
            {
                complete = false;
            }
        }

        return complete;
    }
}
