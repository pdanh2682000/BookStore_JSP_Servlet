package com.danhuy.paging;

public class Pagination {
	
	private Integer page, maxItemPerPage,  totalPage;

	public int countPage(int items) {
		if(items / maxItemPerPage == 0) return 1;
		if(items % maxItemPerPage != 0) return (items / maxItemPerPage) + 1;
		return items / maxItemPerPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxItemPerPage() {
		return maxItemPerPage;
	}

	public void setMaxItemPerPage(Integer maxItemPerPage) {
		this.maxItemPerPage = maxItemPerPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
		
}
