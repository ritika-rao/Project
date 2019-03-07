import java.util.*;
import java.io.*;
 class insertTable
{
	String table,path;
	public String GetDataname()
	{
		try
		{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the name of table");
		table=in.nextLine();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return (table);
	}
	public String GetPath()
	{
		try
		{
			path="C:\\Users\\RITIKA\\Desktop\\PROJECT\\csv";
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return path;
	}
	void CreateDatabase()
	{
		boolean fol=false;
		String s=GetDataname();
		File f=new File(GetPath());
		try
		{
			fol=f.mkdir();
			f.createNewFile();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(fol)
		{
			System.out.println("folder created");
		}
		else
			System.out.println("folder not created");
	}
}