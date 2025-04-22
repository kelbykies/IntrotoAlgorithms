
public class Static_variables
{
	class Program 
	{
	    	static int n = 10;
	    	static void Foo() 
	    	{
	        int m = n;
			int n = 20;
	        	System.out.println(m);
		}
		
		static void Main(String[] args) 
		{
		   Foo();
		} 
	}


}
