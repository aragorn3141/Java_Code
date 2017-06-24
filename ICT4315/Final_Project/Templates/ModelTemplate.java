package ict4315.finalproject.Templates;

import java.util.Observable;
import java.util.Observer;

public class ModelTemplate extends Observable {

	public ModelTemplate() {
		super();
	}

	public void addView(ViewTemplate view){
		addObserver((Observer) view);
	}
	
	public void notifyViews()
	{
		setChanged();
		notifyObservers();
	}
}

