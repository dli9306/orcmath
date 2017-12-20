package playground;

import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Sampler;

public class CatalogMaker {
    static ArrayList<Catalog> booklist;
    
	 
	public CatalogMaker() {
		booklist =  new ArrayList<Catalog>();
		booklist.add(new Catalog("HarryPotter","JK Rowling",120));
		booklist.add(new Catalog("Magic Tree House","BOB",256));
		booklist.add(new Catalog("The Expanse","Orion B",120));
		
	}
	public static void main(String[] args){
		CatalogMaker c = new CatalogMaker();
		newEntry();
		Scanner n = new Scanner(System.in);
		System.out.println("Would you like to save this file?");
		String s = n.nextLine();
		if(s.toLowerCase().contains("yes")) {
			
		}
		
		System.out.println(c.getCSContent());
	}
	public static void newEntry() {
		int page= 0;
		String title = "";
		String author = "";
		Scanner n = new Scanner(System.in);
		System.out.println("Name of book");
		String s = n.nextLine();
		title = s;
		System.out.println("Name of author");
		String a = n.nextLine();
		author = a;
		System.out.println("Number of pages");
		String p = n.nextLine();
	     page = Integer.parseInt(p);
		booklist.add(new Catalog(s,a,page));
		System.out.println("Would you like to make another entry?");
		String x = n.nextLine();
		if(x.toLowerCase().contains("yes")){
			newEntry();
		}
		else
		{
			System.out.println("Done");
		}
		
	}

	public String getCSContent() {
		String data = "";
		for(Catalog e:booklist) {
			data+=e + "\n";
		}
		return data;
	}


}
