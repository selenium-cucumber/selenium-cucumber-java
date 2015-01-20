package sc_java_methods;

class TestCaseFailed extends Exception 
{
	String message=null;
	public TestCaseFailed() 
	{
		super();
	}
	 
	public TestCaseFailed(String message) 
	{
	    super(message);
	    this.message = message;
	}
	 
}

public class miscMethods 
{

}
