package bookStore.web;

import java.util.List;

public class Page<T> {
    private int pageNo;
    private List<T> list;
    private int pageSize;
    private long totalItemNumber;

    public long getTotalPageNumber() {
        long PageNumber = totalItemNumber / pageSize;
        if (totalItemNumber / pageSize != 0) {
            return PageNumber + 1;
        }
        return PageNumber;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }


    public int getPageNo() {
        return pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public int getPageSize() {
        return pageSize;
    }


    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    public boolean isHasNext() {
        return getPageNo() < getTotalPageNumber() ? true : false;
    }

    public boolean isHasPrev() {
        return getPageNo() > 0 ? true : false;
    }

    public int getPrePage() {
        if (isHasPrev()) {
            return getPageNo() - 1;
        }
        return 1;
    }

    public int getNextPage() {
        if (isHasNext()) {
            return getPageNo() + 1;
        }
        return getPageSize();
    }
}
