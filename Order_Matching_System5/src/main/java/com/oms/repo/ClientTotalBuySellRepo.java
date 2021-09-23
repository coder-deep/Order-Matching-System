package com.oms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oms.beans.ClientTotalBuy;
import com.oms.beans.Sell_Order;

public interface ClientTotalBuySellRepo extends JpaRepository<ClientTotalBuy, String> {
	@Query(nativeQuery=true,value=" SELECT client_id, client_name, coalesce(SUM(c.tot_buy),0) AS tot_buy FROM ( SELECT b.buyer_id AS buyer, SUM(t.quantity)*t.price AS tot_buy FROM trade_log t JOIN buy_order b WHERE b.b_order_id=t.b_order_id and b.b_custodian_id=?1 Group BY t.b_order_id)AS c RIGHT JOIN client ON client_id=c.buyer WHERE custodian_id=?1  GROUP BY client_id;")
	public List<ClientTotalBuy> getclientbuysellbycustodian(@Param("custodian_id") String custodian_id);

}
