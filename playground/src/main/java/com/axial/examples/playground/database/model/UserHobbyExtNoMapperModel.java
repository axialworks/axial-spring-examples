package com.axial.examples.playground.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserHobbyExtNoMapperModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickname;

    private String name;

    private Long hobbyId;

    private String hobbyName;

}
