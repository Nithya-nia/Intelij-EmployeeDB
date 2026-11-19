package org.example.employeedb;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@jakarta.persistence.Entity
public class Entity {

    @Id
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    private String dpt;


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }


}
