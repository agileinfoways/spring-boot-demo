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

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.common.dto.SurgeryDto;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.common.vos.SurgeryVo;
import com.claims.manage.common.vos.TreatmentVo;
import com.claims.manage.rest.controller.SurgeriesController;
import com.claims.manage.rest.controller.TreatmentController;
import com.claims.manage.rest.response.ApiResponse;
import com.claims.manage.services.exceptions.SurgeriesServiceException;
import com.claims.manage.services.exceptions.TreatmentServiceException;
import com.claims.manage.services.services.SurgeryService;
import com.claims.manage.services.services.TreatmentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest/surgeries")
@Api(tags = "Surgeries Controller")
public class SurgeriesControllerImpl implements SurgeriesController {

	@Autowired
	SurgeryService service;
	
	@Autowired 
	Mapper mapper;

	

	@Override
	@GetMapping("/all")
	public List<SurgeryDto> getAllSurgeries() throws SurgeriesServiceException, SurgeryBusinessServiceException {
		return service.getAllSurgeries();
	}

	@Override
	@PostMapping("/save")
	public SurgeryDto saveTreatments(SurgeryVo surgeryVo)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		SurgeryDto surgeryDto = mapper.map(surgeryVo, SurgeryDto.class);
		return service.saveSurgeries(surgeryDto);
	}

	@Override
	@PutMapping("/activeTreatment")
	public SurgeryDto activeTreatement(SurgeryVo surgeryVo)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		SurgeryDto surgeryDto = mapper.map(surgeryVo, SurgeryDto.class);
		return service.activeTreatement(surgeryDto);
	}

	@Override
	@PutMapping("/deactiveTreatment")
	public SurgeryDto deactiveTreatement(SurgeryVo surgeryVo)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		SurgeryDto treatmentDto = mapper.map(surgeryVo, SurgeryDto.class);
		return service.activeTreatement(treatmentDto);
	}
	


	@ExceptionHandler(SurgeriesServiceException.class)
	public ResponseEntity<Object> customException(TreatmentServiceException ex) {
		return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());
	}

	@ExceptionHandler(SurgeryBusinessServiceException.class)
	public ResponseEntity<Object> customException(TreatmentBusinessServiceException ex) {
		return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());
	}

	

}
