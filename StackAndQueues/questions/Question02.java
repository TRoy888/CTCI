/*
Design a stack which, in addition to push and pop,
also has a function min which return the minimum element?
Push, pop and min should all operate in O(1) time.
*/

import java.util.*;
public class Question02{
  public static void main(String[] args){
    MyStack<Integer> m = new MyStack<Integer>();
    m.push(1);
    m.push(2);
    m.push(3);
    m.push(0);
    m.push(4);
    m.push(5);
    System.out.println(m.min());
    System.out.println(m.pop());
    System.out.println(m.min());
    System.out.println(m.pop());
    System.out.println(m.pop());
    System.out.println(m.min());
  }
  static class MyStack<T extends Comparable<T>>{
    class MinStackData<T>{
      int index;
      T value;
      public MinStackData(int index, T value){
        this.index = index;
        this.value = value;
      }
    }
    Stack<T> stack = new Stack<T>();
    Stack<MinStackData<T>> minStack = new Stack<MinStackData<T>>();
    public void push(T value){
      if(stack.isEmpty() || minStack.peek().value.compareTo(value)>0){
        minStack.push(new MinStackData<T>(stack.size(), value));
      }
      stack.push(value);
    }
    public T pop(){
      T r = stack.pop();
      if(stack.size()==minStack.peek().index){
        minStack.pop();
      }
      return r;
    }
    public T min(){
      return minStack.peek().value;
    }
  }
}
