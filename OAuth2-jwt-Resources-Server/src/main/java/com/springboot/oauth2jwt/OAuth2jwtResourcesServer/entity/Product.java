package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "product",
        catalog = "db_oauth2_resources")
public class Product implements Serializable{

    @Id
    @Column(name = "idproduct", unique = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idproduct;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitprice", nullable = false)
    private BigDecimal unitprice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "disabled")
    private boolean disabled;

    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;
}
