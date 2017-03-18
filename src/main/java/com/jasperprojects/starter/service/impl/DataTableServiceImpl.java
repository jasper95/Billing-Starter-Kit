package com.jasperprojects.starter.service.impl;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.jasperprojects.starter.domain.User;
import com.jasperprojects.starter.repository.DataTableRepository;
import com.jasperprojects.starter.service.DataTableService;
import com.jasperprojects.starter.service.dto.UserDTO;
import com.jasperprojects.starter.util.DataTableDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DataTableServiceImpl implements DataTableService {

    private DataTableRepository dataTableRepository;

    @Autowired
    public DataTableServiceImpl(DataTableRepository dataTableRepository){
        this.dataTableRepository = dataTableRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public DataSet<UserDTO> getUsersDataTable(DatatablesCriterias criteria) {
        Class tClass = User.class;
        Long count = dataTableRepository.getTotalCount(tClass);
        if(DataTableDaoUtil.hasFilteredColumn(criteria)){
            List<User> results = queryCriterias(criteria, tClass);
            Long countFiltered = getQueryCount(criteria, tClass);
            return new DataSet<>(results.stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList()), count, countFiltered);
        } else return new DataSet<>(new ArrayList<>(), count, 0L);
    }
    
    private <T> List <T> queryCriterias(DatatablesCriterias criteria, Class<T> tClass){
        return dataTableRepository.findWithDataTablesCriteria(criteria, tClass);
    }

    private Long getQueryCount(DatatablesCriterias criteria, Class tClass) {
        return dataTableRepository.getFilteredCount(criteria, tClass);
    }
}
