package com.orders.management.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.management.entity.ShippingsEntity;

public interface ShippingsRepo extends JpaRepository<ShippingsEntity,Integer>{

}
