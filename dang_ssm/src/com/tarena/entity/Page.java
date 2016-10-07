package com.tarena.entity;

public class Page {
    private int currentPage=1;
    private int pageSize=4;
    private int begin;
    private int end;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBegin() {
		begin=(currentPage-1)*pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		end=currentPage*pageSize+1;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
