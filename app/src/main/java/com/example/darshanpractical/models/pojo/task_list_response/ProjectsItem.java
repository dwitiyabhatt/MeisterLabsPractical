package com.example.darshanpractical.models.pojo.task_list_response;

import com.google.gson.annotations.SerializedName;

public class ProjectsItem{

	@SerializedName("share_token_enabled")
	private boolean shareTokenEnabled;

	@SerializedName("notes")
	private Object notes;

	@SerializedName("color")
	private String color;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("share_mode")
	private int shareMode;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("type")
	private Object type;

	@SerializedName("roles_enabled")
	private boolean rolesEnabled;

	@SerializedName("trashed_at")
	private Object trashedAt;

	@SerializedName("token")
	private String token;

	@SerializedName("mail_token")
	private String mailToken;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("tasks_active_count")
	private int tasksActiveCount;

	@SerializedName("tasks_trash_count")
	private int tasksTrashCount;

	@SerializedName("share_token")
	private Object shareToken;

	@SerializedName("name")
	private String name;

	@SerializedName("tasks_complete_count")
	private int tasksCompleteCount;

	@SerializedName("creator_id")
	private Object creatorId;

	@SerializedName("creator_name")
	private Object creatorName;

	@SerializedName("id")
	private int id;

	@SerializedName("tasks_archive_count")
	private int tasksArchiveCount;

	@SerializedName("status")
	private int status;

	public void setShareTokenEnabled(boolean shareTokenEnabled){
		this.shareTokenEnabled = shareTokenEnabled;
	}

	public boolean isShareTokenEnabled(){
		return shareTokenEnabled;
	}

	public void setNotes(Object notes){
		this.notes = notes;
	}

	public Object getNotes(){
		return notes;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setShareMode(int shareMode){
		this.shareMode = shareMode;
	}

	public int getShareMode(){
		return shareMode;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setType(Object type){
		this.type = type;
	}

	public Object getType(){
		return type;
	}

	public void setRolesEnabled(boolean rolesEnabled){
		this.rolesEnabled = rolesEnabled;
	}

	public boolean isRolesEnabled(){
		return rolesEnabled;
	}

	public void setTrashedAt(Object trashedAt){
		this.trashedAt = trashedAt;
	}

	public Object getTrashedAt(){
		return trashedAt;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setMailToken(String mailToken){
		this.mailToken = mailToken;
	}

	public String getMailToken(){
		return mailToken;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setTasksActiveCount(int tasksActiveCount){
		this.tasksActiveCount = tasksActiveCount;
	}

	public int getTasksActiveCount(){
		return tasksActiveCount;
	}

	public void setTasksTrashCount(int tasksTrashCount){
		this.tasksTrashCount = tasksTrashCount;
	}

	public int getTasksTrashCount(){
		return tasksTrashCount;
	}

	public void setShareToken(Object shareToken){
		this.shareToken = shareToken;
	}

	public Object getShareToken(){
		return shareToken;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTasksCompleteCount(int tasksCompleteCount){
		this.tasksCompleteCount = tasksCompleteCount;
	}

	public int getTasksCompleteCount(){
		return tasksCompleteCount;
	}

	public void setCreatorId(Object creatorId){
		this.creatorId = creatorId;
	}

	public Object getCreatorId(){
		return creatorId;
	}

	public void setCreatorName(Object creatorName){
		this.creatorName = creatorName;
	}

	public Object getCreatorName(){
		return creatorName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTasksArchiveCount(int tasksArchiveCount){
		this.tasksArchiveCount = tasksArchiveCount;
	}

	public int getTasksArchiveCount(){
		return tasksArchiveCount;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}