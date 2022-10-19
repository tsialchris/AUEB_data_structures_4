import java.io.*;
import java.util.*;

public class CharQueueWithMinImpl implements CharQueueWithMin
{
	private int added_objects;
	private String name; 
	private char min;
	
	///////////////////////////////////////
	CharQueueImpl F = new CharQueueImpl();
	CharDoubleEndedQueueImpl D = new CharDoubleEndedQueueImpl();
	///////////////////////////////////////
	
	public CharQueueWithMinImpl()
	{
		this("Char Queue");
	} 
	
	public CharQueueWithMinImpl( String listName)
	{
		name = listName;
	} 
	
	
	public void put( char insertChar )
	{
		//////////////////////////////////////////////////////////
		F.put(insertChar);
		boolean detector1 = false;
		if(D.isEmpty()){
			D.addFirst(insertChar);
			min = insertChar;
		}
		else{
			ListNode current = D.start;
			while(current != null){
				if(insertChar == current.getchar()){
					detector1 = true;
					current.counter++;//we count how many times we have seen this element
				}
				
				current = current.next;
			}
			if(!detector1){
				D.addFirst(insertChar);
			}
			if(min > insertChar){
				min = insertChar;
			}
		}
		added_objects++;
		//////////////////////////////////////////////////////////
	}

	//return and remove oldest item
	
	public char get() throws EmptyListException
	{
		min = '\uFFFF'; //assigning to min the highest char value
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );
		//////////////////////////////////////////////////////////
		char removedItem = F.start.getchar();
		boolean detector = false;//we detect if we have read the removedItem in the queue, in order to remove ignore
		ListNode current = D.start;
		while(current != null){
			if(current.ignore == false){
				if(removedItem == current.getchar()){
					if(!detector){
						detector = true;
						current.counter--;
						if(current.counter == 0){
							current.ignore = true;
						}
					}
				}
			}
			current = current.next;
		}
		if(D.start.ignore == true){
			D.removeFirst();
		}
		else if(D.end.ignore == true){
			D.removeLast();
		}
		current = D.start;
		while(current != null){
			if(!current.ignore){
				if( min > current.getchar()){
					min = current.getchar();
				}
			}
			current = current.next;
		}
		added_objects--;
		
		return F.get();
	}
	//////////////////////////////////////////////////////////
	
	//return without deleting
	
	public char peek()
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		D.getFirst();
		return F.peek();
	} 	
	
	
	public boolean isEmpty()
	{
		if(added_objects == 0){
			return true;
		}
		return false;
	}
	
	
	public void printQueue(PrintStream stream)
	{
		F.printQueue(System.out);
	} 
	
	public int size(){
		return added_objects;
	}
	
	public char min(){
		return min;
	}
}