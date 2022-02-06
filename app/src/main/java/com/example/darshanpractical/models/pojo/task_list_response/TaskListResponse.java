package com.example.darshanpractical.models.pojo.task_list_response;

import com.google.gson.annotations.SerializedName;

public class TaskListResponse{

	@SerializedName("paging")
	private Paging paging;

	@SerializedName("results")
	private Results results;

	public void setPaging(Paging paging){
		this.paging = paging;
	}

	public Paging getPaging(){
		return paging;
	}

	public void setResults(Results results){
		this.results = results;
	}

	public Results getResults(){
		return results;
	}
}