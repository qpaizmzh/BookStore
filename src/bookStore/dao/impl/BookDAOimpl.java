package bookStore.dao.impl;

import bookStore.dao.BookDAO;
import bookStore.domain.Book;
import bookStore.domain.ShoppingCartItem;
import bookStore.web.CriteriaBook;
import bookStore.web.Page;

import java.util.Collection;
import java.util.List;

public class BookDAOimpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public Book getBook(int id) {
        return null;
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        return null;
    }

    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        return 0;
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
        return null;
    }

    @Override
    public int getStoreNumber(Integer id) {
        return 0;
    }

    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {

    }
}
