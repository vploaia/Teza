package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.DomainProject;
import com.vlad.model.Project;

public interface ProjectService {
	public void addProject(Project project);
	public void updateProject(Project project);
	public Project getProject(int id);
	public void deleteProject(int id);
	public List<Project> getProjects();
	public List<DomainProject> getDomains();
	public DomainProject getDomain(int id);
	public List<Project> getSearchProjects(String text);

}
