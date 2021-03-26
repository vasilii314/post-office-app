package com.test.postoffice.service;

import java.util.List;

import com.test.postoffice.entity.PostPackage;

public interface PostPackageService {

	public List<PostPackage> findAll();
	
	public PostPackage findById(int id);
	
	public void save(PostPackage pkg);
	
	public void deleteById(int id);
}
