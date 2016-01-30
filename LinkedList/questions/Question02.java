/*
Implement an algorithm to find the kth to the last element of a singly linked list.
*/
import java.util.*;
public class Question02<T>{
  public static void main(String[] args){
    Question02<Integer> q2 = new Question02<Integer>();
    ArrayList<Integer> l = new ArrayList<Integer>();
    for(int i=1;i<=100;i++){
      l.add(i);
    }
    Node<Integer> input = q2.createList(l);
    System.out.println(q2.findKthToTheLast(input, 90));
  }

  public Node<T> createList(List<T> list){
		Node<T> first = new Node<T>(null);
		Node<T> tmp = first;
		for(T c:list){
			Node<T> next = new Node<T>(c);
			tmp.next = next;
			tmp = tmp.next;
		}
		return first.next;
	}

  public T findKthToTheLast(Node<T> first, int k){
    if(k<=0)
      return null;
    int count = 0;
    Node c = first;
    while(c!=null){
      count++;
      c=c.next;
      if(count == k){
        break;
      }
    }
    if(c==null && count<k)
      return null;
    Node<T> result = first;
    while(c!=null){
      c=c.next;
      result=result.next;
    }
    return result.val;
  }
}
