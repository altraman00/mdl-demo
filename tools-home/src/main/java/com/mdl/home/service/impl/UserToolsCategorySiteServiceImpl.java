package com.mdl.home.service.impl;

import com.mdl.home.entity.UserToolsCategorySiteEntity;
import com.mdl.home.repository.UserToolsCategorySiteRepository;
import com.mdl.home.service.UserToolsCategorySiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToolsCategorySiteServiceImpl implements UserToolsCategorySiteService {

    @Autowired
    private UserToolsCategorySiteRepository siteRepository;

    @Override
    public List<UserToolsCategorySiteEntity> findByUserId(String userId) {
        return siteRepository.findAllByUserId(userId);
    }
}
