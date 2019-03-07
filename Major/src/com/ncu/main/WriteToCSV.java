package com.ncu.main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class WriteToCSV
{
	void saveRecord(String ID,String name,String age,String filepath)
	{
		try
		{
			//enter data
			FileWriter fw=new FileWriter(filepath,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(ID+","+name+","+age);
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(null,"Record saved");

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Record not saved");
		}
	}
}
