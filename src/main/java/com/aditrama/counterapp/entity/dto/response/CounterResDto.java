package com.aditrama.counterapp.entity.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class CounterResDto {
	List<String> nameList;
	Integer countTotal;
}
