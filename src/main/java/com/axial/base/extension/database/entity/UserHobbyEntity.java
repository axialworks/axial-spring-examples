package com.axial.base.extension.database.entity;

import com.axial.base.extension.database.composite_pk.UserHobbyId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(UserHobbyId.class)
@Table(name = "DM_TBL_USER_HOBBY")
public class UserHobbyEntity {

    @Id
    @Column(name = "USRHBY_USR_ID")
    private Long userId;

    @Id
    @Column(name = "USRHBY_HOBBY_ID")
    private Long hobbyId;

}
