/*
implment a SetOfStacks class.
The class must start a new stack if the element in a stack exceed a threshold.
All operations in the SetOfStacks shluld behave identically as if there is only one stack.

FOLLOW UP
implement a function popAt(int index) which performs a pop operation on a specific stack.
*/
import java.util.*;
public class Question03{
  public static void main(String[] args){
    SetOfStacks<Integer> ss = new SetOfStacks<Integer>(2);
    ss.push(1);
    ss.push(2);
    ss.push(3);
    ss.push(4);
    ss.push(5);
    ss.push(6);
    System.out.println(ss.pop());
    System.out.println(ss.popAt(0));
    System.out.println(ss.popAt(0));
    System.out.println(ss.popAt(1));
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
  }
  static class SetOfStacks<T>{
    int threshold;
    ArrayList<Stack<T>> list = new ArrayList<Stack<T>>();
    public SetOfStacks(int threshold){
      this.threshold = threshold;
    }
    public void push(T value){
      if(list.size()==0 || list.get(list.size()-1).size()>=this.threshold){
        list.add(new Stack<T>());
      }
      list.get(list.size()-1).push(value);
    }
    public T pop(){
      while(true){
        if(list.size()==0)
          return null;
        if(list.get(list.size()-1).size()==0){
          list.remove(list.size()-1);
          continue;
        }
        return list.get(list.size()-1).pop();
      }
    }
    public T popAt(int index){
      if(list.size()<=index || list.get(index).size()==0)
        return null;
      return list.get(index).pop();
    }
  }
}
