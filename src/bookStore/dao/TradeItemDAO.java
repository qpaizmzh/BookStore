package bookStore.dao;


import bookStore.domain.TradeItem;

import java.util.Collection;
import java.util.Set;

public interface TradeItemDAO {


	public abstract void batchSave(Collection<TradeItem> items);


	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}

