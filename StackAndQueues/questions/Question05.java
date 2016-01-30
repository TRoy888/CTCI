/*
implement Queue using two stacks.
*/
import java.util.*;
public class Question05{
  public static void main(String[] args){
    MyQueue<Integer> m = new MyQueue<Integer>();
    m.enQueue(1);
    m.enQueue(2);
    m.enQueue(3);
    m.enQueue(4);
    m.enQueue(5);
    System.out.println(m.deQueue());
    m.enQueue(6);
    m.enQueue(7);
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    System.out.println(m.deQueue());
    m.enQueue(8);
    System.out.println(m.deQueue());
  }
  static class MyQueue<T>{
    private Stack<T> in = new Stack<T>();
    private Stack<T> out = new Stack<T>();
    public boolean enQueue(T v){
      System.out.println("Enqueue:"+v);
      while(out.size()!=0){
        in.push(out.pop());
      }
      in.push(v);
      return true;
    }
    public T deQueue(){
      while(in.size()!=0){
        out.push(in.pop());
      }
      if(out.isEmpty())
        return null;
      return out.pop();
    }
  }
}
