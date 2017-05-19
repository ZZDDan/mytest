 package com.rxx.arithmetic;

import java.util.Currency;

import org.junit.Test;

/**
 * @Title      :LinkTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月17日 下午4:26:23
 */
class Link{
	
	public int iData;
	public double dDate;
	public Link next;
	public Link(int iData, double dDate) {
		super();
		this.iData = iData;
		this.dDate = dDate;
	}
	
	public void displayLink(){
		System.out.println("{" + iData + "," + dDate + "}");
	}
}

class LinkOrderList{
	private Link first;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void add(Link link){
		if(first == null){
			first = link;
			return;
		}
		
		Link previous = null;
		Link current = first;
		while(current != null){
			if(link.iData < current.iData){
				link.next = current;
				if(previous == null){
					first = link;
				}else{    
					previous.next = link;
				}
				return;
			}
			
			previous = current;
			current = current.next;
		}
		
		previous.next = link;
		
	}
	
	public Link removeFirst(){
		Link tmp = first;
		first = first.next;
		return tmp;
	}
	
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
	}
	
	public Link find(int key){
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public Link remove(int key){
		Link frontCurrent = null;
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				if(frontCurrent != null){
					frontCurrent.next = current.next;
				}
				return current;
			}
			frontCurrent = current;
			current = current.next;
		}
		return null;
	}
}


class FirstLastLinkList{
	private Link first;
	private Link last;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void addFirst(Link link){
		link.next = first;
		first = link;
		if(last == null){
			last = link;
		}
		
	}
	
	public void addLast(Link link){
		if(first == null){
			first = link;
		}
		last.next = link;
		last = link;
	}
	
	public Link removeFirst(){
		Link tmp = first;
		first = first.next;
		return tmp;
	}
		
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
	}
	
	public Link find(int key){
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public Link remove(int key){
		Link frontCurrent = null;
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				if(frontCurrent != null){
					frontCurrent.next = current.next;
				}
				return current;
			}
			frontCurrent = current;
			current = current.next;
		}
		return null;
	}
}

class LinkList{
	private Link first;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void addFirst(Link first){
		first.next = this.first;
		this.first = first;
	}
	
	public Link removeFirst(){
		Link tmp = first;
		first = first.next;
		return tmp;
	}
	
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
	}
	
	public Link find(int key){
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public Link remove(int key){
		Link frontCurrent = null;
		Link current = first;
		while(current != null){
			if(current.iData == key || current.dDate == key){
				if(frontCurrent != null){
					frontCurrent.next = current.next;
				}
				return current;
			}
			frontCurrent = current;
			current = current.next;
		}
		return null;
	}
}

class DoubleLink{
	public int iData;
	public DoubleLink next;
	public DoubleLink previous;
	public DoubleLink(int iData) {
		super();
		this.iData = iData;
	}
	
	public void displayLink(){
		System.out.println("{" + iData + "}");;
	}
}

class DoubleLinkList{
	private DoubleLink first;
	private DoubleLink last;
	public void addFirst(DoubleLink link){
		if(first == null){
			first = link;
			last = link;
		}else{
			link.next = first;
			first.previous = link;
			first = link;
		}
	}
	public void addLast(DoubleLink link){
		if (last == null) {
			first = link;
			last = link;
		}else{
			last.next = link;
			link.previous = last;
			last = link;
		}
	}
	public void addAfter(int key, DoubleLink link){
		DoubleLink cunrrent = first;
		while(cunrrent != null){
			if(cunrrent.iData == key){
				link.previous = cunrrent;
				link.next = cunrrent.next;
				cunrrent.next = link;
				return ;
			}
			cunrrent = cunrrent.next;
		}
		addLast(link);
	}
	public DoubleLink removeFirst(){
		DoubleLink tmp = first;
		first = first.next;
		return tmp;
	}
	public DoubleLink removeLast(){
		DoubleLink tmp = last;
		last = last.previous;
		last.next = null;
		return tmp;
	}
	public DoubleLink find(DoubleLink link){
		DoubleLink cunrrent = first;
		while(cunrrent != null){
			if(cunrrent.iData == link.iData){
				return cunrrent;
			}
		}
		return null;
	}
	public void displayList(){
		DoubleLink cunrrent = first;
		while(cunrrent != null){
			cunrrent.displayLink();
			cunrrent = cunrrent.next;
		}
	}
	
}

public class LinkTest {
	
	@Test
	public void testDoubleLinkList(){
		DoubleLinkList linkList = new DoubleLinkList();
		linkList.addFirst(new DoubleLink(1));
		linkList.addFirst(new DoubleLink(3));
		linkList.addLast(new DoubleLink(2));
		linkList.addAfter(2, new DoubleLink(3));
		linkList.displayList();
		System.out.println("-------------------------");
		
		linkList.removeFirst().displayLink();
		linkList.removeLast().displayLink();
	}
	
	@Test
	public void testLinkOrderList(){
		LinkOrderList linkList = new LinkOrderList();
		linkList.add(new Link(1, 1.1));
		linkList.add(new Link(3, 3.3));
		linkList.add(new Link(2, 2.2));
		linkList.displayList();
		System.out.println("-------------------------");
		
		linkList.find(2).displayLink();
		linkList.remove(2).displayLink();
		
		System.out.println("-------------------------");
		
		linkList.removeFirst().displayLink();
		linkList.removeFirst().displayLink();
	}

	@Test
	public void testFirstLastLink(){
		FirstLastLinkList linkList = new FirstLastLinkList();
		linkList.addFirst(new Link(1, 1.1));
		linkList.addLast(new Link(2, 2.2));
		linkList.addFirst(new Link(3, 3.3));
		linkList.displayList();
		System.out.println("-------------------------");
		
		linkList.find(2).displayLink();
		linkList.remove(2).displayLink();
		
		System.out.println("-------------------------");
		
		linkList.removeFirst().displayLink();
		linkList.removeFirst().displayLink();
	}

	@Test
	public void testLink(){
		LinkList linkList = new LinkList();
		linkList.addFirst(new Link(1, 1.1));
		linkList.addFirst(new Link(2, 2.2));
		linkList.addFirst(new Link(3, 3.3));
		linkList.displayList();
		System.out.println("-------------------------");
		
		linkList.find(2).displayLink();
		linkList.remove(2).displayLink();
		
		System.out.println("-------------------------");
		
		linkList.removeFirst().displayLink();
		linkList.removeFirst().displayLink();
	}
}
