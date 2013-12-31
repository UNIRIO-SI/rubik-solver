package controller;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

	private List<String> rotations;
	
	public Timeline(){
		super();
		
		rotations = new ArrayList<String>();
	}
	
	public void addRotation(String rotation){
		rotations.add(rotation);
	}

	public void removeLastRotation() {
		rotations.remove(rotations.size()-1);
	}
	
	public String getLastRotation(){
		return rotations.get(rotations.size()-1);
	}
		
	public List<String> getRotations() {
		return rotations;
	}
	
	public String getInvertedRotation(String rotation){
		
		if(rotation.endsWith("_")){
			
			return rotation.substring(0, rotation.length()-1);
			
		}else if(rotation.endsWith("2")){
			
			return rotation;
			
		}else{
			
			return rotation+"_";
			
		}
		
	}
		
}
