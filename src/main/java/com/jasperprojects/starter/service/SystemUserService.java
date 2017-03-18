/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasperprojects.starter.service;


import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.jasperprojects.starter.domain.Role;
import com.jasperprojects.starter.domain.User;
import com.jasperprojects.starter.service.dto.UserDTO;

import java.util.List;

/**
 * interface created for system users module.
 * @author Bert
 */
public interface SystemUserService {
    User saveUser(User user);
    List<Role> findRolesAllowedByUserType(String userType);
}
