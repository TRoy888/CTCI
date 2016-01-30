/*
Write code to remove duplicates from an unsorted linkedlist
*/

import java.util.*;
public class Question01<T>{

	public static void main(String[] args){
		Question01<Character> q1= new Question01<Character>();
		LinkedList<Character> l1 = new LinkedList<Character>();
		l1.add('F');l1.add('O');l1.add('L');l1.add('L');l1.add('O');l1.add('W');l1.add('U');l1.add('P');
		Node<Character> first = q1.createList(l1);
		System.out.println(Question01.removeDuplicate01(l1));
		Node<Character> r = q1.removeDuplicate02(first);
		System.out.println(r);
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

	public static List<Character> removeDuplicate01(List<Character> list){
		HashSet<Character> map = new HashSet<Character>();
		for(int i=0;i<list.size();i++){
			char c = list.get(i);
			if(map.contains(c)){
				list.remove(i);
				i--;
			}
			map.add(c);
		}
		return list;
	}

	public Node<T> removeDuplicate02(Node<T> first){
		HashSet<T> map = new HashSet<T>();
		Node<T> c = first;
		Node<T> p = first;
		while(c!=null){
			if(map.contains(c.val)){
				p.next = c.next;
			} else {
				map.add(c.val);
				p = c;
			}
			c = p.next;
		}
		return first;
	}
}
