import java.io.*;
import java.util.*;

public class CharQueueImpl implements CharQueue
{
	public int added_objects = 0;
	public ListNode start;
	public ListNode end;
	public String name; 
	
	public CharQueueImpl()
	{
		this("Char Queue");
	} 
	
	public CharQueueImpl( String listName)
	{
		name = listName;
		start = end = null;
	} 
	
	
	public void put( char insertChar )
	{
		ListNode node = new ListNode( insertChar );
		if ( isEmpty() ) // start and end refer to same Object
		start = end = node;
		else { // end's next refers to new node
			end.next = node;
			end = node;
			//you can replace the two previous lines with this line: end = end.next = new ListNode( insertItem );
		}
		added_objects++;
	} 

	//return and remove oldest item
	
	public char get() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char removedItem = start.getchar(); // retrieve data being removed

		// update references start and end
		if ( start == end )
		start = end = null;
		else
		start = start.next;

		added_objects--;
		return removedItem; // return removed node data
	}
	
	//return without deleting
	
	public char peek()
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char peekedItem = start.getchar(); // retrieve data being removed

		return peekedItem; // return removed node data
	} 	
	
	
	public boolean isEmpty()
	{
		return start == null; // return true if List is empty
	}
	
	
	public void printQueue(PrintStream stream)
	{
		if ( isEmpty() )
		{
			System.out.printf( "Empty %s\n", name );
			return;
		}

		System.out.printf( "The %s is: ", name );
		ListNode current = start;

		// while not at end of list, output current node's data
		while ( current != null )
		{
			System.out.printf( "%s ", current.getchar() );
			current = current.next;
		}

		System.out.println( "\n" );
	} 
	
	public int size(){
		return added_objects;
	}
} 