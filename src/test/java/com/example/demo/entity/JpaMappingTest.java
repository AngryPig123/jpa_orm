package com.example.demo.entity;


import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaMappingTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    void insertCompanyRepository() {

        Company company = new Company("core");
        companyRepository.save(company);

        Employee employee = new Employee("홍길동", company);
        employee.relationshipWithACompany(company);
        employeeRepository.save(employee);

        Optional<Employee> byId = employeeRepository.findById(1L);
        log.info("employee: {}", byId.get());

        entityManager.flush();
        entityManager.clear();

    }

}