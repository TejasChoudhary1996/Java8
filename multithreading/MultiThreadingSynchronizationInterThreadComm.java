package multithreading;

import javax.net.ssl.SSLEngineResult.Status;

public class MultiThreadingSynchronizationInterThreadComm {
	public static void main(String args[])
	{
		Message2 m=new Message2();
		Print5 p1=new Print5(m);
		p1.start();
		Print6 p2=new Print6(m);
		p2.start();
		
		
	}
}

class Print5 extends Thread{
	Message2 m=null;
	Print5(Message2 m){
		this.m=m;
	}

public void run() {
for(int i=5;i<8;i++) {
	m.printMessage("thread"+i);
	
}
}
}
	class Print6 extends Thread{
		Message2 m=null;
		Print6(Message2 m){
			this.m=m;
		}
	
public void run() {
	for(int i=0;i<2;i++) {
		m.printMessage("thread2");
		
	}
}
}
class Message2{
	public synchronized void printMessage(String msg) {
		if("thread7".equals(msg) )
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		if("thread2".equals(msg) || "thread2".equals(msg))
				notifyAll();
			
		System.out.println("Thread name -- "+msg);;
		
	}
}