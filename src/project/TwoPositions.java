package project;

public class TwoPositions {
    private int startFirst;
    private int startSecond;
    private int endFirst;
    private int endSecond;

    public void addStart(int i, int j){
        startFirst = i;
        startSecond = j;
    }
    public void addEnd(int i, int j){
        endFirst = i;
        endSecond = j;
    }
    public void clear(){
        startFirst = -1;
        startSecond = -1;
        endFirst = -1;
        endSecond = -1;
    }
    public int length(boolean vertical){
        if (vertical){
            return Math.abs(endFirst - startFirst) + 1;
        } else {
            return Math.abs(endSecond - startSecond) + 1;
        }
    }
    public String toString(){
        return "[("+startFirst+";"+startSecond+"),("+endFirst+";"+endSecond+")]";
    }
}
