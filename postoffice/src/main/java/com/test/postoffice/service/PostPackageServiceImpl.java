package com.test.postoffice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.postoffice.entity.PostPackage;
import com.test.postoffice.repository.PostPackageRepository;

@Service
public class PostPackageServiceImpl implements PostPackageService {

	@Autowired
	private PostPackageRepository postPackageRepository;
	
	@Override
	public List<PostPackage> findAll() {
		return postPackageRepository.findAll();
	}

	@Override
	public PostPackage findById(int id) {
		Optional<PostPackage> result = postPackageRepository.findById(id);
		
		PostPackage pkg = null;
		
		if (result.isPresent()) {
			pkg = result.get();
		} else {
			throw new RuntimeException("Package with id " + id + " not found");
		}
		
		return pkg;
	}

	@Override
	public void save(PostPackage pkg) {
		postPackageRepository.save(pkg);
	}

	@Override
	public void deleteById(int id) {
		postPackageRepository.deleteById(id);
	}

}
