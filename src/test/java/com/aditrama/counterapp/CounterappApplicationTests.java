package com.aditrama.counterapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.aditrama.counterapp.controller.CounterController;
import com.aditrama.counterapp.entity.dto.request.CounterReqDto;
import com.aditrama.counterapp.entity.dto.response.CounterResDto;
import com.aditrama.counterapp.service.CounterByTxtService;
import com.aditrama.counterapp.service.CounterService;



@SpringBootTest
class CounterappApplicationTests {

	@Autowired
	private CounterService counterSvc;
	
	@Autowired
	private CounterByTxtService countertxt;
	
	@Autowired
	CounterController countrController;

	@Test
	void contextLoads() {
		Integer count = counterSvc.countWord("Kulitika, alina, mariadi, Maria, mariani lia@+_(_)*_(()_*melina rosida mei");
//		System.out.println("result: "+ count);
		assertEquals(3, count);
	}

	@Test
	void contextLoads2() {
		Integer count = countertxt.CounterTxt();
//		System.out.println("result: "+ count);
		assertEquals(6, count);
	}

	@Test
	void contextLoads3() {
		CounterResDto count = countertxt.CounterTxtBase64("S3VsaXRpa2EsIGFsaW5hLCBtYXJpYWRpLCBNYXJpYSwgbWFyaWFuaSBsaWFAK18oXykqXygoKV8qbWVsaW5hIHJvc2lkYSBtZWkNCm1pYWxpc2ENCm1hcmtvbmFoDQphbGRpc2ENCmFuaXRhDQpyYWtoYQ0KcmFtYQ0KZWxpbw0KbWFzZ2lv");
//		System.out.println("result: "+ count);
		assertEquals(6, count.getCountTotal());
		for(String data : count.getNameList()) {
			System.out.println(data);
			
		}
	}
	
	@Test
	void contextLoads4() throws Throwable {
		CounterReqDto req = new CounterReqDto();
		req.setFileStr("S3VsaXRpa2EsIGFsaW5hLCBtYXJpYWRpLCBNYXJpYSwgbWFyaWFuaSBsaWFAK18oXykqXygoKV8qbWVsaW5hIHJvc2lkYSBtZWkNCm1pYWxpc2ENCm1hcmtvbmFoDQphbGRpc2ENCmFuaXRhDQpyYWtoYQ0KcmFtYQ0KZWxpbw0KbWFzZ2lv");
//		CounterResDto count = countertxt.CounterTxtBase64("S3VsaXRpa2EsIGFsaW5hLCBtYXJpYWRpLCBNYXJpYSwgbWFyaWFuaSBsaWFAK18oXykqXygoKV8qbWVsaW5hIHJvc2lkYSBtZWkNCm1pYWxpc2ENCm1hcmtvbmFoDQphbGRpc2ENCmFuaXRhDQpyYWtoYQ0KcmFtYQ0KZWxpbw0KbWFzZ2lv");
//		System.out.println("result: "+ count);
		ResponseEntity<?> res = countrController.getCounterData(req);
		CounterResDto resObj = (CounterResDto) res.getBody();
		System.out.println("result: "+ resObj.getCountTotal());
		assertEquals(6, resObj.getCountTotal());
//		for(String data : count.getNameList()) {
//			System.out.println(data);
//			
//		}
		
	}

}
