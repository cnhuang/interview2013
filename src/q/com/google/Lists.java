package q.com.google;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import util.Question;

/**
 * "http://www.careercup.com/question?id=17727664";
 * 
 * @author edhuang
 * 
 */

public class Lists<T> implements Iterable<T> {

	public static void main(String[] argus) {

		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		lists.add(null);
		lists.add(new LinkedList<Integer>());
		lists.add(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		lists.add(Arrays.asList(new Integer[] { 5, 6, 7, 8 }));
		lists.add(null);
		lists.add(new LinkedList<Integer>());
		lists.add(Arrays.asList(new Integer[] { 5, 6, 7, 8 }));

		Lists<Integer> test = new Lists<Integer>(lists);
		Iterator<Integer> iterator = test.iterator();

		while (iterator.hasNext()) {

			System.out.println(iterator.next());
		}
	}

	private List<List<T>> lists;

	public Lists(List<List<T>> lists) {
		this.lists = lists;
	}

	public Iterator<T> iterator() {
		return new ListsIterator(lists);
	}

	public class ListsIterator implements Iterator<T> {

		private Iterator<List<T>> listsIter = null;
		private Iterator<T> listIter = null;

		public ListsIterator(List<List<T>> lists) {

			if (lists != null)
				listsIter = lists.iterator();
		}

		private Iterator<T> getIterator() {

			if (listsIter == null)
				return null;

			if (listIter != null && listIter.hasNext())
				return listIter;
			else
				listIter = null;

			while (listsIter.hasNext()) {

				List<T> list = listsIter.next();

				if (list != null) {
					listIter = list.iterator();

					if (listIter.hasNext())
						return listIter;
					else {
						listIter = null;
					}
				}
			}

			return null;

		}

		public boolean hasNext() {

			if (getIterator() == null)
				return false;

			return getIterator().hasNext();
		}

		public T next() {

			if (getIterator() == null)
				throw new NoSuchElementException();

			return getIterator().next();

		}

		public void remove() {

			if (getIterator() == null)
				throw new NoSuchElementException();

			getIterator().remove();

		}

	}

}