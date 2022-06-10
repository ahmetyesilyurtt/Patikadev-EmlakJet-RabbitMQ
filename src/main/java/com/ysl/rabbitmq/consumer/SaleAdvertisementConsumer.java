package com.ysl.rabbitmq.consumer;

import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.repository.SaleAdvertisementRepo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SaleAdvertisementConsumer {
    private final SaleAdvertisementRepo saleAdvertisementRepo;

    public SaleAdvertisementConsumer(SaleAdvertisementRepo saleAdvertisementRepo) {
        this.saleAdvertisementRepo = saleAdvertisementRepo;
    }

    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void listener(SaleAdvertisement saleAdvertisement) {
        try {
            Thread.sleep(5*1000);
            saleAdvertisement.setPriceGraphPath("created by Worker");
            saleAdvertisementRepo.save(saleAdvertisement);

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }


    }

}
