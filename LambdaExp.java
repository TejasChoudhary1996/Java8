
public class LambdaExp {

   public static void main(String[] args) {  
        
        // Multiple parameters in lambda expression  
        Addable ad1=(a,b)->{ return a+b; };  
        System.out.println(ad1.add(10,20));  
          
        // Multiple parameters with data type in lambda expression  
        Addable ad2=(int a,int b)->(a+b);  
        System.out.println(ad2.add(100,200));  
        
        Addable ad3=new Addable() {
        	@Override
        	public int add(int a,int b)
        	{
        		return a+b;
        	}
        };
       System.out.println(ad3.add(400, 500));
        Sayable s1=(name)->(  
             "Hello, "+name
        );  
        System.out.println(s1.say("Sonoo"));           
    }
	public void printnMsg(){
		System.out.println("Hello, this is instance method");
	}
	/*public static void main(String[] args) {
		Thread t1=new Thread(new LambdaExp()::printnMsg);
		Thread t2=new Thread(new LambdaExp()::printnMsg);
        t2.start();	t1.start();		
	}*/
}
 interface Addable{
	public int add(int a,int b);
}

interface Sayable{
	public String say(String name);  
}