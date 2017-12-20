package playground;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Sampler;

public class FileSave {
    static ArrayList<Catalog> booklist;
    
	 
	public FileSave() {

		
	}
	public static void main(String[] args){
		FileSave c = new FileSave();
		Scanner n = new Scanner(System.in);
		System.out.println("Type something");
		String s = n.nextLine();
	    testSaveContent("test.txt",s);
	    System.out.println("Save Sucessfully");
		
	}
	private static void testSaveContent(String fileName,String s) {

		 try{    

		 FileWriter fw=new FileWriter(fileName);    

		 fw.write(s);    

		 fw.close();    

		 System.out.println("Success! File \""+fileName+"\" saved!");

		 }catch(IOException e){

		 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		 }

		     
		 }
}
