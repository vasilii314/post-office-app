package com.test.postoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.postoffice.entity.PostOffice;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {
	
}
