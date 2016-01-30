/*
  A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at at time.
  Implement a method to count how many possible ways the child can run up the stairs.
*/
public class Question01{
  public static void main(String[] args){
    System.out.println(findPossibleWays(5));
  }

  public static int findPossibleWays(int n){
    if(n<0)
      return 0;
    if(n==1)
      return 1;
    if(n==2)
      return 2;
    if(n==3)
      return 4;
    int[] opt = new int[n];
    opt[0]=1;
    opt[1]=2;
    opt[2]=4;
    for(int i=3; i<opt.length; i++){
      opt[i]=opt[i-1]+opt[i-2]+opt[i-3];
    }
    return opt[n-1];
  }
}
