/** The WordList abstract class forms the basis for a linked list, either of class UnsortedList or SortedList */
public abstract class WordList {
	protected int length;
	protected WordNode first;
	protected WordNode last;
	private WordNode current;
	
	public WordList () {
		WordNode headNode = new WordNode();
		length = 0;
		first = headNode;
		last = headNode;
}	
	
	public void prepend (WordNode x) {
		x.next = first.next;
		first.next = x;
		length++;		
	}
	
	public void resetList () { // iterator reset
		current = first.next;
	}
	
	public Word nextWord () { // iterator
		WordNode toReturn = new WordNode();
		toReturn = current;
		current = current.next;
		return toReturn.data;
	}

	public int getListLength () {
		return length;
	}
}
