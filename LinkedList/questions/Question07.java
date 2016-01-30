/*
Implement a function to check if a linked list is a palindrome
*/
import java.util.*;
public class Question07{
  public static void testS1(){
    System.out.println("TEST--S1");
    System.out.println(isPalindrome(null));

    System.out.println(isPalindrome(new Node<Character>('A')));
    Node<Character> c1 = new Node<Character>('A');
    Node<Character> c2 = new Node<Character>('T');
    Node<Character> c3 = new Node<Character>('O');
    Node<Character> c4 = new Node<Character>('M');
    c1.next = c2; c2.next=c3; c3.next=c4;
    System.out.println(isPalindrome(c1));

    Node<Character> d1 = new Node<Character>('A');
    Node<Character> d2 = new Node<Character>('N');
    Node<Character> d3 = new Node<Character>('A');
    d1.next=d2; d2.next=d3;
    System.out.println(isPalindrome(d1));
  }

  public static void testS2(){
    System.out.println("TEST--S2");
    System.out.println(isPalindromeStack(null));

    System.out.println(isPalindromeStack(new Node<Character>('A')));
    Node<Character> c1 = new Node<Character>('A');
    Node<Character> c2 = new Node<Character>('T');
    Node<Character> c3 = new Node<Character>('O');
    Node<Character> c4 = new Node<Character>('M');
    c1.next = c2; c2.next=c3; c3.next=c4;
    System.out.println(isPalindromeStack(c1));

    Node<Character> d1 = new Node<Character>('A');
    Node<Character> d2 = new Node<Character>('N');
    Node<Character> d3 = new Node<Character>('A');
    d1.next=d2; d2.next=d3;
    System.out.println(isPalindromeStack(d1));

  }

  public static void testS3(){
    System.out.println("TEST--S3");
    System.out.println(isPalindromeRecursion(null));

    System.out.println(isPalindromeRecursion(new Node<Character>('A')));
    Node<Character> c1 = new Node<Character>('A');
    Node<Character> c2 = new Node<Character>('T');
    Node<Character> c3 = new Node<Character>('O');
    Node<Character> c4 = new Node<Character>('M');
    c1.next = c2; c2.next=c3; c3.next=c4;
    System.out.println(isPalindromeRecursion(c1));

    Node<Character> d1 = new Node<Character>('A');
    Node<Character> d2 = new Node<Character>('N');
    Node<Character> d3 = new Node<Character>('A');
    d1.next=d2; d2.next=d3;
    System.out.println(isPalindromeRecursion(d1));

  }

  public static void main(String[] args){
    testS1();
    testS2();
    testS3();
  }

  public static boolean isPalindrome(Node<Character> first){
    Node<Character> p1 = first;
    Node<Character> p2 = null;
    int count = 0;
    while(p1!=null){
      Node<Character> tmp = new Node<Character>(p1.val);
      count++;
      tmp.next = p2;
      p2 = tmp;
      p1 = p1.next;
    }
    if(p2==null)
      return false;
    p1 = first;
    count/=2;
    while(p2!=null && p1!=null && count>0){
      if(p1.val!=p2.val)
        return false;
      p1 = p1.next;
      p2 = p2.next;
      count--;
    }
    return true;
  }

  public static boolean isPalindromeStack(Node<Character> first){
    if(first==null)
      return false;
    Node<Character> fp = first, sp = first;
    Stack<Node<Character>> stack = new Stack<Node<Character>>();
    while(fp!=null && fp.next!=null){
      stack.push(sp);
      fp = fp.next.next;
      sp = sp.next;
    }
    if(fp!=null){
      sp = sp.next;
    }
    while(!stack.isEmpty() && sp!=null){
      char cl = stack.pop().val;
      char cr = sp.val;
      if(cl!=cr)
        return false;
      sp = sp.next;
    }
    if(!stack.isEmpty() || sp!=null)
      return false;
    return true;
  }

  static class R<T>{
    Node<T> node;
    boolean res;
    public R(Node<T> node, boolean res){
      this.node = node;
      this.res = res;
    }
  }
  public static boolean isPalindromeRecursion(Node<Character> first){
    if(first==null)
      return false;
    Node<Character> tmp = first;
    int count = 0;
    while(tmp!=null){
      count++;
      tmp = tmp.next;
    }
    return helper(first, count).res;
  }
  public static R<Character> helper(Node<Character> node, int size){
    if(size==1){
      return new R<Character>(node.next, true);
    }
    if(size==2){
      return new R<Character>(node.next.next, node.val == node.next.val);
    }
    R<Character> result = helper(node.next, size-2);
    if(!result.res)
      return result;
    return new R<Character>(result.node.next, result.node.val==node.val);
  }
}
