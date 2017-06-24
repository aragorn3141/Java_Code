package ict4315.finalproject.Templates;

import java.util.Observable;
import java.util.Observer;

public class ViewTemplate implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {updateView();}
	
	public void updateView(){}

}

