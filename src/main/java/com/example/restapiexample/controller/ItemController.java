package com.example.restapiexample.controller;


import com.example.restapiexample.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping("/")
    public ResponseEntity<Item> getItems() {
        log.info("{}: GET ITEMS", this.getClass().getSimpleName());
        return ResponseEntity.ok().body(Item.builder()
                .id(UUID.randomUUID().toString())
                .name("item_name")
                .build());
    }
}
