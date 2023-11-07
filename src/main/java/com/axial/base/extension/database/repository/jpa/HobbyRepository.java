package com.axial.base.extension.database.repository.jpa;

import com.axial.base.extension.database.entity.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {

    List<HobbyEntity> findAll();

}
