/*
Given a circular linked list, implment an algorithm which returns the node at the beginning of the loops
Ex:
input: A->B->C->D->E-C
output: C
*/
import java.util.*;
public class Question06{
  public static void main(String[] args){
    Node<Character> c1 = new Node<Character>('A');
    Node<Character> c2 = new Node<Character>('B');
    Node<Character> c3 = new Node<Character>('C');
    Node<Character> c4 = new Node<Character>('D');
    Node<Character> c5 = new Node<Character>('E');
    c1.next = c2; c2.next=c3;c3.next=c4; c4.next=c5; c5.next=c3;
    Node<Character> result = findLoopFirstElement(c1);
    System.out.println(((result!=null)?result.val:null));

    result = findLoopFirstElementTortoiseAndHare(c1);
    System.out.println(((result!=null)?result.val:null));
  }

  public static Node<Character> findLoopFirstElement(Node<Character> node){
    HashMap<Character, Node<Character>> map =new HashMap<Character,Node<Character>>();
    Node<Character> tmp = node;
    while(tmp!=null){
      if(map.containsKey(tmp.val)){
        return map.get(tmp.val);
      }
      map.put(tmp.val, tmp);
      tmp = tmp.next;
    }
    return null;
  }

  public static Node<Character> findLoopFirstElementTortoiseAndHare(Node<Character> node){
    Node<Character> p1 = node;
    Node<Character> p2 = node;
    while(p2!=null && p2.next!=null){
      p1 = p1.next;
      p2 = p2.next.next;
      if(p1==p2){
        break;
      }
    }
    if(p2==null && p2.next == null){
      return null;
    }
    p1 = node;
    while(p1!=p2){
      p1=p1.next;
      p2=p2.next;
    }
    return p1;
  }
}
