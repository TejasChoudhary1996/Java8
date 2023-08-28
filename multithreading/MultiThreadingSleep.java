package multithreading;

public class MultiThreadingSleep {
	public static void main(String args[])
	{
		Print2 p1=new Print2();
		p1.start();
		
		Print2 p2=new Print2();
		p2.start();
		
	}
}

class Print2 extends Thread{

public void run() {
	for(int i=0;i<5;i++) {
		System.out.println("Hello"+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}