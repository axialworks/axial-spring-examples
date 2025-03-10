package com.axial.examples.multiple_database.database.test_db.converter;

import com.axial.examples.multiple_database.enums.Gender;
import com.axial.modules.commons.outline.enum_code.EnumCodeConverter;


public class GenderConverter extends EnumCodeConverter<Gender> {

    @Override
    public Class<Gender> getClassType() {
        return Gender.class;
    }
}
