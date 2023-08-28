package multithreading;

public class MultiThreadingExample {
	public static void main(String args[])
	{
		Print p1=new Print();
		p1.start();
		Print p2=new Print();
		p2.start();
	}
}

class Print extends Thread{

public void run() {
	for(int i=0;i<5;i++)
		System.out.println("Hello"+i);
}
}