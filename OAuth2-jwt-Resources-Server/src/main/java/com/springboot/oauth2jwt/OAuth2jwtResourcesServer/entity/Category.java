package com.springboot.oauth2jwt.OAuth2jwtResourcesServer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "category",
        catalog = "db_oauth2_resources")
public class Category implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idcategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "disabled")
    private boolean disabled;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> productList= new ArrayList<>();
}
