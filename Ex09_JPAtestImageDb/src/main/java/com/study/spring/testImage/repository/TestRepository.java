package com.study.spring.testImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.testImage.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
