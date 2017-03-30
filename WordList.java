
public class WordList {
	private int length;
	private WordNode first;
	private WordNode last;
	private WordNode current;
	
	public WordList () {
		WordNode headNode = new WordNode();
		length = 0;
		first = headNode;
		last = headNode;
	}
	
	public void append (WordNode x) {
		last.next = x;
		last = x;
		length++;
	}
	
	public void prepend (WordNode x) {
		x.next = first.next;
		first.next = x;
		length++;		
	}
	
	public void insert (WordNode x) {
		if(length==0) {
			append(x);
			return;
		}
		WordNode c = new WordNode ();
		c = first.next;
		while(c.next!=null && x.data.getWord().compareToIgnoreCase(c.next.data.getWord())>0) { // moves through the list until x is lexicographically smaller or equal to c.next
			c=c.next;
		}
		x.next  = c.next;
		c.next = x;
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
