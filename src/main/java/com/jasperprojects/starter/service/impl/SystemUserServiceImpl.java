/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasperprojects.starter.service.impl;


import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.jasperprojects.starter.domain.Role;
import com.jasperprojects.starter.domain.User;
import com.jasperprojects.starter.repository.DataTableRepository;
import com.jasperprojects.starter.repository.RoleRepository;
import com.jasperprojects.starter.repository.UserRepository;
import com.jasperprojects.starter.service.SystemUserService;
import com.jasperprojects.starter.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bert
 */
@Service("userService")
public class SystemUserServiceImpl implements SystemUserService {


    private UserRepository userRepo;
    private RoleRepository roleRepo;


    @Autowired
    public SystemUserServiceImpl(UserRepository userRepo, RoleRepository roleRepo,
                                 DataTableRepository dataTableRepository){
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        user.setRoles(new HashSet<>(findRolesAllowedByUserType(user.getType().getValue())));
        return userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findRolesAllowedByUserType(String userType) {
        List<String> roleNames = new ArrayList<>();
        switch(userType){
            case "SUPERUSER":
                roleNames = Arrays.asList("ACCOUNTS", "READINGS", "REPORTS", "PAYMENTS", "SYSTEM");
                break;
            case "ENCODER":
                roleNames = Arrays.asList("ACCOUNTS", "READINGS", "REPORTS", "PAYMENTS");
                break;
            case "TREASURER":
                roleNames = Arrays.asList("PAYMENTS", "REPORTS");
                break;
            case "REPORTS_VIEWER":
                roleNames = Arrays.asList("REPORTS");
        }

        return roleNames.stream()
                .map(e -> roleRepo.findByRoleName(e))
                .collect(Collectors.toList());
    }
}
