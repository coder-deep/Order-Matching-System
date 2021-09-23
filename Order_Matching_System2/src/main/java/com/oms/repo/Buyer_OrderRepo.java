package com.oms.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.Buy_Order;
import com.oms.beans.Sell_Order;

@Transactional
public interface Buyer_OrderRepo extends JpaRepository<Buy_Order, Integer>{

	@Query(nativeQuery=true,value="select * from sell_order s where s.instrument_id = ?1 and s.price=?2 and status=\"ACTIVE\" order by timestamp asc")
	public List<Sell_Order> getQuantitiesMatchingOnBuyer(@Param("instrument_id") String id,@Param("price") double price);

	@Modifying(clearAutomatically=true)
	@Query(nativeQuery=true,value="update buy_order set quantity=?2 where b_order_id=?1")
	public void updateQuantityBuyer(@Param("b_order_id") int id, @Param("quantity") int quantity);
	
	@Modifying(clearAutomatically=true)
	@Query(nativeQuery=true,value="update buy_order set quantity=0,status=\"INACTIVE\" where b_order_id=?1")
	public void updateStatusBuyer(@Param("b_order_id") int id);

}
