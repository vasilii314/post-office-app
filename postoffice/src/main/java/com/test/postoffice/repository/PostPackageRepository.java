package com.test.postoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.postoffice.entity.PostPackage;

@Repository
public interface PostPackageRepository extends JpaRepository<PostPackage, Integer> {

}
