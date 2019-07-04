package com.example.springSercurity.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
@Data
@NoArgsConstructor
@RequiredArgsConstructor()
public class Student {

    @Id
    @NonNull
    private int id;

    @NonNull @UniqueElements private String name;
}
