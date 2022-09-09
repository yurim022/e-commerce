package com.example.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {

    private String orderId;

    private String productId;

    private Integer qty;

    private Integer unitPrice;

    private Integer totalPrice;

    private Date createdAt;

}
