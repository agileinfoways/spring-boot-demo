package com.claims.manage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.business.services.TreatmentBusinessService;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.common.messages.ConstantMessage;
import com.claims.manage.services.exceptions.TreatmentServiceException;
import com.claims.manage.services.services.TreatmentService;

@Service("treatmentService")
public class TreatmentServiceImpl  implements TreatmentService{
	
	@Autowired
	TreatmentBusinessService treatmentBusinessService;

	@Override
	public List<TreatmentDto> getAllTreatments() throws TreatmentServiceException,TreatmentBusinessServiceException {		
		return treatmentBusinessService.getAllTreatments();
	}

	@Override
	public TreatmentDto saveTreatments(TreatmentDto treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException {	
		if(treatmentDto==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTISNULL.getMessage(),new  RuntimeException());
		if(treatmentDto.getName()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getDescription()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTDESCREQUIRED.getMessage(),new  RuntimeException());		
		return treatmentBusinessService.saveTreatments(treatmentDto);
	}

	@Override
	public TreatmentDto activeTreatement(TreatmentDto treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException {	
		if(treatmentDto==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTISNULL.getMessage(),new  RuntimeException());
		if(treatmentDto.getName()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getDescription()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTDESCREQUIRED.getMessage(),new  RuntimeException());		
		if(treatmentDto.getActive()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTACTIVECREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getActive()!=null && !treatmentDto.getActive())
			throw new TreatmentServiceException(ConstantMessage.TREATMENTACTIVENOTFALSE.getMessage(),new  RuntimeException());
		return treatmentBusinessService.activeTreatement(treatmentDto);
		
	}

	@Override
	public TreatmentDto deactiveTreatement(TreatmentDto treatmentDto) throws TreatmentServiceException,TreatmentBusinessServiceException {
		if(treatmentDto==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTISNULL.getMessage(),new  RuntimeException());
		if(treatmentDto.getName()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getDescription()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTDESCREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getActive()==null)
			throw new TreatmentServiceException(ConstantMessage.TREATMENTACTIVECREQUIRED.getMessage(),new  RuntimeException());
		if(treatmentDto.getActive()!=null && treatmentDto.getActive())
			throw new TreatmentServiceException(ConstantMessage.TREATMENTACTIVENOTTRUE.getMessage(),new  RuntimeException());
		return treatmentBusinessService.deactiveTreatement(treatmentDto);
	}

}
