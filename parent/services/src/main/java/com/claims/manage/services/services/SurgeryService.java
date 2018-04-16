package com.claims.manage.services.services;

import java.util.List;

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.common.dto.SurgeryDto;
import com.claims.manage.services.exceptions.SurgeriesServiceException;


public interface SurgeryService {
	List<SurgeryDto> getAllSurgeries()throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto saveSurgeries(SurgeryDto surgeryDto)throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto activeTreatement(SurgeryDto surgeryDto) throws SurgeriesServiceException,SurgeryBusinessServiceException;
	SurgeryDto deactiveTreatement(SurgeryDto surgeryDto) throws SurgeriesServiceException,SurgeryBusinessServiceException;

}
