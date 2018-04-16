package com.claims.manage.rest.controller.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.common.vos.TreatmentVo;
import com.claims.manage.rest.controller.TreatmentController;
import com.claims.manage.rest.response.ApiResponse;
import com.claims.manage.services.exceptions.TreatmentServiceException;
import com.claims.manage.services.services.TreatmentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest/treatment")
@Api(tags = "Treatment Controller")
public class TreatmentControllerImpl implements TreatmentController {

	@Autowired
	TreatmentService service;
	@Autowired 
	Mapper mapper;

	@GetMapping("/all")
	public List<TreatmentDto> getAllTreatments() throws TreatmentServiceException, TreatmentBusinessServiceException {
		return service.getAllTreatments();
	}

	@PostMapping("/save")
	public TreatmentDto saveTreatments(@RequestBody TreatmentVo treatmentVo)
			throws TreatmentServiceException, TreatmentBusinessServiceException {
		TreatmentDto treatmentDto = mapper.map(treatmentVo, TreatmentDto.class);
		return service.saveTreatments(treatmentDto);
	}
	
	@PutMapping("/activeTreatment")
	public TreatmentDto activeTreatement(@RequestBody  TreatmentVo treatmentVo)
			throws TreatmentServiceException, TreatmentBusinessServiceException {
		TreatmentDto treatmentDto = mapper.map(treatmentVo, TreatmentDto.class);		
		return service.activeTreatement(treatmentDto);
	}

	@PutMapping("/deactiveTreatment")
	public TreatmentDto deactiveTreatement(@RequestBody  TreatmentVo treatmentVo)
			throws TreatmentServiceException, TreatmentBusinessServiceException {
		TreatmentDto treatmentDto = mapper.map(treatmentVo, TreatmentDto.class);
		return service.activeTreatement(treatmentDto);
	}

	@ExceptionHandler(TreatmentServiceException.class)
	public ResponseEntity<Object> customException(TreatmentServiceException ex) {
		return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());
	}

	@ExceptionHandler(TreatmentBusinessServiceException.class)
	public ResponseEntity<Object> customException(TreatmentBusinessServiceException ex) {
		return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());
	}

	

}
