package com.ysl.rabbitmq.controller;

import com.ysl.rabbitmq.dto.SaleAdvertisementDto;
import com.ysl.rabbitmq.model.SaleAdvertisement;
import com.ysl.rabbitmq.service.SaleAdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleAdvertisementController {

    private final SaleAdvertisementService saleAdvertisementService;

    public SaleAdvertisementController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;
    }

    @PostMapping("/sale-advertisement")
    public String createSaleAdvertisement(@RequestBody SaleAdvertisementDto saleAdvertisementDto){
        saleAdvertisementService.createSaleAdvertisement(saleAdvertisementDto);
        return "İşleminiz başarıyla alınmıştır!";
    }

    @GetMapping("/sale-advertisement")
    public List<SaleAdvertisement> getAllSaleAdvertisements(){
        return saleAdvertisementService.getAllSaleAdvertisements();
    }
}
