package com.jasperprojects.starter.web;


import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;
import com.jasperprojects.starter.service.DataTableService;
import com.jasperprojects.starter.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data-tables")
public class DataTablesApi {

    private DataTableService dataTableService;

    @Autowired
    public DataTablesApi(DataTableService dataTableService){
        this.dataTableService = dataTableService;
    }

    @GetMapping("/users")
    public DatatablesResponse<UserDTO> getUserDataTable(@DatatablesParams DatatablesCriterias criterias){
        DataSet<UserDTO> dataSet = dataTableService.getUsersDataTable(criterias);
        return DatatablesResponse.build(dataSet, criterias);
    }
}
