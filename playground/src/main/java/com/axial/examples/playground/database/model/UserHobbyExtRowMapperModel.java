package com.axial.examples.playground.database.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
public class UserHobbyExtRowMapperModel implements RowMapper<UserHobbyExtRowMapperModel>, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickname;

    private String name;

    private Long hobbyId;

    private String hobbyName;

    @Override
    public UserHobbyExtRowMapperModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        final UserHobbyExtRowMapperModel model = new UserHobbyExtRowMapperModel();

        model.setId(rs.getLong(ColumnNames.ID));
        model.setNickname(rs.getString(ColumnNames.NICKNAME));
        model.setName(rs.getString(ColumnNames.USER_NAME));
        model.setHobbyId(rs.getLong(ColumnNames.HOBBY_ID));
        model.setHobbyName(rs.getString(ColumnNames.HOBBY_NAME));

        return model;
    }

    /*
    public UserHobbyExtRowMapperConstModel(Map<String, Object> resultData) throws SQLException {

        this.id = (Long) resultData.get(ColumnNames.ID);
        this.nickname = (String) resultData.get(ColumnNames.NICKNAME);
        this.name = (String) resultData.get(ColumnNames.USER_NAME);
        this.hobbyId = (Long) resultData.get(ColumnNames.HOBBY_ID);
        this.hobbyName = (String) resultData.get(ColumnNames.HOBBY_NAME);
    }
     */

    @Getter
    public class ColumnNames {

        public static final String ID = "ID";
        public static final String NICKNAME = "NICKNAME";
        public static final String USER_NAME ="USER_NAME";
        public static final String HOBBY_ID = "HOBBY_ID";
        public static final String HOBBY_NAME = "HOBBY_NAME";
    }

}
