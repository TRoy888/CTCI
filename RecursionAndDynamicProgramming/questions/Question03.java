/*
Given a sorted array of distinct integers, write a method to find a magic index if one exists in the array.
A Magic index is an index in array A[1...n-1] such that A[i]=i
*/
public class Question03{
  public static void main(String[] args){
    int[] input1 = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    System.out.println(findAMagicIndexFromDistinctSortedArray(input1));
    System.out.println(findAMagicIndexFromDistinctSortedArray(new int[]{1}));
    System.out.println(findAMagicIndexFromDistinctSortedArray(new int[]{}));
    System.out.println(findAMagicIndexFromDistinctSortedArray(new int[]{0}));
    System.out.println(findAMagicIndexFromDistinctSortedArray(new int[]{5,6}));
    System.out.println(findAMagicIndexFromDistinctSortedArray(new int[]{0,5,6}));
    System.out.println(findAMagicIndexFromSortedArray(new int[]{2,2,2}));
    System.out.println(findAMagicIndexFromSortedArray(new int[]{-10, -5, 1, 1, 1, 3, 4, 7, 9, 12, 13}));
  }
  public static int findAMagicIndexFromDistinctSortedArray(int[] input){
    return helper1(input, 0, input.length-1);
  }
  public static int helper1(int[] input, int start, int end){
    if(start>end)
      return -1;
    int mid = (start+end)/2;
    if(mid==input[mid]){
      return mid;
    }
    if(input[mid]>mid){
      return helper1(input, start, mid-1);
    }
    else{
      return helper1(input, mid+1, end);
    }
  }
  public static int findAMagicIndexFromSortedArray(int[] input){
    return helper2(input, 0, input.length);
  }
  public static int helper2(int[] input, int start, int end){
    if(start>end)
      return -1;
    int mid = (start+end)/2;
    if(mid==input[mid])
      return mid;
    int left = Math.min(mid-1, input[mid]);
    int leftR = helper2(input, start, left);
    if(leftR!=-1)
      return leftR;
    int right = Math.max(mid+1, input[mid]);
    int rightR = helper2(input, right, end);
      return rightR;
  }
}
