package com.example.demo.services;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> list = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeRepository
                .findAll()) {
            EmployeeDTO map = modelMapper.map(employeeEntity, EmployeeDTO.class);
            list.add(map);
        }
        return list;
    }

    public boolean deleteEmployeeById(Long id){
        boolean isPresent = employeeRepository.existsById(id);
        if (!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;

    }
}
