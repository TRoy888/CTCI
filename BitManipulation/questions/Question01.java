public class Question01{
  public static void main(String[] args){
    int n = Integer.parseInt("10000000", 2);
    int m = Integer.parseInt("11001",2);
    int i = 2;
    int j = 6;
    System.out.println(Integer.toBinaryString(insertBit(n,m,i,j)));
  }
  public static int insertBit(int n, int m, int i, int j){
    int l = ((~0)<<j);
    int r = (1<<i)-1;
    int mask = l|r;
    int mShifted = m<<i;
    return (mask&n)|mShifted;
  }

}
