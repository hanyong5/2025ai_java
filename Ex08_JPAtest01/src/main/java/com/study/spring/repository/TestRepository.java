package com.study.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

	Page<TestEntity> findByTitleContaining(String query, Pageable pageable);

	

}
