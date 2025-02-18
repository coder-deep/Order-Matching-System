package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.Trade_log;

public interface Trade_logRepo extends JpaRepository<Trade_log, Integer>{
	@Query(nativeQuery=true,value="SELECT SUM(t.price*t.quantity) FROM buy_order b INNER JOIN trade_log t ON b.b_order_id= t.b_order_id WHERE b.buyer_id=?1")
	public double getBuyTotalByClient(@Param("buyer_id") String id);
	@Query(nativeQuery=true,value="SELECT SUM(t.price*t.quantity) FROM sell_order s INNER JOIN trade_log t ON s.s_order_id= t.s_order_id WHERE s.seller_id=?1")
	public double getSellTotalByClient(@Param("seller_id") String id);
}
