package ttmy.framework.core;

import java.util.ArrayList;
import java.util.List;

public class Page<T> implements IPage<T> {
	private long totalSize;
	private int pageSize;
	private long totalPage;
	private long currentPage;
	private List<T> data;

	public Page(List<T> data, long totalSize, int pageSize, int currentPage) {
		this.data = (data == null ? new ArrayList<>(0) : data);
		this.totalSize = totalSize;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = calcTotalPage();
	}

	public long getTotalSize() {
		return this.totalSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	private long calcTotalPage() {
		long t = getTotalSize();
		long p = getPageSize();
		if ((t == 0L) || (p == 0L)) {
			return 0L;
		}
		long r = t % p;
		long pages = (t - r) / p;
		if (r > 0L) {
			pages += 1L;
		}
		return pages;
	}

	public long getTotalPage() {
		return this.totalPage;
	}

	public long getCurrentPage() {
		return this.currentPage;
	}

	public long getPageBegin() {
		return this.pageSize * this.currentPage;
	}

	public long getPageEnd() {
		return getPageBegin() + getData().size();
	}

	public List<T> getData() {
		return this.data;
	}

	public boolean isFirstPage() {
		return this.currentPage == 0L;
	}

	public boolean isLastPage() {
		return this.currentPage == this.totalPage;
	}
}
