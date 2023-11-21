package com.orders.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.management.entity.PaymentsEntity;

public interface PaymentsRepo extends JpaRepository <PaymentsEntity, Integer>{

}
