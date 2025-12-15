package com.springboot_docker_postgresql.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class SoftwareEngineerService {
	private final SoftwareEngineerRepo softwareEngineerRepo;
	
	public SoftwareEngineerService(SoftwareEngineerRepo softwareEngineerRepo) {
		this.softwareEngineerRepo = softwareEngineerRepo;
	}
	
	public List<SoftwareEngineer> getSoftwareEngineers(){
		return softwareEngineerRepo.findAll();
	}
	
	public SoftwareEngineer getSoftwareEngineer(Integer id) {
		return softwareEngineerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id+" not found"));
	}
	
	public SoftwareEngineer addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
		return softwareEngineerRepo.save(softwareEngineer);
	}
	
	public SoftwareEngineer updateSoftwareEngineer(SoftwareEngineer softwareEngineer) {
		return softwareEngineerRepo.save(softwareEngineer);
	}
	
	public void deleteSoftwareEngineer(SoftwareEngineer softwareEngineer) {
		softwareEngineerRepo.delete(softwareEngineer);
	}
}
