package com.axial.examples.playground.database.repository.entity_manager;


import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserDao {

    private static final String SELECT_QUERY =
            "SELECT"
                + "U.id, U.name, U.nickname, H.id AS hobbyId, H.name AS hobbyName"
            + " FROM UserHobbyEntity UH"
            + " LEFT JOIN UserEntity U ON U.id = UH.userId"
            + " LEFT JOIN HobbyEntity H ON H.id = UH.hobbyId";

    private final EntityManager entityManager;


}
