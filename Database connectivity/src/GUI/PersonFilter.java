package GUI;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if(f.isDirectory())
			return true;
		
		String name = f.getName();
		if(Utils.getFileExtenshion(name.trim())=="per")
		{
			return true;
		}
			
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Personal databas files (*.per)";
		
	}

}
