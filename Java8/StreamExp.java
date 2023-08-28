package Java8;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExp {
	public static void main(String args[]) {
		List<Integer> lstNum=new ArrayList<Integer>();
		
		lstNum.add(12);
		lstNum.add(9);
		lstNum.add(13);
		lstNum.add(4);
		lstNum.add(6);
		lstNum.add(2);
		lstNum.add(4);
		lstNum.add(12);
		lstNum.add(15);
		
		lstNum.stream().forEach(StreamExp::print);   // :: method reference   , stream converts collection to stream
		lstNum.stream().forEach(System.out::println); 
		lstNum.stream().filter(num->num	%2==0).forEach(System.out::println);    // Filter and Lambda expression
		lstNum.stream().filter(num->num	%2==0).map(num->num*num).forEach(System.out::println);    // Map perform  operation on stream
		System.out.println("Sum="+lstNum.stream().filter(num->num	%2==0).reduce(0,StreamExp::sum));    // reduce -- Many input single output Accumulation function
		System.out.println("Sum="+lstNum.stream().filter(num->num	%2==0).reduce(0,(x,y)-> x+y));    // reduce -- Many input single output Accumulation function
		System.out.println("Sum="+lstNum.stream().reduce(0,(x,y)-> x+y*y));
		lstNum.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);;
		List<Integer> lst2 = lstNum.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(lst2);
		
		
		lstNum.stream().
		filter(num->num	%2==0)  //Returns a stream. Hence intermediate operation
		.map(num->num*num)     //Returns a stream. Hence intermediate operation
		.sorted(Comparator.naturalOrder())  //Returns a stream. Hence intermediate operation
		.forEach(System.out::println);   //Terminal operation
		
		//reduce	Terminal operation
		//collect   Terminal operation
		
		Predicate<Integer> predicate = num->num%2==0;   //Predicate takes one input and returns boolean output
		Function<Integer,Integer> function = num->num*num;  // Function takes one input and return one output,i/p and o/p can be of different datatype
		Consumer<Integer> consumer = System.out::println;  // one input Consumer returns no output
		BinaryOperator<Integer> biOperator=(a,b)-> a+b;		// Binary operator  two input & one output  , Input and o/p are of same datatype
		//All three are functional interface
		Supplier<Integer> randomInteger=()->2;    //No i/p and 1 o/p
		Supplier<Integer> randomInteger2=()-> {System.out.println("2"); return null;};
		
		UnaryOperator<Integer> uniOperator=(a)-> a*10;			//Single i/p &single o/p
		
		BiPredicate<Integer,String> biPredicate = (num,str)->num%2==0;   //BiPredicate takes two input and returns boolean output
		BiFunction<Integer,Integer,Integer> biFunction = (num,num2)->num*num2;  // BiFunction takes two input and return one output,i/p and o/p can be of different datatype
		BiConsumer<Integer,String> consumer2 = (num1,s2)->{					//Two input 0 o/p
			System.out.println(s2);
			System.out.println(num1);
		};  // BiConsumer returns no output
		
		System.out.println("*****");
		lstNum.stream()
		.filter(predicate)   
		.map(uniOperator)   //.map(function)
		.forEach(consumer);
		System.out.println("*****");
		filterAndPrint(lstNum,num-> num%2==0);  //Print Even
		filterAndPrint(lstNum,num-> num%2!=0);  //Print Odd
		filterAndPrint(lstNum,num-> num%3==0);  //Print Multiple of 3
		mathFunction(lstNum, num->num*num);
		mathFunction(lstNum, num->num*2);
		
		System.out.println(randomInteger.get());
		randomInteger.get();
	}
	public static void print(int num) {
		System.out.println(num);
	}
	public static int sum(int a,int b) {
		return a+b;
	}
	public static void filterAndPrint(List lstNum,Predicate<Integer> formula){
		lstNum.stream()
		.filter(formula)
		.forEach(System.out::println);
	}
	public static void mathFunction(List<Integer> lstNumber,Function<Integer,Integer> operation) {
		
		lstNumber.stream()
		.map(operation)
		.forEach(System.out::println);
	}
}
