/*
implement a function that sort stack using only one additional stack and
operations: push, pop, peek, isEmpty
*/
import java.util.*;
public class Question06{
  public static void main(String[] args){
    Stack<Integer> s = new Stack<Integer>();
    s.push(5);
    s.push(3);
    s.push(8);
    s.push(9);
    s.push(1);
    s.push(2);
    s.push(4);
    s.push(6);
    s.push(10);
    Question06 q = new Question06();
    q.sort(s);
    while(!s.isEmpty()){
      System.out.println(s.pop());
    }
  }

  public void sort(Stack<Integer> stack){
    Stack<Integer> buffer = new Stack<Integer>();
    while(!stack.isEmpty()){
      Integer element = stack.pop();
      while(!buffer.isEmpty() && buffer.peek()<element){
        stack.push(buffer.pop());
      }
      buffer.push(element);
    }
    while(!buffer.isEmpty()){
      stack.push(buffer.pop());
    }
  }
}
