package playground;

import java.util.ArrayList;

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
		System.out.println(c.getCSContent());
	}
	public String getCSContent() {
		String data = "";
		for(Catalog e:booklist) {
			data+=e + "\n";
		}
		return data;
	}


}
