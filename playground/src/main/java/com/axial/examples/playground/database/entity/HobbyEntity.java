package com.axial.examples.playground.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "dm_tbl_hobby")
public class HobbyEntity {

    @Id
    @Column(name = "HOBBY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HOBBY_NAME", length = 64)
    private String name;

    @Column(name = "HOBBY_EXPLANATION", length = 512)
    private String explanation;

}
