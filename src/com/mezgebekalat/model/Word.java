package com.mezgebekalat.model;

public class Word {
	public String word; 
	public String wordType;
	public String definition;
	
	
	public Word(String word, String wordType, String definition) {
		super();
		this.word = word;
		this.wordType = wordType;
		this.definition = definition;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWordType() {
		return wordType;
	}
	public void setWordType(String wordType) {
		this.wordType = wordType;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", wordType=" + wordType + ", definition=" + definition + "]";
	}
}