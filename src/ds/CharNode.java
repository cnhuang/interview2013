package ds;

import java.util.HashMap;
import java.util.Map;

public class CharNode {

	Map<String, CharNode> childrend;
	char data;

	public CharNode() {
		childrend = new HashMap<String, CharNode>();
	}
	
	public CharNode(char data) {
		this.data = data;
		childrend = new HashMap<String, CharNode>();
	}

	public char getDate() {
		return data;
	}

	public void setDate(char data) {
		this.data = data;
	}

	public void setChild(char c, CharNode node) {
		childrend.put(String.valueOf(c), node);
	}

	public CharNode getChild(char c) {
		return childrend.get(String.valueOf(c));
	}
}
