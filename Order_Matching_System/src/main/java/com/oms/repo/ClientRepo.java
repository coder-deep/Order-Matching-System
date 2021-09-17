package com.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.beans.Client;

public interface ClientRepo extends JpaRepository<Client, String>{

}
