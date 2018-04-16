package com.claims.manage.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claims.manage.db.models.Surgery;
import com.claims.manage.db.models.Treatments;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer>{

	List<Surgery> findByActive(Boolean b);
}
