package com.claims.manage.services.services;

import java.util.List;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.services.exceptions.TreatmentServiceException;

public interface TreatmentService {
	List<TreatmentDto> getAllTreatments()throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto saveTreatments(TreatmentDto treatmentDto)throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto activeTreatement(TreatmentDto treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto deactiveTreatement(TreatmentDto treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException;

}
