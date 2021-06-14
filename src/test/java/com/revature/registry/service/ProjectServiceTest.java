package com.revature.registry.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.registry.ProjectRegistryProjectApplication;
import com.revature.registry.model.Project;
import com.revature.registry.repository.ProjectRepository;
import com.revature.registry.service.ProjectService;

@SpringBootTest(classes = ProjectRegistryProjectApplication.class)
public class ProjectServiceTest {
	@MockBean
	ProjectRepository projectRepository;
	
	@Autowired
	ProjectService projectService;
	
	//Global variables
	static Project project1;
	static Project project2;
	static Project project3;
	
	@BeforeEach
	void init() {
		List<Project> projectList = new LinkedList<>();
		project1 = new Project();
		project2 = new Project();
		project3 = new Project();
		project1.setId(10);
		project2.setId(11);
		projectList.add(project1);
		projectList.add(project2);
		
		//Mock Repo
		when(projectRepository.findAll()).thenReturn(projectList);
		when(projectRepository.findById(project1.getId())).thenReturn(Optional.ofNullable(project1));
		when(projectRepository.save(project3)).thenReturn(project3);
	}

	@Test
	void testGetProjectByIdReturnObject() {
		assertThat(projectService.getProjectById(10)).isEqualTo(project1);
	}
	
	@Test
	void testGetProjectByIdReturnNull() {
		assertThat(projectService.getProjectById(1)).isNull();
	}
	
	@Test
	void testGetAllProjectsListNotEmpty() {
		assertThat(projectService.getAllProjects()).isNotEmpty();
	}
	
	@Test
	void testCreateProjectReturnObject() {
		assertThat(projectService.createProject(project3)).isEqualTo(project3);
	}
	
//	@Test
//	void testDeleteProjectByIdReturnTrue() {
//		assertThat(projectService.deleteProjectById(11)).isTrue();
//	}
	
	@Test
	void testDeleteProjectByIdReturnFalse() {
		assertThat(projectService.deleteProjectById(1)).isFalse();
	}
	
	@Test
	void testUpdateProjectById() {
		project1.setDescription("Testing");
		assertThat(projectService.updateProjectById(project1.getId(), project1)).isEqualTo(project1);
	}
}
