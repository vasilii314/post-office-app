package com.test.postoffice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.postoffice.entity.ProcessedPostPackage;
import com.test.postoffice.repository.ProcessedPostPkgRepository;

@Service
public class ProcessedPkgServiceImpl implements ProcessedPkgService {

	@Autowired
	private ProcessedPostPkgRepository processedPkgRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ProcessedPostPackage> findAll() {
		return processedPkgRepository.findAll();
	}

	@Override
	public ProcessedPostPackage findById(int id) {
		Optional<ProcessedPostPackage> result = processedPkgRepository.findById(id);
		
		ProcessedPostPackage pkg = null;
		
		if (result.isPresent()) {
			pkg = result.get();
		} else {
			throw new RuntimeException("Record with id " + id + " not found");
		}
		
		return pkg;
	}

	@Override
	public void save(ProcessedPostPackage pkg) {
		processedPkgRepository.save(pkg);
	}

	@Override
	public void deleteById(int id) {
		processedPkgRepository.deleteById(id);
	}

}
