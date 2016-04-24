package scratch;
import java.io.*;
public class MyClass {
	
	public static double circleArea (double radius){
		double first=Math.PI;
		double second=Math.abs(radius);
		double third=Math.pow(second,2);
		return first*third;
	}

	public static void main(String []args){
		String a=new String ("abcdefg");
		String b=new String ("ABCDEFG");
		String c=new String ("AbcdefG");
//		String d=new String ("cde");
		File pwd = new File(System.getProperty("user.dir"));
        if (pwd.isDirectory()){
            File [] bar=pwd.listFiles();
            for (int i=0;i<bar.length;i++){
                System.out.println (bar[i].getName());
            }
       }else{
           System.out.println ("Error. The argument is not a directory");
       }
		System.out.println (a.equalsIgnoreCase(b)); 
		System.out.println (a.equals(b));
		System.out.println (c.substring(2,4)); 
		
		System.out.println(circleArea(-10));
	}
}	

