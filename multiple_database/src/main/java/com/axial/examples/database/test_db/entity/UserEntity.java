package com.axial.examples.database.test_db.entity;

import com.axial.examples.enums.Gender;
import com.axial.examples.database.test_db.converter.GenderConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "dm_tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_NICKNAME", length = 128)
    private String nickname;

    @Column(name = "USR_NAME", length = 256)
    private String name;

    @Column(name = "USR_SURNAME", length = 512)
    private String surname;

    @Column(name = "USR_AGE")
    private Integer age;

    @Column(name = "USR_GENDER")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column(name = "USR_ACTIVE")
    private Boolean active;

    @Column(name = "USR_NOTES", length = 2048)
    private String notes;

}
