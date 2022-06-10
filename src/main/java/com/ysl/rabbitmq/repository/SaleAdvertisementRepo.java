package com.ysl.rabbitmq.repository;

import com.ysl.rabbitmq.model.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleAdvertisementRepo extends JpaRepository<SaleAdvertisement, Long> {

}
