package com.axial.examples.multiple_database.database.test_db.repository.jpa;

import com.axial.examples.multiple_database.database.test_db.entity.UserEntity;
import com.axial.examples.multiple_database.database.test_db.model.UserHobbyExtNoMapperModel;
import com.axial.examples.multiple_database.database.test_db.model.UserHobbyExtRowMapperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();


    @Query(
            "SELECT"
                + " new com.axial.examples.multiple_database.database.test_db.model.UserHobbyExtNoMapperModel("
                    + "U.id, U.name, U.nickname, H.id, H.name"
                + ")"
            + " FROM UserHobbyEntity UH"
            + " LEFT JOIN UserEntity U ON U.id = UH.userId"
            + " LEFT JOIN HobbyEntity H ON H.id = UH.hobbyId"
    )
    List<UserHobbyExtNoMapperModel> findUserHobbyExtNoMapperList();

    /*
        Bu senaryoda JPA metodu bir HashMap dönüyor.
        Dönen değer bir objectType'a map edilmiyor.
     */
    @Query(
            "SELECT"
                + " U.id AS " + UserHobbyExtRowMapperModel.ColumnNames.ID + ","
                + " U.name AS " + UserHobbyExtRowMapperModel.ColumnNames.USER_NAME + ","
                + " U.nickname AS " + UserHobbyExtRowMapperModel.ColumnNames.NICKNAME + ","
                + " H.id AS " + UserHobbyExtRowMapperModel.ColumnNames.HOBBY_ID + ","
                + " H.name AS " + UserHobbyExtRowMapperModel.ColumnNames.HOBBY_NAME
            + " FROM UserHobbyEntity UH"
            + " LEFT JOIN UserEntity U ON U.id = UH.userId"
            + " LEFT JOIN HobbyEntity H ON H.id = UH.hobbyId"
    )
    List<Map<String, Object>> findUserHobbyExtHashMapList();

}
