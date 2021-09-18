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
public interface Seller_OrderRepo extends JpaRepository<Sell_Order, Integer>{

	@Query(nativeQuery=true,value="select * from buy_order b where b.instrument_id = ?1 and b.price=?2 and status=\"ACTIVE\" order by timestamp asc")
	public List<Buy_Order> getQuantitiesMatchingOnSeller(@Param("instrument_id") String id,@Param("price") double price);
	
	@Modifying(clearAutomatically=true)
	@Query(nativeQuery=true,value="update sell_order set quantity=?2 where s_order_id=?1")
	public void updateQuantitySeller(@Param("s_order_id") int id, @Param("quantity")int quantity);
	
	@Modifying(clearAutomatically=true)
	@Query(nativeQuery=true,value="update sell_order set quantity=0,status=\"INACTIVE\" where s_order_id=?1")
	public void updateStatusSeller(@Param("s_order_id") int id);
}
