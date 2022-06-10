package com.ysl.rabbitmq.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sale_advertisement")
public class SaleAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleId;
    @Column(name = "title")
    private String title;
    @Column(name = "photo")
    private String photo;
    @Column(name = "detail_message")
    private String detailMessage;
    private String priceGraphPath; //check


}
