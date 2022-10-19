
class ListNode
{
	int counter = 0;
	boolean ignore = false;
	char char1;
	ListNode next;
	ListNode prev;

	
	ListNode( char char1 )
	{
		this( char1, null, null );
	} 
	

	ListNode( char char1, ListNode next1, ListNode prev1 )
	{
		this.char1 = char1;
		next = next1;
		prev = prev1;
		counter++;
	}

	char getchar()
	
	{
		return char1; 
	}
	
} 