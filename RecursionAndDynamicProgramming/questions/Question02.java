/*
A robot sits on the upper left corner of a X by Y grid. The robot can only move in two directions: right or down.
How many possible paths are there for the robot to move from (0,0) to (X,Y)
*/
public class Question02{
  public static void main(String[] args){
    System.out.println(findNumberOfPossiblePath(3,3));
  }
  public static int findNumberOfPossiblePath(int x, int y){
    int[][] opt = new int[x][y];
    for(int i=0;i<x;i++){
      for(int j=0;j<y;j++){
        opt[i][j] = findOptValue(opt, i,j);
      }
    }
    return opt[x-1][y-1];
  }
  public static int findOptValue(int[][] opt, int i, int j){
    if(i==0 || j==0){
      return 1;
    }
    return opt[i][j-1] + opt[i-1][j];
  }
}
