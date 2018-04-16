package com.claims.manage.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claims.manage.business.exception.TreatmentBusinessServiceException;
import com.claims.manage.business.services.TreatmentBusinessService;
import com.claims.manage.common.dto.TreatmentDto;
import com.claims.manage.db.models.Treatments;
import com.claims.manage.db.repo.TreatmentsRepository;

@Service("treatmentBusinessService")
public class TreatmentBusinessServiceImpl implements TreatmentBusinessService {
	
	@Autowired
	TreatmentsRepository treatmentsRepository;
	@Autowired
	private Mapper mapper;

	@Override
	public List<TreatmentDto> getAllTreatments() throws TreatmentBusinessServiceException{
		try {
			List<Treatments> treatmentsList = treatmentsRepository.findByActive(true);
			return treatmentsList.stream().map(t -> mapper.map(t, TreatmentDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new TreatmentBusinessServiceException("Error on getting list", e);
		}
	}

	@Override
	public TreatmentDto saveTreatments(TreatmentDto treatmentDto) throws TreatmentBusinessServiceException {
		try {
			Treatments save = treatmentsRepository.save(mapper.map(treatmentDto, Treatments.class));
			return mapper.map(save, TreatmentDto.class);
		} catch (Exception e) {
			throw new TreatmentBusinessServiceException("No Treatments Found", e);
		}
	}

	@Override
	public TreatmentDto activeTreatement(TreatmentDto treatmentDto) throws TreatmentBusinessServiceException {
		return setActiveDeactive(treatmentDto,true);
	}
	@Override
	public TreatmentDto deactiveTreatement(TreatmentDto treatmentDto) throws TreatmentBusinessServiceException {
		return  setActiveDeactive(treatmentDto,false);
	}

	private TreatmentDto setActiveDeactive(TreatmentDto treatmentDto,boolean isActive) throws TreatmentBusinessServiceException {
		Treatments findOne = treatmentsRepository.findOne(treatmentDto.getId());
		if(findOne==null)
			throw new TreatmentBusinessServiceException("No Treatments Found", new RuntimeException());
		findOne.setActive(isActive);
		Treatments save = treatmentsRepository.save(findOne);
		return mapper.map(save, TreatmentDto.class);
	}

	

}
