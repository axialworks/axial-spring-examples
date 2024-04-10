package com.axial.examples.multiple_database.database.test_db.repository.jpa;

import com.axial.examples.multiple_database.database.test_db.entity.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {

    List<HobbyEntity> findAll();

}
