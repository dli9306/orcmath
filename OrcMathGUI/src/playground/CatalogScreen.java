package playground;

import java.util.List;

import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField descriptionField; 

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40, 40, 200, 30, "Title!","Name of Book");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40, 100, 200, 30, "Author!","Name of Author");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40, 160, 200, 30, "Pages!","Number of Pages");
		viewObjects.add(descriptionField);

	}

}
