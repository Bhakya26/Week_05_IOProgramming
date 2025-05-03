import java.util.*;
public class SuppressUnchecked {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ArrayList list=new ArrayList();
		list.add("Hi");
		list.add("Hello");
		ArrayList<String> al=list;
		for(String a:al) {
		System.out.println(al);
	}
	}
}
