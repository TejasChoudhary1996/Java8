package multithreading;

public class MultiThreadingJoin {

	public static void main(String args[])
	{
		Print p1=new Print();
		p1.start();
		try {
			p1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Print p2=new Print();
		p2.start();
		
	}

}
