package org.example.employeedb;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.concurrent.CompletableFuture;


@org.springframework.stereotype.Service
public class Service {
    private static final Logger logger =
             LoggerFactory.getLogger(Service.class);

    public Repository repository;

    public Service(Repository repository){

        this.repository=repository;
    }


    @Transactional(readOnly = true)
    @Cacheable(value = "employees")
    public List<Entity> getEmployee() {
        logger.info("Fetching all employees");
        return repository.findAll();
    }

    @Transactional
    @CacheEvict(value = "employees", allEntries = true)
    public Entity createEmployee(Entity entity) {
        logger.info("Creating employee");
        return repository.save(entity);
    }

    @Transactional
    @CacheEvict(value = "employees", allEntries = true)
    public String deleteEmployee(int id) {
        logger.info("Deleting employee with ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Employee not found with ID: {}", id);
            return "Employee not found";
        }
        repository.deleteById(id);
        logger.info("Employee deleted successfully");
        return "Employee deleted Successfully";
    }

    @Transactional
    @CacheEvict(value = "employees", allEntries = true)
    public Entity updateEmployee(int id,Entity newEntity){

        if(!repository.existsById(id)){
            return null;
        }
        newEntity.setId(id);
        return repository.save(newEntity);
    }

    public Entity getEmployeeById(int id){
        if(id <=0){
            throw new IllegalArgumentException("Invalid ID");
        }
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found with ID:" + id));
    }

    @Async
    public CompletableFuture<List<Entity>> getEmployeeByAsync(){
        List<Entity> employees = repository.findAll();

        return CompletableFuture.completedFuture(employees);
    }









}
