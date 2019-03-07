package com.ncu.main;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileAppend
{
    void append(String filename) 
    {
    	Scanner in=new Scanner(System.in);
        FileWriter fw=null;
        BufferedWriter bw=null;
        PrintWriter pw=null;
        try 
        {
            fw = new FileWriter(filename, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            //taking data from the user we need to enter
            System.out.println("Enter the ID: ");
            String ID=in.next();
            System.out.println("Enter the name: ");
            String name=in.next();
            System.out.println("Enter the age: ");
            String age=in.next();
            //printing the data in the file
            pw.println(ID+","+name+","+age);
            //dialog box will tell if record is saved 
            JOptionPane.showMessageDialog(null,"Record saved");
            pw.flush();
            pw.close();
            bw.close();
            fw.close();

        } 
        catch(Exception e)
            {
                System.out.println(e);
            }

    }
           
}




