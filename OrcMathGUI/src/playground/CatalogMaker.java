package playground;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;
import guiPlayer.Sampler;

public class CatalogMaker {
	/*
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
	public void add(Catalog c) {
		// TODO Auto-generated method stub
		
	}
	*/
	public static Scanner in;

	private ArrayList<Catalog> catalog;

	public CatalogMaker() {
		//instantiate the catalog
		catalog = new ArrayList<Catalog>();
	}

	public static void main(String[] args){
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();
	}

	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	private void create() {
		
		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}

	private void add() {
		String title = null;
		String author = null;
		int pages = 0;
		displayMessage("Please enter a title");
		title = getStringInput();
		displayMessage("Please enter an author");
		author = getStringInput();
		displayMessage("Please enter the number of pages.");
		pages = getIntegerInput();
		addBook(new Catalog(title, author, pages));
	}

	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}


	public void addBook(Catalog b){
		catalog.add(b);
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Catalog b: catalog){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Books:\n");
		for(Catalog b: catalog){
			displayMessage("   "+b.toString()+"\n");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		catalog = new ArrayList<Catalog>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					catalog.add(new Catalog(param[0],param[1],Integer.parseInt(param[2])));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}


}
