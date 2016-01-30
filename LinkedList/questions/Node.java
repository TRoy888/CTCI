public class Node<T>{
  T val;
  Node<T> next;
  public Node(T val){
    this.val = val;
  }
  public String toString(){
    Node<T> tmp = this;
    StringBuilder s = new StringBuilder();
    s.append(tmp.val);
    tmp = tmp.next;
    while(tmp!=null){
      s.append(", ");
      s.append(tmp.val);
      tmp = tmp.next;
    }
    return s.toString();
  }
}
