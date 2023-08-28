package multithreading;

import javax.net.ssl.SSLEngineResult.Status;

public class MultiThreadingSynchronization {
	public static void main(String args[])
	{
		Message m=new Message();
		Print3 p1=new Print3(m);
		p1.start();
		Print4 p2=new Print4(m);
		p2.start();
		
		
	}
}

class Print3 extends Thread{
	Message m=null;
	Print3(Message m){
		this.m=m;
	}

public void run() {
for(int i=0;i<2;i++) {
	m.printMessage("thread1");
	
}
}
}
	class Print4 extends Thread{
		Message m=null;
		Print4(Message m){
			this.m=m;
		}
	
public void run() {
	for(int i=0;i<2;i++) {
		m.printMessage("thread2");
		
	}
}
}
class Message{
	public synchronized void printMessage(String msg) {
		System.out.println(msg);;
	}
}