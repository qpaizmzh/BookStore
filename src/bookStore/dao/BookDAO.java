package bookStore.dao;


import bookStore.domain.Book;
import bookStore.domain.ShoppingCartItem;
import bookStore.web.CriteriaBook;
import bookStore.web.Page;

import java.util.Collection;
import java.util.List;

public interface BookDAO {


	public abstract Book getBook(int id);


	public abstract Page<Book> getPage(CriteriaBook cb);


	public abstract long getTotalBookNumber(CriteriaBook cb);


	public abstract List<Book> getPageList(CriteriaBook cb, int pageSize);


	public abstract int getStoreNumber(Integer id);


	public abstract void batchUpdateStoreNumberAndSalesAmount(
            Collection<ShoppingCartItem> items);

}