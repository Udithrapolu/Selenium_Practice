package rahulshettypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import junit.framework.Assert;



public class SimpleJavaStreamProg {

	
	
	
	@Test
	public  void StreamFilter() {
		// TODO Auto-generated method stub
		ArrayList<String> name = new ArrayList<String>();
		
		name.add("Prashanth");
		name.add("Raju");
		name.add("Udith");
		name.add("Hemanth");
		
		
		long c = name.stream().filter(s->s.startsWith("U")).count();
		System.out.println(c);
		
		long d = Stream.of("Prashanth","Raju","Hemanth").filter(e->
			e.startsWith("z")
		).count();
		System.out.println(d);
		
		
		//print the name of array list start with u  (or) print all the name of arraylist
		name.stream().filter(s->s.startsWith("U")).forEach(s->System.out.println(s));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void StreamMap()
	{
		
		ArrayList<String> name = new ArrayList<String>();
		
		name.add("Prashanth");
		name.add("Raju");
		name.add("hi");
		name.add("Hemanth");
		
		List<String> names1 = Arrays.asList("Prashanth","Raju","Hemanth","Udith");
		
		//names1.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//names.stream().filter(s->s.startsWith("R")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		Stream<String> newStream = Stream.concat(name.stream(),names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Udithhi"));
		System.out.println(flag);
		
				
	}
	
	
	@Test 
	public void streamCollect()
	{
		List<String> ls =Stream.of("Prashanth","Raju","Hemanth","Udith").filter(s->s.endsWith("h")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(1));
		
		System.out.println("hi");
		
		//print unique no from this array 
		
		List<Integer> value = Arrays.asList(3,4,5,6,6,7,8);
		String string = String.valueOf(value);
		value.stream().distinct().forEach(s->System.out.println(s));
		
		//sort the array get the 3rd index
		System.out.println(value.get(3));
		
	}
	
	@Test
	
	 public void Barre() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Hello");
        name.add("Somarapu");
        name.add("kumar");
        name.add("Abhi");
//        Print names which have last letter "a" in UPPERCASE
//        Stream.of("Raja", "Mahesha", "Rahul", "Ram").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
//                .forEach(s -> System.out.println(s));   
//      Print names which has first letter "R" and in sorted
        List<String> names = Arrays.asList("Raja", "Mahesha", "Rahul", "Ram");
//        names.stream().filter(s -> s.startsWith("R")).sorted().map(s -> s.toUpperCase())
//                .forEach(s -> System.out.println(s));      



       List<String> lists = Stream.concat(name.stream(), names.stream()).collect(Collectors.toList());
        
//        lists.forEach(s->System.out.println(s));
        
        
        Stream<String> ls =lists.stream().sorted();
//        
//        Stream<String> newStream1 = lists.sorted();
//        newStream1.forEach(a->System.out.println(a));
        boolean flag = ls.anyMatch(s -> s.equalsIgnoreCase("Raja"));
        System.out.println(flag);
        Assert.assertTrue(flag);



	}

}
