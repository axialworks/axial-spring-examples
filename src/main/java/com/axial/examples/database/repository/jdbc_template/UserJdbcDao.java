package com.axial.examples.database.repository.jdbc_template;

import com.axial.examples.database.model.UserHobbyExtRowMapperModel;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserJdbcDao {

    /*
        TABLO İSİMLERİ ÖZELLİKLE CASE SENSITIVE
        DB TARAFINDA KÜÇÜK HARF, BURADA BÜYÜK HARF OLUNCA ÇALIŞMIYOR, TABLOYU GÖRMÜYOR
     */
    private final static String getUserHobbyExtSQL =
            "SELECT"
                + " U.USR_ID AS " + UserHobbyExtRowMapperModel.ColumnNames.ID + ","
                + " U.USR_NAME AS " + UserHobbyExtRowMapperModel.ColumnNames.USER_NAME + ","
                + " U.USR_NICKNAME AS " + UserHobbyExtRowMapperModel.ColumnNames.NICKNAME + ","
                + " H.HOBBY_ID AS " + UserHobbyExtRowMapperModel.ColumnNames.HOBBY_ID + ","
                + " H.HOBBY_NAME AS " + UserHobbyExtRowMapperModel.ColumnNames.HOBBY_NAME
            + " FROM dm_tbl_user_hobby UH"
            + " LEFT JOIN dm_tbl_user U ON U.USR_ID = UH.USRHBY_USR_ID"
            + " LEFT JOIN dm_tbl_hobby H ON H.HOBBY_ID = UH.USRHBY_HOBBY_ID";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<UserHobbyExtRowMapperModel> getUserHobbyExtModels() {

        /*
            // Eğer bir parametre de geçilecekse böyle yapılacak.
            // Sorgu içinde parametreler şöyle kullanılıyor: TB.col = :filterText
            // List için de şöyle kullanılıyor: TB.col IN (:filterTextList)
            // LIKE sorguları için şöyle kullanılıyor: TB.col LIKE '%' || :filterText || '%'

            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("searchText", searchText);
         */
        return jdbcTemplate.query(getUserHobbyExtSQL, (MapSqlParameterSource) null, new UserHobbyExtRowMapperModel());

    }

}
