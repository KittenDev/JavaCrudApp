package com.xpresso.cafe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("product")
public class Product {
    @Id
    private String id;
    @Field("name")
    @Indexed(unique = true)
    private String productName;
    @Field("price")
    private double productPrice;
    @Field("amount")
    private int productAmount;
}
