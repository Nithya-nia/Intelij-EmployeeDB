package org.example.employeedb;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class Controller {

    public Controller(Service service)
    {
        this.service = service;
    }

    public Service service;

    @GetMapping("/employee")
    public List<Entity> getEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Entity getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/employeedetails")
    public Entity createEmployee(@RequestBody Entity entity) {
        return service.createEmployee(entity);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    @PutMapping("/updateemployee/{id}")
    public Entity updateEmployee(@PathVariable int id,@RequestBody Entity entity){
        return service.updateEmployee(id,entity);
    }

    @GetMapping("/getemployeeasync")
    public CompletableFuture<List<Entity>> getEmployeeByAsync() {

        return service.getEmployeeByAsync();
    }




}
