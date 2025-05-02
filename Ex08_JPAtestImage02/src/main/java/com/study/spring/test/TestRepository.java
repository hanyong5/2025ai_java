package com.study.spring.test;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

	Page<TestResponseDto> findByTitleContainingIgnoreCase(String query, Pageable pageable);



}
