package com.ysl.rabbitmq.dto;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class SaleAdvertisementDto implements Serializable {
    @NotBlank
    private String userName;
    @NotBlank
    @Email
    private String userMail;
    @NotBlank
    private String photo;
    @NotBlank
    private String title;
    @NotBlank
    private String detailMessage;




}
