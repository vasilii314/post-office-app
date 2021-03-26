package com.test.postoffice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.postoffice.entity.PostOffice;
import com.test.postoffice.repository.PostOfficeRepository;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {
	
	@Autowired
	private PostOfficeRepository postOfficeRepository;

	@Override
	public List<PostOffice> findAll() {
		return postOfficeRepository.findAll();
	}

	@Override
	public PostOffice findById(int id) {
		Optional<PostOffice> result = postOfficeRepository.findById(id);
		
		PostOffice office = null;
		
		if (result.isPresent()) {
			office = result.get();
		} else {
			throw new RuntimeException("Post office with code " + id + " not found");
		}
		
		return office;
	}

	@Override
	public void save(PostOffice office) {
		postOfficeRepository.save(office);
	}

	@Override
	public void deleteById(int id) {
		postOfficeRepository.deleteById(id);
	}

}
