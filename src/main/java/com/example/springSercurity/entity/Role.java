package com.example.springSercurity.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
@Data
public class Role {
    private String role;
}
