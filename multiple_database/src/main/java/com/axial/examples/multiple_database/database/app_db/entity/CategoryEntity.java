package com.axial.examples.multiple_database.database.app_db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tbl_category")
public class CategoryEntity {

    @Id
    @Column(name = "CT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CT_CODE", length = 128)
    private String code;

    @Column(name = "CT_NAME", length = 256)
    private String name;

    @Column(name = "CT_PARENT_CODE", length = 128)
    private String parentCode;

    @Column(name = "CT_DELETED")
    private Boolean deleted;

    @Column(name = "CT_NOTE", length = 2048)
    private String note;

}
