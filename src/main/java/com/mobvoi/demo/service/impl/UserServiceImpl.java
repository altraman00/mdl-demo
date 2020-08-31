package com.mobvoi.demo.service.impl;

import com.mobvoi.demo.entity.SysUserEntity;
import com.mobvoi.demo.repository.SysUserRepository;
import com.mobvoi.demo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Project : mobvoi-demo
 * @Package Name : com.mdl.mobvoi.service.impl
 * @Description : TODO
 * @Author : knight
 * @Create Date : 2020年08月24日 16:12
 * @ModificationHistory Who   When     What
 * ------------    --------------    ---------------------------------
 */

@Service
public class UserServiceImpl implements UserService {


  @Autowired
  private SysUserRepository sysUserRepository;

  @Override
  public String findById(String id) {

    Optional<SysUserEntity> byId = sysUserRepository.findById(id);

    String name = byId.get().getName();

    SysUserEntity byName = sysUserRepository.findByName(name);

    String age = byName.getAge();

    List<SysUserEntity> allByName = sysUserRepository.findAllByAge(age);

    String collect = allByName.stream().map(SysUserEntity::getName).collect(Collectors.joining("，"));

    return collect;
  }

}
