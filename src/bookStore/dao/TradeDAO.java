package bookStore.dao;


import bookStore.domain.Trade;

import java.util.Set;

public interface TradeDAO {


	public abstract void insert(Trade trade);


	public abstract Set<Trade> getTradesWithUserId(Integer userId);

}