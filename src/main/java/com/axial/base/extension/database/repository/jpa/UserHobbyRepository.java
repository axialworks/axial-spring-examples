package com.axial.base.extension.database.repository.jpa;

import com.axial.base.extension.database.composite_pk.UserHobbyId;
import com.axial.base.extension.database.entity.UserHobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHobbyRepository extends JpaRepository<UserHobbyEntity, UserHobbyId> {

    List<UserHobbyEntity> findAll();

}
