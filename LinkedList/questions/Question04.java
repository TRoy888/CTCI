/*
Wreite a code to partition a linked list around a value x, such that all nodes less than x come
before nodes greater or equal to x
*/

public class Question04{
  public static Node<Integer> createList(){
    Node<Integer> n1 = new Node<Integer>(10);
    Node<Integer> n2 = new Node<Integer>(9);
    Node<Integer> n3 = new Node<Integer>(8);
    Node<Integer> n4 = new Node<Integer>(7);
    Node<Integer> n5 = new Node<Integer>(6);
    Node<Integer> n6 = new Node<Integer>(5);
    Node<Integer> n7 = new Node<Integer>(4);
    Node<Integer> n8 = new Node<Integer>(3);
    Node<Integer> n9 = new Node<Integer>(2);
    Node<Integer> n10 = new Node<Integer>(1);
    n1.next = n2; n2.next = n3; n3.next = n4; n4.next=n5; n5.next = n6; n6.next =n7; n7.next=n8; n8.next=n9;n9.next=n10;
    return n1;
  }
  public static void main(String[] args){
    System.out.println(Question04.partition(createList(), 5));
    System.out.println(Question04.partition(createList(), 1));
    System.out.println(Question04.partition(createList(), 0));
    System.out.println(Question04.partition(createList(), 10));
    System.out.println(Question04.partition(createList(), 11));
  }
  public static Node<Integer> partition(Node<Integer> node, int x){
    Node<Integer> s1 = null, s2=null, e1=null, e2=null;
    while(node!=null){
      Node<Integer> next = node.next;
      node.next = null;
      if(node.val<x){
        if(s1==null){
          s1 = node;
          s2 = node;
        } else {
          s2.next = node;
          s2 = node;
        }
      } else {
        if(e1==null){
          e1 = node;
          e2 = node;
        } else {
          e2.next = node;
          e2 = node;
        }
      }
      node = next;
    }
    if(s2!=null)
      s2.next = e1;
    return (s1==null)?e1:s1;
  }
}
