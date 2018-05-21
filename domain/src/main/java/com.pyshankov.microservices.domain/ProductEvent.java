package com.pyshankov.microservices.domain;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDateTime;

@Table("ProductEvent")
public class ProductEvent extends Event {

    private static final long serialVersionUID = -4223434L;

    @PrimaryKey
    private String productId;
    private ProductEventType productEventType;
    private LocalDateTime timestamp;
    private String userId;

    public ProductEvent() {
    }

    public ProductEvent(String productId, String userId, ProductEventType productEventType) {
        this.productId = productId;
        this.productEventType = productEventType;
        this.userId = userId;
        timestamp = LocalDateTime.now();
    }

    public String getProductId() {
        return productId;
    }

    public ProductEventType getProductEventType() {
        return productEventType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }
}
