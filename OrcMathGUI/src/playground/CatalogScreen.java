package playground;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {
	
	private TextField descriptionField; 
	private TextArea text;
	private Button button;
	private FileOpenButton openButton;
	private CatalogMaker catalog;
	

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//text field: single line of text
		//text box: multi-line
		catalog = new CatalogMaker();
		descriptionField = new TextField(40, 40, 200, 30, "Title!","Name of Book");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40, 100, 200, 30, "Author!","Name of Author");
		viewObjects.add(descriptionField);
		descriptionField = new TextField(40, 160, 200, 30, "Pages!","Number of Pages");
		descriptionField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(descriptionField);
		text = new TextArea(40, 240, 200, 100, "PUT TEXT HERE");
		viewObjects.add(text);
		button = new Button(40,300,100,40,"Add Button",new Action() {
			
			@Override
			public void act() {
				addClicked();
				
			}
		});
		viewObjects.add(button);
		button = new Button(150,300,100,40,"Save Button",new Action() {
			
			@Override
			public void act() {
				saveClicked();
				
			}
		});
		viewObjects.add(button);
		button = new Button(270,300,100,40,"Delete Button",new Action() {
			
			@Override
			public void act() {
				deleteclicked();
				
				
			}

		});
		viewObjects.add(button);
		openButton = new FileOpenButton(380, 300, 100, 40, null, this);
		viewObjects.add(openButton);
        

	}

	protected void deleteclicked() {
		
		
	}

	protected void saveClicked() {
          	
	}

	protected void addClicked() {
		Catalog c = new Catalog(descriptionField.getText(),descriptionField.getText(),Integer.parseInt(descriptionField.getText()));
		catalog.add(c);
		text.setText("Your field have been added"+c);
		
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
