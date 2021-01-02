package com.mdl.home.repository;

import com.mdl.home.entity.UserToolsCategorySiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserToolsCategorySiteRepository extends JpaRepository<UserToolsCategorySiteEntity, String> {

    List<UserToolsCategorySiteEntity> findAllByUserId(String userId);

}