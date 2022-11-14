package com.vjj.springbootbackend.repository;

import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.vjj.springbootbackend.model.Employee;

@Repository
@Qualifier("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
List<Employee> findByActive(boolean active);	


Optional<Employee> findByIdAndActive(Long id, boolean active);	

//List<Employee> findByActiveSolr(SolrQuery query);	
//Optional<Employee> findByIdAndActive(SolrQuery query);	

}
