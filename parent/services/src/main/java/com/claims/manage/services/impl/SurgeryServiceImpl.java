package com.claims.manage.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.business.services.SurgeryBusinessService;
import com.claims.manage.business.services.TreatmentBusinessService;
import com.claims.manage.common.dto.SurgeryDto;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.common.messages.ConstantMessage;
import com.claims.manage.services.exceptions.SurgeriesServiceException;
import com.claims.manage.services.exceptions.TreatmentServiceException;
import com.claims.manage.services.services.SurgeryService;
import com.claims.manage.services.services.TreatmentService;

@Service("surgeryService")
public class SurgeryServiceImpl  implements SurgeryService{
	
	@Autowired
	SurgeryBusinessService surgeryBusinessService;
	

	@Override
	public List<SurgeryDto> getAllSurgeries() throws SurgeriesServiceException, SurgeryBusinessServiceException {
		return surgeryBusinessService.getAllSurgeries();
	}

	@Override
	public SurgeryDto saveSurgeries(SurgeryDto surgeryDto)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		if(surgeryDto==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYISNULL.getMessage(),new  RuntimeException());
		if(surgeryDto.getName()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(surgeryDto.getDescription()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYDESCREQUIRED.getMessage(),new  RuntimeException());		
		return surgeryBusinessService.saveSurgeries(surgeryDto);
	}

	@Override
	public SurgeryDto activeTreatement(SurgeryDto surgeryDto)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		if(surgeryDto==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYISNULL.getMessage(),new  RuntimeException());
		if(surgeryDto.getName()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(surgeryDto.getDescription()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYDESCREQUIRED.getMessage(),new  RuntimeException());		
		if(surgeryDto.getActive()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYACTIVECREQUIRED.getMessage(),new  RuntimeException());
		if(surgeryDto.getActive()!=null && !surgeryDto.getActive())
			throw new SurgeriesServiceException(ConstantMessage.SURGERYACTIVENOTFALSE.getMessage(),new  RuntimeException());
		return surgeryBusinessService.activeSurgeries(surgeryDto);
	}

	@Override
	public SurgeryDto deactiveTreatement(SurgeryDto surgeryDto)
			throws SurgeriesServiceException, SurgeryBusinessServiceException {
		if(surgeryDto==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYISNULL.getMessage(),new  RuntimeException());
		if(surgeryDto.getName()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYNAMEREQUIRED.getMessage(),new  RuntimeException());
		if(surgeryDto.getDescription()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYDESCREQUIRED.getMessage(),new  RuntimeException());		
		if(surgeryDto.getActive()==null)
			throw new SurgeriesServiceException(ConstantMessage.SURGERYACTIVECREQUIRED.getMessage(),new  RuntimeException());
		if(surgeryDto.getActive()!=null && !surgeryDto.getActive())
			throw new SurgeriesServiceException(ConstantMessage.SURGERYACTIVENOTTRUE.getMessage(),new  RuntimeException());
		return surgeryBusinessService.deactiveSurgeries(surgeryDto);
	}

}
