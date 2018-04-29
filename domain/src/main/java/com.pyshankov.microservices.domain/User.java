package com.pyshankov.microservices.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -134343434L;

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private BigDecimal amount;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
