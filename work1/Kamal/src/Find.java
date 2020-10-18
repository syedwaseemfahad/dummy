import java.util.*;
import java.io.*;  

public class Find {

	public static void main(String args[])
	{
		ArrayList<String> data1=new ArrayList<String>();
		ArrayList<String> email1=new ArrayList<String>();
		ArrayList<String> data2=new ArrayList<String>();
		ArrayList<String> email2=new ArrayList<String>();
		ArrayList<String> lines=new ArrayList<String>();
		try  
		{  
		FileInputStream fis=new FileInputStream("C:\\Users\\waseem fahad\\Downloads\\Desktop\\demo.txt");//csv file as text file       
	
		Scanner sc=new Scanner(fis); 

		String t=sc.nextLine();
		while(sc.hasNextLine())  
		{  
		String s=sc.nextLine();     
        String[] ar = s.split(","); 
        data1.add(ar[1]);
        email1.add(ar[3]);
		}  
		sc.close();       
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		} 
		
		try  
		{  
		FileInputStream fis=new FileInputStream("C:\\Users\\waseem fahad\\Downloads\\Desktop\\demo1.txt"); //json file as text file    
		Scanner sc=new Scanner(fis); 

		while(sc.hasNextLine())  
		{  
		lines.add(sc.nextLine());
		}  
		for(int i=0;i<lines.size();i++)
		{
			if(i==1 || i%5==0)
			{
				String s1=lines.get(i);
				int pos=1;
				while(s1.charAt(pos)!=34)
				{
					pos++;
				}
				data2.add(s1.substring(1,pos));
				String s2="";
				if(i==1)
				{
					s2=lines.get(3);
				}
				else
				{
					s2=lines.get(i+3);
				}
				int pos2=0;
				int count=0;
				while(count!=3)
				{
					if(s2.charAt(pos2)==34)
					{
						count++;
					}
					pos2++;
				}
				email2.add(s2.substring(pos2,s2.length()-1));
				
			}
			
		}
		
		sc.close();       
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		} 
		
		
		
		
		ArrayList<String> result=new ArrayList<String>();

		for(int i=0;i<data1.size();i++)
		{
			String d1=data1.get(i);
			String e1=email1.get(i);
			for(int j=0;j<data2.size();j++)
			{
				String d2=data2.get(j);
				String e2=email2.get(2);

				if(d1.equals(d2) && !e1.equals(e2) )
				{
					result.add(e2);
				}
			}
		}
		
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
	}
	
}
