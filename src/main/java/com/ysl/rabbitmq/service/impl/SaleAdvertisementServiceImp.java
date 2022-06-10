package com.ysl.rabbitmq.service.impl;

import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.repository.SaleAdvertisementRepo;
import com.ysl.rabbitmq.repository.UserRepo;
import com.ysl.rabbitmq.service.SaleAdvertisementService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleAdvertisementServiceImp implements SaleAdvertisementService {

    private final SaleAdvertisementRepo saleAdvertisementRepo;
    private final UserRepo userRepo;
    private final DirectExchange exchange;
    private final RabbitTemplate rabbitTemplate;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    public SaleAdvertisementServiceImp(SaleAdvertisementRepo saleAdvertisementRepo, UserRepo userRepo, DirectExchange exchange, RabbitTemplate rabbitTemplate) {
        this.saleAdvertisementRepo = saleAdvertisementRepo;
        this.userRepo = userRepo;
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public SaleAdvertisementDto createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto) {

        SaleAdvertisement saleAdvertisement = SaleAdvertisement.builder()
                .title(saleAdvertisementDto.getTitle())
                .photo(saleAdvertisementDto.getPhoto())
                .detailMessage(saleAdvertisementDto.getDetailMessage())
                .build();
        SaleAdvertisement saleAdvertisement1 = saleAdvertisementRepo.save(saleAdvertisement);

        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, saleAdvertisement1);
        return saleAdvertisementDto;
    }

    @Override
    public List<SaleAdvertisement> getAllSaleAdvertisements() {
        return saleAdvertisementRepo.findAll();
    }
}
