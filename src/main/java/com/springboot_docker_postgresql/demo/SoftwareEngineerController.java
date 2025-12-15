package com.springboot_docker_postgresql.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/software-engineers") 
public class SoftwareEngineerController {
	private final SoftwareEngineerService softwareEngineerService;
	
	public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
		this.softwareEngineerService = softwareEngineerService;
	}
	
	@GetMapping("/all")
	public List<SoftwareEngineer> getEngineers(){
		return softwareEngineerService.getSoftwareEngineers();
	}
	
	@GetMapping("/{id}")
	public SoftwareEngineer getEngineer(@PathVariable Integer id) {
		return softwareEngineerService.getSoftwareEngineer(id);
	}
	
	@PostMapping("/add")
	public SoftwareEngineer addEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
		return softwareEngineerService.addSoftwareEngineer(softwareEngineer);
	}
	
	@PutMapping("/put")
	public SoftwareEngineer updateEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
		return softwareEngineerService.updateSoftwareEngineer(softwareEngineer);
	}
	
	@DeleteMapping("/delete")
	public void deleteEngineer(SoftwareEngineer softwareEngineer) {
		softwareEngineerService.deleteSoftwareEngineer(softwareEngineer);
	}
}
