package com.example.darshanpractical.models.pojo.task_list_response;

import com.google.gson.annotations.SerializedName;

public class SectionsItem{

	@SerializedName("indicator")
	private int indicator;

	@SerializedName("color")
	private String color;

	@SerializedName("object_actions_count")
	private int objectActionsCount;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("description")
	private Object description;

	@SerializedName("sequence")
	private double sequence;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("project_id")
	private int projectId;

	@SerializedName("name")
	private String name;

	@SerializedName("limit")
	private Object limit;

	@SerializedName("recurring_actions_count")
	private int recurringActionsCount;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private int status;

	public void setIndicator(int indicator){
		this.indicator = indicator;
	}

	public int getIndicator(){
		return indicator;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setObjectActionsCount(int objectActionsCount){
		this.objectActionsCount = objectActionsCount;
	}

	public int getObjectActionsCount(){
		return objectActionsCount;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setSequence(double sequence){
		this.sequence = sequence;
	}

	public double getSequence(){
		return sequence;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setProjectId(int projectId){
		this.projectId = projectId;
	}

	public int getProjectId(){
		return projectId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLimit(Object limit){
		this.limit = limit;
	}

	public Object getLimit(){
		return limit;
	}

	public void setRecurringActionsCount(int recurringActionsCount){
		this.recurringActionsCount = recurringActionsCount;
	}

	public int getRecurringActionsCount(){
		return recurringActionsCount;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}