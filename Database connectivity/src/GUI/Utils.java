package GUI;

public class Utils {
	
	public static String getFileExtenshion(String name)
	{
		int pointIndex = name.lastIndexOf('.');
		if(pointIndex == -1)
			return null;
		if(pointIndex == name.length()-1){
			return null;
		}
		return name.substring(pointIndex+1);
	}

}
