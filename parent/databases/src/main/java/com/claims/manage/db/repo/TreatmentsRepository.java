package com.claims.manage.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claims.manage.db.models.Treatments;

public interface TreatmentsRepository extends JpaRepository<Treatments, Integer>{

	List<Treatments> findByActive(Boolean b);
}
