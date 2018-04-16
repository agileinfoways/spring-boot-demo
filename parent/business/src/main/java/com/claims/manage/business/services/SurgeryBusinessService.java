package com.claims.manage.business.services;

import java.util.List;

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.common.dto.SurgeryDto;

public interface SurgeryBusinessService {
	List<SurgeryDto> getAllSurgeries()throws SurgeryBusinessServiceException;
	SurgeryDto saveSurgeries(SurgeryDto treatmentDto)throws SurgeryBusinessServiceException;
	SurgeryDto activeSurgeries(SurgeryDto treatmentDto) throws SurgeryBusinessServiceException;
	SurgeryDto deactiveSurgeries(SurgeryDto treatmentDto) throws SurgeryBusinessServiceException;

}
