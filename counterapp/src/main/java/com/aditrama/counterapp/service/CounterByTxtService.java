package com.aditrama.counterapp.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditrama.counterapp.entity.dto.response.CounterResDto;

@Service
public class CounterByTxtService {
	Logger logger = LoggerFactory.getLogger(CounterByTxtService.class);

	@Autowired
	private CounterService counterSvc;

	public Integer CounterTxt() {
		Integer result = 0;
		try {
			File myObj = new File("import.txt");
			Scanner myReader = new Scanner(myObj);
			String words = "";
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				words = words.concat("|").concat(data);
			}

			myReader.close();

			result = counterSvc.countWord(words);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	

	public CounterResDto CounterByTxt() {
		CounterResDto result = new CounterResDto();
		try {
			File myObj = new File("import.txt");
			Scanner myReader = new Scanner(myObj);
			String words = "";
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
//				System.out.println(data);
				words = words.concat("|").concat(data);
			}

			myReader.close();

			result = counterSvc.countWordAndName(words);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public CounterResDto CounterTxtBase64(String base64String) {
		Integer countName = 0;
		CounterResDto result = new CounterResDto();
		try {
			byte[] decodedFile = Base64.getDecoder().decode(base64String.getBytes(StandardCharsets.UTF_8));

			Path path = Paths.get("import.txt");
			Files.write(path, decodedFile);

			result = CounterByTxt();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;

	}

}
