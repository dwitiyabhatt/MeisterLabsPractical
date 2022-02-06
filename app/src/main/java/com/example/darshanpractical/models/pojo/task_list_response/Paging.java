package com.example.darshanpractical.models.pojo.task_list_response;

import com.google.gson.annotations.SerializedName;

public class Paging{

	@SerializedName("results_per_page")
	private int resultsPerPage;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("current_page")
	private int currentPage;

	@SerializedName("total_results")
	private int totalResults;

	public void setResultsPerPage(int resultsPerPage){
		this.resultsPerPage = resultsPerPage;
	}

	public int getResultsPerPage(){
		return resultsPerPage;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}
}