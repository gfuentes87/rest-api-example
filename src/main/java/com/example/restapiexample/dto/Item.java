package com.example.restapiexample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class Item {
    
    private String id;
    
    private String name;
}
