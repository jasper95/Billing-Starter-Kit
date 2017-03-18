package com.jasperprojects.starter.service;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.jasperprojects.starter.service.dto.UserDTO;


public interface DataTableService {
    DataSet<UserDTO> getUsersDataTable(DatatablesCriterias criterias);
}
