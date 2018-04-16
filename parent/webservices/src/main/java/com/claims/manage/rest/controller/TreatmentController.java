package com.claims.manage.rest.controller;

import java.util.List;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.common.vos.TreatmentVo;
import com.claims.manage.services.exceptions.TreatmentServiceException;

public interface TreatmentController {
	List<TreatmentDto> getAllTreatments()throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto saveTreatments(TreatmentVo treatmentDto)throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto activeTreatement(TreatmentVo treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException;
	TreatmentDto deactiveTreatement(TreatmentVo treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException;
}
