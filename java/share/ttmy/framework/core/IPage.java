package ttmy.framework.core;

import java.util.List;

public interface IPage<T> {
	long getTotalSize();

	int getPageSize();

	long getTotalPage();

	long getCurrentPage();

	boolean isFirstPage();

	boolean isLastPage();

	long getPageBegin();

	long getPageEnd();

	List<T> getData();
}