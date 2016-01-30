/*
Implement an algorithm to delete a node in a singly linked list, given only access to that node.
EX:
Input: node c in a->b->c->d->e
Output: a->b->d->e
*/
public class Question03<T>{
  public static void main(String[] s){
    Node<Character> n1 = new Node<Character>('a');
    Node<Character> n2 = new Node<Character>('b');
    Node<Character> n3 = new Node<Character>('c');
    Node<Character> n4 = new Node<Character>('d');
    Node<Character> n5 = new Node<Character>('e');
    n1.next= n2; n2.next= n3; n3.next=n4; n4.next= n5;
    Question03<Character> q3 = new Question03<Character>();
    q3.removeNode(n3);
    System.out.println(n1);
  }
  public void removeNode(Node<T> nodeToBeDeleted){
    if(nodeToBeDeleted.next!=null){
      nodeToBeDeleted.val = nodeToBeDeleted.next.val;
      nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }
  }
}
