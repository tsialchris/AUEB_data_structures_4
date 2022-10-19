import java.io.*;
import java.util.*;

public class CharDoubleEndedQueueImpl implements CharDoubleEndedQueue
{
	public int added_objects = 0;
	public ListNode start;
	public ListNode end;
	public String name;
	//double constructor//
	public CharDoubleEndedQueueImpl()
	{
		this("Char Queue");
	} 
	
	public CharDoubleEndedQueueImpl( String listName)
	{
		name = listName;
		start = end = null;
	} 
	//double constructor//
	
	//add to the end of the list
	public void addLast( char insertChar )
	{
		ListNode node = new ListNode( insertChar );
		if ( isEmpty() ) 
		start = end = node;
		else { 
			node.prev = end; //we define the new end in accordance with the old one
			end.next = node;
			end = node;
		}
		added_objects++;
	} 
	
	//add to the start of the list
	public void addFirst( char insertChar )
	{
		ListNode node = new ListNode( insertChar );
		if ( isEmpty() )
		start = end = node;
		else { 
			start.prev = node; //we define the new start in accordance with the old one
			node.next = start;
			start = node;
		}
		added_objects++;
	}

	
	public char removeFirst() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char removedItem = start.getchar();

		if ( start == end )
		start = end = null;
		else
		start = start.next;

		added_objects--;
		return removedItem;
	}
	public char removeLast() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char removedItem = end.getchar();

		if ( start == end )
		start = end = null;
		else{
			end = end.prev; //new end is the prev of the old end and the nxt of the new end is made null
			end.next = null;
		}

		added_objects--;
		return removedItem;
	}
	
	//return without deleting
	
	public char getFirst()
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char peekedItem = start.getchar(); 

		return peekedItem; 
	} 	
	public char getLast()
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		char peekedItem = end.getchar(); 

		return peekedItem; 
	}
	

	
	public boolean isEmpty()
	{
		return start == null;
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