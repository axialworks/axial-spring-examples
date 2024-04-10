package com.axial.examples.multiple_database.database.app_db.model;

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
public class CategoryModel implements RowMapper<CategoryModel>, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;

    private String name;

    private Boolean deleted;

    @Override
    public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        final CategoryModel model = new CategoryModel();

        model.setId(rs.getLong(ColumnNames.ID));
        model.setCode(rs.getString(ColumnNames.CODE));
        model.setName(rs.getString(ColumnNames.NAME));
        model.setDeleted(rs.getBoolean(ColumnNames.DELETED));

        return model;
    }

    @Getter
    public class ColumnNames {

        public static final String ID = "CT_ID";
        public static final String CODE = "CT_CODE";
        public static final String NAME ="CT_NAME";
        public static final String DELETED = "CT_DELETED";
    }

}
