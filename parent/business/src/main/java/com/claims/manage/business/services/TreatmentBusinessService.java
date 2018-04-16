package com.claims.manage.business.services;

import java.util.List;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.common.dto.TreatmentDto;

public interface TreatmentBusinessService {
	List<TreatmentDto> getAllTreatments()throws TreatmentBusinessServiceException;
	TreatmentDto saveTreatments(TreatmentDto treatmentDto)throws TreatmentBusinessServiceException;
	TreatmentDto activeTreatement(TreatmentDto treatmentDto) throws TreatmentBusinessServiceException;
	TreatmentDto deactiveTreatement(TreatmentDto treatmentDto) throws TreatmentBusinessServiceException;

}
