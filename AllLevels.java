public class AllLevels {

    private Level[] levels;
    private int numLevels;
    private int levelsCompleted;

    public AllLevels(Level[] levels){
        this.numLevels = levels.length;
        this.levels = levels;
        this.levelsCompleted = 0;
    }

    public Level[] getLevels(){
        return levels;
    }

    public int getNumLevels(){
        return numLevels;
    }

    public int getLevelsCompleted(){
        return levelsCompleted;
    }

    public void setLevelsCompleted(int n){
        levelsCompleted=n;
    }

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
