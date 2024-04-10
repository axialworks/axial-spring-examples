package com.axial.examples.single_database.database.entity;

import com.axial.examples.single_database.database.composite_pk.UserHobbyId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(UserHobbyId.class)
@Table(name = "dm_tbl_user_hobby")
public class UserHobbyEntity {

    @Id
    @Column(name = "USRHBY_USR_ID")
    private Long userId;

    @Id
    @Column(name = "USRHBY_HOBBY_ID")
    private Long hobbyId;

}
