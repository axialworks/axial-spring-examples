package com.axial.examples.multiple_database.database.app_db.repository.jpa;

import com.axial.examples.multiple_database.database.app_db.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findAll();

}
