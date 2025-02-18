package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.ClientTotalSell;

public interface ClientTotalSellRepo extends JpaRepository<ClientTotalSell, String> {
	@Query(nativeQuery=true,value=" SELECT client_id, coalesce(SUM(c.tot_sell),0) AS tot_sell FROM ( SELECT s.seller_id AS seller, SUM(t.quantity)*t.price AS tot_sell FROM trade_log t JOIN sell_order s WHERE s.s_order_id=t.s_order_id and s.s_custodian_id=?1 Group BY t.s_order_id)AS c RIGHT JOIN client ON client_id=c.seller WHERE custodian_id=?1 GROUP BY client_id;")
	public List<ClientTotalSell> getclientsell(@Param("custodian_id") String custodian_id);
}
