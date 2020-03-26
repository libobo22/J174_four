package com.project.service.impl;

import com.project.dao.BasicDao;
import com.project.dao.IUserDao;
import com.project.dto.UserPermissionDTO;
import com.project.entity.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserEntity login(String loginName, String password) {
        return userDao.login(loginName,password);
    }

    @Override
    public List<UserPermissionDTO> findPermissionByLoginName(String loginName) {
        List<Object[]> objList=userDao.findPermissionByLoginName(loginName);
        List<UserPermissionDTO> list=null;
        if (objList!=null&&objList.size()!=0){
            list=new ArrayList<>();
            for (Object[] obj:
                 objList) {
                UserPermissionDTO userPerDto= new UserPermissionDTO();
                userPerDto.setUserName((String) obj[0]);
                userPerDto.setPerName((String) obj[1]);
                userPerDto.setPerURL((String) obj[2]);
                list.add(userPerDto);
            }
        }
        return list;
    }
}
