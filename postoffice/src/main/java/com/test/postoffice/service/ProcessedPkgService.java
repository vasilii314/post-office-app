package com.test.postoffice.service;

import java.util.List;

import com.test.postoffice.entity.ProcessedPostPackage;

public interface ProcessedPkgService {
	
	public List<ProcessedPostPackage> findAll();
	
	public ProcessedPostPackage findById(int id);
	
	public void save(ProcessedPostPackage pkg);
	
	public void deleteById(int id);
}
