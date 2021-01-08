package com.mdl.home.service.impl;

import com.mdl.home.entity.UserToolsCategorySiteEntity;
import com.mdl.home.repository.UserToolsCategorySiteRepository;
import com.mdl.home.service.UserToolsCategorySiteService;
import com.mdl.home.vo.ToolsSiteVO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToolsCategorySiteServiceImpl implements UserToolsCategorySiteService {

  @Autowired
  private UserToolsCategorySiteRepository siteRepository;

  @Override
  public Map<String, List<ToolsSiteVO>> findByUsername(String userName) {
    List<UserToolsCategorySiteEntity> siteList = siteRepository
        .findAllByUserName(userName);
    Map<String, List<ToolsSiteVO>> collect = siteList.parallelStream().map(t -> {
      ToolsSiteVO toolsSiteVO = new ToolsSiteVO();
      toolsSiteVO.setImg(t.getImg());
      toolsSiteVO.setUrl(t.getUrl());
      toolsSiteVO.setIntro(t.getIntro());
      toolsSiteVO.setTitle(t.getTitle());
      toolsSiteVO.setIntro(t.getIntro());
      toolsSiteVO.setUserName(t.getUserName());
      toolsSiteVO.setCategoryName(t.getCategoryName());
      return toolsSiteVO;
    }).collect(Collectors.toList()).stream()
        .collect(Collectors.groupingBy(ToolsSiteVO::getCategoryName));
    return collect;
  }

}
