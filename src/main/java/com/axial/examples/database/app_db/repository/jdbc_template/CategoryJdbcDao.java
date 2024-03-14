package com.axial.examples.database.app_db.repository.jdbc_template;

import com.axial.examples.database.app_db.model.CategoryModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryJdbcDao {

    /*
     TABLO İSİMLERİ ÖZELLİKLE CASE SENSITIVE
     DB TARAFINDA KÜÇÜK HARF, BURADA BÜYÜK HARF OLUNCA ÇALIŞMIYOR, TABLOYU GÖRMÜYOR
    */
    private final static String getCategoriesSQL =
            "SELECT"
                    + " C.CT_ID AS " + CategoryModel.ColumnNames.ID + ","
                    + " C.CT_CODE AS " + CategoryModel.ColumnNames.CODE + ","
                    + " C.CT_NAME AS " + CategoryModel.ColumnNames.NAME + ","
                    + " C.CT_DELETED AS " + CategoryModel.ColumnNames.DELETED
                    + " FROM tbl_category C";

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    /*
     * JDBC kullanılacağı zaman @AllArgsConstructor çalışırken sıkıntı çıkarıyor.
     * Sürekli son initialize edilen DataSource'u kullanıyor.
     * İki Datasource ve JDBC bağlantısını da kullanabilmek için aşağıdaki gibi bir constructor kullanmamız gerekiyor.
     */
    public CategoryJdbcDao(@Qualifier("namedParameterJdbcTemplateApp") NamedParameterJdbcTemplate namedJdbcTemplate,
                           @Qualifier("jdbcTemplateApp") JdbcTemplate jdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CategoryModel> getCategoryListWithJdbcTemplate() {
        return jdbcTemplate.query(getCategoriesSQL, new CategoryModel());
    }

}
