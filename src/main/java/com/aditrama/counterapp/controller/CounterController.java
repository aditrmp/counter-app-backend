package com.aditrama.counterapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aditrama.counterapp.entity.dto.request.CounterReqDto;
import com.aditrama.counterapp.entity.dto.response.CounterResDto;
import com.aditrama.counterapp.service.CounterByTxtService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/count")
public class CounterController {

	@Autowired
	CounterByTxtService counterSvc; 
	
	@CrossOrigin
	@RequestMapping(value = "/bytxt", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getCounterData(@RequestBody CounterReqDto req) throws Throwable {	
		log.info("Start /count/bytxt contetnt: {}",  req);
//		DataAddResponse resp = eventSvc.getAllEventData();
//		String requ = "S3VsaXRpa2EsIGFsaW5hLCBtYXJpYWRpLCBNYXJpYSwgbWFyaWFuaSBsaWFAK18oXykqXygoKV8qbWVsaW5hIHJvc2lkYSBtZWkNCm1pYWxpc2ENCm1hcmtvbmFoDQphbGRpc2ENCmFuaXRhDQpyYWtoYQ0KcmFtYQ0KZWxpbw0KbWFzZ2lv";
//		byte[] decodedFile = Base64.getDecoder().decode(req.getFileStr().getBytes(StandardCharsets.UTF_8));
//		byte[] decodedFile2 = Base64.getDecoder().decode(requ.getBytes(StandardCharsets.UTF_8));
		
		CounterResDto result = counterSvc.CounterTxtBase64(req.getFileStr());
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
}
