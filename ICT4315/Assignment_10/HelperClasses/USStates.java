package ict4315.assignment10.HelperClasses;

public class USStates {
	
	private static String[] values = {"AL", "AK", "AR", "AZ", "CA", "CO", "CT", 
			"DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", 
			"LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", 
			"NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", 
			"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
	
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
			if(element.equals(selection.toUpperCase()))
				{return java.util.Arrays.asList(values).indexOf(element);}
		}
		
		return -1;
	}
}
