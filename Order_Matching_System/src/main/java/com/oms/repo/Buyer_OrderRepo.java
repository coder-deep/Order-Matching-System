package com.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.beans.Buy_Order;

public interface Buyer_OrderRepo extends JpaRepository<Buy_Order, Integer>{

}
