package interview2013.questions.linkedlist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import interview2013.util.Question;
import interview2013.util.ds.Node;

public class Reverse extends Question {
	
	@Override
	public String getQuestion() {
		return "Reverse a linkedlist";
	}

	@Test(dataProvider = "TestCases")
	public void resolve(Node<Integer> node) {
		Log("Original list:" + node);
		
		if(node != null){
			
			Node<Integer> pre = null;
			Node<Integer> cur = node;
			
			while(cur != null){
				Node<Integer> next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			
			node = pre;
		}

		Log("Reversed list:" + node);
	}

	@SuppressWarnings("unchecked")
	@DataProvider(name = "TestCases")
	public static Node<Integer>[][] TestCases() {
		return new Node[][] { { null }, { Node.Create(new Integer[] { 1 }) },
				{ Node.Create(new Integer[] { 1, 2 }) },
				{ Node.Create(new Integer[] { 1, 2, 3, 4, 5 }) } };
	}
}
