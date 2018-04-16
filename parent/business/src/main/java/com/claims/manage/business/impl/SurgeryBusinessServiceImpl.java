package com.claims.manage.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claims.manage.business.exception.SurgeryBusinessServiceException;
import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.business.services.SurgeryBusinessService;
import com.claims.manage.business.services.TreatmentBusinessService;
import com.claims.manage.common.dto.SurgeryDto;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.db.models.Surgery;
import com.claims.manage.db.models.Treatments;
import com.claims.manage.db.repo.SurgeryRepository;
import com.claims.manage.db.repo.TreatmentsRepository;

@Service("surgeryBusinessService")
public class SurgeryBusinessServiceImpl implements SurgeryBusinessService {
	
	@Autowired
	SurgeryRepository surgeryRepository;
	@Autowired
	private Mapper mapper;

	@Override
	public List<SurgeryDto> getAllSurgeries() throws SurgeryBusinessServiceException {
		try {
			List<Surgery> surgeriesList = surgeryRepository.findByActive(true);
			return surgeriesList.stream().map(t -> mapper.map(t, SurgeryDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new SurgeryBusinessServiceException("Error on getting list", e);
		}
	}

	@Override
	public SurgeryDto saveSurgeries(SurgeryDto treatmentDto) throws SurgeryBusinessServiceException {
		try {
			Surgery save = surgeryRepository.save(mapper.map(treatmentDto, Surgery.class));
			return mapper.map(save, SurgeryDto.class);
		} catch (Exception e) {
			throw new SurgeryBusinessServiceException("No Surgery Found", e);
		}
	}

	@Override
	public SurgeryDto activeSurgeries(SurgeryDto treatmentDto) throws SurgeryBusinessServiceException {
		return setActiveDeactive(treatmentDto,true);
	}

	@Override
	public SurgeryDto deactiveSurgeries(SurgeryDto treatmentDto) throws SurgeryBusinessServiceException {
		return setActiveDeactive(treatmentDto,false);
	}
	
	private SurgeryDto setActiveDeactive(SurgeryDto treatmentDto,boolean isActive) throws SurgeryBusinessServiceException {
		Surgery findOne = surgeryRepository.findOne(treatmentDto.getId());
		if(findOne==null)
			throw new SurgeryBusinessServiceException("No  Surgery Found", new RuntimeException());
		findOne.setActive(isActive);
		Surgery save = surgeryRepository.save(findOne);
		return mapper.map(save, SurgeryDto.class);
	}

	

}
