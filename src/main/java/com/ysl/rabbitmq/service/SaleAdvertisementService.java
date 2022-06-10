package com.ysl.rabbitmq.service;

import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;

import java.util.List;

public interface SaleAdvertisementService {

    SaleAdvertisementDto createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto);

    List<SaleAdvertisement> getAllSaleAdvertisements();

}
