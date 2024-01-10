package com.aditrama.counterapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aditrama.counterapp.entity.dto.response.CounterResDto;

@Service	
public class CounterService {

    Logger logger = LoggerFactory.getLogger(CounterService.class);
    
	public Integer countWord(String words) {
		Integer result = 0;
		List<String> wordList = new ArrayList<String>();
		words = words.replaceAll("[^a-zA-Z0-9]", "|");
		
		wordList = Arrays.asList(words.split("\\|"));
		
		List<String> wordsListFiltered = wordList.stream()
				.filter(w -> w.startsWith("M") || w.startsWith("m"))
				.filter(w -> w.length() > 5)				
				.collect(Collectors.toList());
		
		for(String word : wordsListFiltered) {
			result++;
//			logger.info("Isinya word: {} & words ke: {}", word, result);
		}
		
		return result;
	}
	
	public CounterResDto countWordAndName(String words) {
		CounterResDto result = new CounterResDto();
		List<String> nameList = new ArrayList<String>();
		Integer countWord = 0;
		List<String> wordList = new ArrayList<String>();
		words = words.replaceAll("[^a-zA-Z0-9]", "|");
		
		wordList = Arrays.asList(words.split("\\|"));
		
		List<String> wordsListFiltered = wordList.stream()
				.filter(w -> w.startsWith("M") || w.startsWith("m"))
				.filter(w -> w.length() > 5)				
				.collect(Collectors.toList());
		
		for(String word : wordsListFiltered) {
			countWord++;
			nameList.add(word);
//			logger.info("Isinya word: {} & words ke: {}", word, result);
		}

		result.setNameList(nameList);
		result.setCountTotal(countWord);
		return result;
	}
	
}
