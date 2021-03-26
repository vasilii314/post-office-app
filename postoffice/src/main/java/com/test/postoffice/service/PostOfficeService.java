package com.test.postoffice.service;

import java.util.List;

import com.test.postoffice.entity.PostOffice;

public interface PostOfficeService {
	
	public List<PostOffice> findAll();
	
	public PostOffice findById(int id);
	
	public void save(PostOffice office);
	
	public void deleteById(int id);
}
