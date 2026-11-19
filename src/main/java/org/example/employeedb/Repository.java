package org.example.employeedb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Entity,Integer> {
}
