package com.axial.examples.playground.database.composite_pk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor // Bu olmazsa JPA Repository sorun çıkarıyor
@AllArgsConstructor
public class UserHobbyId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long hobbyId;

}
