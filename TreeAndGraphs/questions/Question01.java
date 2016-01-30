/*
Implement a function to check if the binary tree is balanace or not
Balanced tree -> the depth from left and right sides are never be more than one.
*/
public class Question01{
  public static void main(String[] args){
    NodeTree<Integer> n1 = new NodeTree<Integer>(1);
    NodeTree<Integer> n2 = new NodeTree<Integer>(1);
    NodeTree<Integer> n3 = new NodeTree<Integer>(1);
    NodeTree<Integer> n4 = new NodeTree<Integer>(1);
    NodeTree<Integer> n5 = new NodeTree<Integer>(1);
    NodeTree<Integer> n6 = new NodeTree<Integer>(1);
    NodeTree<Integer> n7 = new NodeTree<Integer>(1);
    NodeTree<Integer> n8 = new NodeTree<Integer>(1);
    NodeTree<Integer> n9 = new NodeTree<Integer>(1);
    NodeTree<Integer> n10 = new NodeTree<Integer>(1);
    NodeTree<Integer> n11 = new NodeTree<Integer>(1);
    NodeTree<Integer> n12 = new NodeTree<Integer>(1);
    NodeTree<Integer> n13 = new NodeTree<Integer>(1);
    NodeTree<Integer> n14 = new NodeTree<Integer>(1);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n4.left = n8;
    n4.right = n9;
    n5.left = n10;
    n5.right = n11;
    n6.left = n12;
    n6.right = n13;
    n7.left = n14;
    System.out.println(isBalancedBTree(n1));
    NodeTree<Integer> n15 = new NodeTree<Integer>(1);
    n8.left = n15;
    System.out.println(isBalancedBTree(n1));
    NodeTree<Integer> n16 = new NodeTree<Integer>(1);
    n15.left = n16;
    System.out.println(isBalancedBTree(n1));

  }
  public static boolean isBalancedBTree(NodeTree<Integer> root){
    int tmp = helper(root);
    return (tmp<0)?false:true;
  }
  public static int helper(NodeTree<Integer> root){
    if(root==null){
      return 0;
    }
    int left = helper(root.left);
    if(left<0){
      return -1;
    }
    int right = helper(root.right);
    if(right < 0 || Math.abs(left-right)>1){
      return -1;
    }
    return Math.max(left,right)+1;
  }
}
