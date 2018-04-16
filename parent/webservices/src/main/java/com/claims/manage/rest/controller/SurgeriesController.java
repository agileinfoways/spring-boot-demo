package com.claims.manage.rest.controller;

import java.util.List;

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.common.dto.SurgeryDto;
import com.claims.manage.common.vos.SurgeryVo;
import com.claims.manage.services.exceptions.SurgeriesServiceException;

public interface SurgeriesController {
	List<SurgeryDto> getAllSurgeries()throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto saveTreatments(SurgeryVo treatmentDto)throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto activeTreatement(SurgeryVo treatmentDto) throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto deactiveTreatement(SurgeryVo treatmentDto) throws SurgeriesServiceException,SurgeryBusinessServiceException;
}
