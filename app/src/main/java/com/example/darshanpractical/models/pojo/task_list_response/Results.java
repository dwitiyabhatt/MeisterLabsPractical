package com.example.darshanpractical.models.pojo.task_list_response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results{

	@SerializedName("projects")
	private List<ProjectsItem> projects;

	@SerializedName("tasks")
	private List<TasksItem> tasks;

	@SerializedName("sections")
	private List<SectionsItem> sections;

	public void setProjects(List<ProjectsItem> projects){
		this.projects = projects;
	}

	public List<ProjectsItem> getProjects(){
		return projects;
	}

	public void setTasks(List<TasksItem> tasks){
		this.tasks = tasks;
	}

	public List<TasksItem> getTasks(){
		return tasks;
	}

	public void setSections(List<SectionsItem> sections){
		this.sections = sections;
	}

	public List<SectionsItem> getSections(){
		return sections;
	}
}