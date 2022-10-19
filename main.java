import java.io.*;
import java.util.*;

public class main {
   public static void main(String[] args) {
	   CharQueueWithMinImpl A = new CharQueueWithMinImpl();
	   
	   boolean x=A.isEmpty();
	   System.out.println(x);
	   
	  
	   A.put('A');
	   A.put('B');
	   A.put('C');
	   A.put('D');
	   A.put('D');
	   A.put('B');
	   A.put('P');
	   A.put('V');
	   A.put('V');
	   
	   
	   x=A.isEmpty();
	   System.out.println(x);
	   
	   A.printQueue(System.out);
	   System.out.println(A.get());
	   System.out.println();
	   System.out.println(A.get());
	   System.out.println();
	   System.out.println(A.get());
	   System.out.println();
	   A.printQueue(System.out);
	   System.out.println(A.size());
	   System.out.println(A.min());
   }
}