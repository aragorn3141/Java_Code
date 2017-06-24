package ict4315.finalproject.BaseClasses.HelperClasses;

public class PhoneType {
	
	private static String[] values = {"Home", "Cell", "Work", "Fax"};
	
	public static String[] getValues() {return values;}
	
	public static int size(){ return values.length;}
	
	public static String stringAtIndex(int index) {
		if(index>=0 && index < size()){
			return values[index];
		}
		else{
			return "Invalid";
		}
	}
	
	public static int indexOf(String selection){
		for(String element : values){	
			if(element.equals(selection))
				{return java.util.Arrays.asList(values).indexOf(element);}
		}
		
		return -1;
	}
}
