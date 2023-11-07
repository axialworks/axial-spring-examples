package com.axial.base.extension.database.repository.jpa;

import com.axial.base.extension.database.entity.UserEntity;
import com.axial.base.extension.database.model.UserHobbyExtNoMapperModel;
import com.axial.base.extension.database.model.UserHobbyExtRowMapperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    @Query(
            "SELECT"
                + " new com.axial.base.extension.database.model.UserHobbyExtNoMapperModel("
                    + "U.id, U.name, U.nickname, H.id, H.name"
                + ")"
            + " FROM UserHobbyEntity UH"
            + " LEFT JOIN UserEntity U ON U.id = UH.userId"
            + " LEFT JOIN HobbyEntity H ON H.id = UH.hobbyId"
    )
    List<UserHobbyExtNoMapperModel> findUserCityExtNoMapperList();


    // NO WORKING!!!!!!!!!!!
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
    List<UserHobbyExtRowMapperModel> findUserCityExtRowMapperConstList();

}
