package com.mycompany.app.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;

@Getter
public class Config {

	private ArrayList<Integer> numberArray = new ArrayList<>();
	private ArrayList<Condition> conditions;

	public Config(int arraySize,ArrayList<Condition> conditions){
		this.conditions = conditions;
		for(int i = 1; i<=arraySize;i++){
			this.numberArray.add(i);
		}
	}

}
