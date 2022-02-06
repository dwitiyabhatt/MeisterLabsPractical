package com.example.darshanpractical.models.pojo.task_list_response;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class TasksItem{

	@Ignore
	@SerializedName("assigned_to_id")
	private Object assignedToId;

	@Ignore
	@SerializedName("notes")
	private Object notes;

	@Ignore
	@SerializedName("created_by_origin")
	private String createdByOrigin;

	@Ignore
	@SerializedName("created_at")
	private String createdAt;

	@Ignore
	@SerializedName("flagged")
	private Object flagged;

	@Ignore
	@SerializedName("updated_at")
	private String updatedAt;

	@Ignore
	@SerializedName("section_id")
	private int sectionId;

	@Ignore
	@SerializedName("total_cl_items_count")
	private int totalClItemsCount;

	@Ignore
	@SerializedName("repeat")
	private Object repeat;

	@Ignore
	@SerializedName("attachment_id")
	private Object attachmentId;

	@PrimaryKey
	@ColumnInfo(name = "task_id")
	@SerializedName("id")
	private int id;

	@Ignore
	@SerializedName("status_updated_at")
	private String statusUpdatedAt;

	@Ignore
	@SerializedName("reminder")
	private Object reminder;

	@Ignore
	@SerializedName("meta_information")
	private Object metaInformation;

	@Ignore
	@SerializedName("tracked_time")
	private int trackedTime;

	@Ignore
	@SerializedName("priority")
	private Object priority;

	@Ignore
	@SerializedName("status_changed_by_id")
	private int statusChangedById;

	@Ignore
	@SerializedName("token")
	private String token;

	@Ignore
	@SerializedName("sequence")
	private double sequence;

	@Ignore
	@SerializedName("completed_at")
	private Object completedAt;

	@Ignore
	@SerializedName("closed_cl_items_count")
	private int closedClItemsCount;

	@Ignore
	@SerializedName("due")
	private Object due;

	@Ignore
	@SerializedName("comments_count")
	private int commentsCount;

	@ColumnInfo(name = "name")
	@SerializedName("name")
	private String name;

	@Ignore
	@SerializedName("created_by_id")
	private int createdById;

	@Ignore
	@SerializedName("attachments_count")
	private int attachmentsCount;

	@Ignore
	@SerializedName("status")
	private int status;

	public void setAssignedToId(Object assignedToId){
		this.assignedToId = assignedToId;
	}

	public Object getAssignedToId(){
		return assignedToId;
	}

	public void setNotes(Object notes){
		this.notes = notes;
	}

	public Object getNotes(){
		return notes;
	}

	public void setCreatedByOrigin(String createdByOrigin){
		this.createdByOrigin = createdByOrigin;
	}

	public String getCreatedByOrigin(){
		return createdByOrigin;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setFlagged(Object flagged){
		this.flagged = flagged;
	}

	public Object getFlagged(){
		return flagged;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSectionId(int sectionId){
		this.sectionId = sectionId;
	}

	public int getSectionId(){
		return sectionId;
	}

	public void setTotalClItemsCount(int totalClItemsCount){
		this.totalClItemsCount = totalClItemsCount;
	}

	public int getTotalClItemsCount(){
		return totalClItemsCount;
	}

	public void setRepeat(Object repeat){
		this.repeat = repeat;
	}

	public Object getRepeat(){
		return repeat;
	}

	public void setAttachmentId(Object attachmentId){
		this.attachmentId = attachmentId;
	}

	public Object getAttachmentId(){
		return attachmentId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatusUpdatedAt(String statusUpdatedAt){
		this.statusUpdatedAt = statusUpdatedAt;
	}

	public String getStatusUpdatedAt(){
		return statusUpdatedAt;
	}

	public void setReminder(Object reminder){
		this.reminder = reminder;
	}

	public Object getReminder(){
		return reminder;
	}

	public void setMetaInformation(Object metaInformation){
		this.metaInformation = metaInformation;
	}

	public Object getMetaInformation(){
		return metaInformation;
	}

	public void setTrackedTime(int trackedTime){
		this.trackedTime = trackedTime;
	}

	public int getTrackedTime(){
		return trackedTime;
	}

	public void setPriority(Object priority){
		this.priority = priority;
	}

	public Object getPriority(){
		return priority;
	}

	public void setStatusChangedById(int statusChangedById){
		this.statusChangedById = statusChangedById;
	}

	public int getStatusChangedById(){
		return statusChangedById;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public void setSequence(double sequence){
		this.sequence = sequence;
	}

	public double getSequence(){
		return sequence;
	}

	public void setCompletedAt(Object completedAt){
		this.completedAt = completedAt;
	}

	public Object getCompletedAt(){
		return completedAt;
	}

	public void setClosedClItemsCount(int closedClItemsCount){
		this.closedClItemsCount = closedClItemsCount;
	}

	public int getClosedClItemsCount(){
		return closedClItemsCount;
	}

	public void setDue(Object due){
		this.due = due;
	}

	public Object getDue(){
		return due;
	}

	public void setCommentsCount(int commentsCount){
		this.commentsCount = commentsCount;
	}

	public int getCommentsCount(){
		return commentsCount;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedById(int createdById){
		this.createdById = createdById;
	}

	public int getCreatedById(){
		return createdById;
	}

	public void setAttachmentsCount(int attachmentsCount){
		this.attachmentsCount = attachmentsCount;
	}

	public int getAttachmentsCount(){
		return attachmentsCount;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}