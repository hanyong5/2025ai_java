package com.study.spring.testImage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.testImage.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

//	select t.id,t.title,t.name,t.content,i.id,i.stored_name
//	from test_entity t
//	join test_image i on t.id = i.testentity_id
//	where t.id = 4
	
	@Query("select t from TestEntity t left join fetch t.imageList where t.id = :id")
	Optional<TestEntity> findByIdWidthImages(@Param("id") Long id);

}
