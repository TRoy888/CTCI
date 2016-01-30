/*
You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers and return the sum as a linked list.
Example:
input (7->1->6) + (5->9->2) = 617+295 = 912
output (2->1->9)

FollowUp: numbers are stored in forward order
input (6->1->7) + (2->9->5) = 617+295 = 912
output (9->1->2)
*/

public class Question05{
  public static void main(String[] args){
    Node<Integer> n11 =new Node<Integer>(7);
    Node<Integer> n12 =new Node<Integer>(1);
    Node<Integer> n13 =new Node<Integer>(6);
    Node<Integer> n14 =new Node<Integer>(1);
    n11.next = n12; n12.next = n13; n13.next=n14;
    Node<Integer> n21 = new Node<Integer>(5);
    Node<Integer> n22 =new Node<Integer>(9);
    Node<Integer> n23 =new Node<Integer>(3);
    n21.next = n22; n22.next = n23;
    System.out.println(addBackward(n11, n21));

    Node<Integer> m11 =new Node<Integer>(6);
    Node<Integer> m12 =new Node<Integer>(1);
    Node<Integer> m13 =new Node<Integer>(7);
    m11.next = m12; m12.next = m13;
    Node<Integer> m21 = new Node<Integer>(3);
    Node<Integer> m22 =new Node<Integer>(9);
    Node<Integer> m23 =new Node<Integer>(5);
    m21.next = m22; m22.next = m23;
    System.out.println(addForward(m11, m21));
  }

  public static Node<Integer> addBackward(Node<Integer> n1, Node<Integer> n2){
    int carrier = 0;
    Node<Integer> dummy = new Node<Integer>(0);
    Node<Integer> next = dummy;
    while(n1!=null && n2!=null){
      int tmp = (n1.val+n2.val)+carrier;
      int val = tmp%10;
      Node<Integer> node = new Node<Integer>(val);
      carrier = tmp/10;
      next.next = node;
      next = node;
      n1 = n1.next;
      n2 = n2.next;
    }
    next.next = (n1==null)?n2:n1;
    if(next.next!=null){
      next=next.next;
      while(next!=null && carrier>0){
        next.val+=carrier;
        carrier=next.val/10;
        next.val%=10;
      }
    }
    if(carrier!=0){
      next.next = new Node<Integer>(carrier);
    }
    return dummy.next;
  }

  public static Node<Integer> addForward(Node<Integer> n1, Node<Integer> n2){
    Node<Integer> n1R = reverseList(n1);
    Node<Integer> n2R = reverseList(n2);
    return reverseList(addBackward(n1R, n2R));
  }

  public static Node<Integer> reverseList(Node<Integer> head){
    if(head==null || head.next==null){
      return head;
    }
    Node<Integer> h = head;
    Node<Integer> nextH = head.next;
    Node<Integer> newH = reverseList(nextH);
    h.next=null;
    nextH.next = h;
    return newH;
  }
}
