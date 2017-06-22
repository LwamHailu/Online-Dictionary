package com.mezgebekalat.service;

import java.util.List;

import com.mezgebekalat.dao.DictDao;
import com.mezgebekalat.model.Word;

public class DictService {
	
	public List<Word> findByName(String word){
		return new DictDao().findByWord(word);
	}

}
