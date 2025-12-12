package com.springboot_docker_postgresql.demo;

import java.util.Objects;

public class SoftwareEngineer {
	private Integer id;
	private String name;
	private String techStack;
	
	public SoftwareEngineer(Integer id, String name, String techStack) {
		super();
		this.id = id;
		this.name = name;
		this.techStack = techStack;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, techStack);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftwareEngineer other = (SoftwareEngineer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(techStack, other.techStack);
	}
	
	
}
