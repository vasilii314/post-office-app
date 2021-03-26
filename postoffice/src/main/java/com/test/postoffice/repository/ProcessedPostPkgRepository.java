package com.test.postoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.postoffice.entity.ProcessedPostPackage;

@Repository
public interface ProcessedPostPkgRepository extends JpaRepository<ProcessedPostPackage, Integer> {

}
