package com.axial.examples.playground.database.repository.jdbc_template;

import com.axial.examples.playground.database.model.UserHobbyExtRowMapperModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    /*
     * JDBC kullanılacağı zaman @AllArgsConstructor çalışırken sıkıntı çıkarıyor.
     * Sürekli son initialize edilen DataSource'u kullanıyor.
     * İki Datasource ve JDBC bağlantısını da kullanabilmek için aşağıdaki gibi bir constructor kullanmamız gerekiyor.
     */
    public UserJdbcDao(NamedParameterJdbcTemplate namedJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserHobbyExtRowMapperModel> getUserHobbyExtModelsWithJdbcTemplate() {
        return jdbcTemplate.query(getUserHobbyExtSQL, new UserHobbyExtRowMapperModel());
    }

    public List<UserHobbyExtRowMapperModel> getUserHobbyExtModelsWithNamedJdbcTemplate() {

        /*
            // Eğer bir parametre de geçilecekse böyle yapılacak.
            // Sorgu içinde parametreler şöyle kullanılıyor: TB.col = :filterText
            // List için de şöyle kullanılıyor: TB.col IN (:filterTextList)
            // LIKE sorguları için şöyle kullanılıyor: TB.col LIKE '%' || :filterText || '%'

            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("searchText", searchText);
         */
        return namedJdbcTemplate.query(getUserHobbyExtSQL, (MapSqlParameterSource) null, new UserHobbyExtRowMapperModel());

    }

}
