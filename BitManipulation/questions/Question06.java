public class Question06{
  public static void main(String[] args){
    System.out.println(String.format("%16s",Integer.toBinaryString(swapOddEvenBits(Integer.parseInt("111010101010101010101010101010",2)))).replace(' ','0'));
  }

  public static int swapOddEvenBits(int n){
    int odd = 1;
    int even = 2;
    for(int i=0;i<15;i++){
      odd<<=2;
      even<<=2;
      odd|=1;
      even|=2;
    }
    System.out.println(Integer.toBinaryString(odd));
    System.out.println(Integer.toBinaryString(even));
    int tmp1 = n&odd;
    int tmp2 = n&even;
    System.out.println(Integer.toBinaryString(tmp1));
    System.out.println(Integer.toBinaryString(tmp2));
    int tmp3 = tmp1<<1;
    int tmp4 = tmp2>>1;
    System.out.println(Integer.toBinaryString(tmp3));
    System.out.println(Integer.toBinaryString(tmp4));
    return tmp3|tmp4;
  }
}
