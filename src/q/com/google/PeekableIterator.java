package q.com.google;

import java.util.Iterator;

public class PeekableIterator<T> implements Iterator<T> {

	Iterator<T> itr_;
	T top_;

	public PeekableIterator(Iterator<T> itr) {
		itr_ = itr;
		getTop();
	}

	public boolean hasNext() {
		return top_ != null;
	}

	public T next() {
		T tmp = top_;
		getTop();

		return tmp;
	}

	public void remove() {
	
	}

	private void getTop() {
		if (itr_ != null && itr_.hasNext())
			top_ = itr_.next();
		else
			top_ = null;
	}

}
