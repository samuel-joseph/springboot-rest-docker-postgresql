package com.springboot_docker_postgresql.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepo extends JpaRepository<SoftwareEngineer, Integer>{
	
}
