public class TryBitManipulation{
	public static void main(String args[]){
		int x=0;
		int y=~x;
		System.out.println(y);
		System.out.println(Integer.toBinaryString(y<<2));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(-1>>>(31-10)));
		System.out.println(Integer.toBinaryString(-1));
	}
}
