package com.axial.examples.multiple_database.database.test_db.repository.jpa;

import com.axial.examples.multiple_database.database.test_db.entity.UserHobbyEntity;
import com.axial.examples.multiple_database.database.test_db.composite_pk.UserHobbyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHobbyRepository extends JpaRepository<UserHobbyEntity, UserHobbyId> {

    List<UserHobbyEntity> findAll();

}
