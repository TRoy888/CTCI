public class BitCommonTask{
	public static void main(String[] args){
		BitCommonTask bitCommonTask = new BitCommonTask();
		System.out.println(bitCommonTask.getBit(4,3));
		System.out.println(bitCommonTask.getBit(3,3));
		System.out.println(Integer.toBinaryString(bitCommonTask.setBit(4,1)));
		System.out.println(Integer.toBinaryString(bitCommonTask.clearBit(4,3)));
		System.out.println(Integer.toBinaryString(bitCommonTask.clearBit(3,1)));
		System.out.println(Integer.toBinaryString(bitCommonTask.clearMSBThroughI(7,2)));

	}
	public boolean getBit(int num, int i){
		int tmp = 1<<i-1;
		return (num&tmp)==tmp;
	}
	public int setBit(int num, int i){
		int tmp = 1<<i-1;
		return num | tmp;	
	}
	public int clearBit(int num, int i){
		int tmp = 1<<i-1;
		tmp = ~tmp;
		return num&tmp;
	}
	public int clearMSBThroughI(int num, int i){
		int tmp = 1<<i;
		tmp -=1;
		return num&tmp;
	}

}
