package com.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.beans.Custodian;

public interface CustodianRepo extends JpaRepository<Custodian, String> {

}
