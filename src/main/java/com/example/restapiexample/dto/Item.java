package com.example.restapiexample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {
    
    private String id;
    
    private String name;
}
