package com.mdl.home.service;

import com.mdl.home.entity.UserToolsCategorySiteEntity;

import java.util.List;

public interface UserToolsCategorySiteService {

    List<UserToolsCategorySiteEntity> findByUserId(String userId);

}
