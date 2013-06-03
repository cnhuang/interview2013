package ds;

public class Pair<T> {
	public T Value1;
	public T Value2;

	public Pair(T value1, T value2) {
		Value1 = value1;
		Value2 = value2;
	}

	public String toString() {
		return "(" + Value1 + "," + Value2 + ")";
	}
}