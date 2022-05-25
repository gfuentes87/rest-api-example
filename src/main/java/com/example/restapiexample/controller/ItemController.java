package com.example.restapiexample.controller;


import com.example.restapiexample.dto.Item;
import com.example.restapiexample.repo.FakeReactiveRepo;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/items")
public class ItemController {

    private final FakeReactiveRepo fakeReactiveRepo;

    ItemController(final FakeReactiveRepo fakeReactiveRepo) {
        this.fakeReactiveRepo = fakeReactiveRepo;
    }

    @GetMapping("/")
    public ResponseEntity<Item> getItems() {
        log.info("{}: GET ITEMS", this.getClass().getSimpleName());
        return ResponseEntity.ok().body(Item.builder()
                .id(UUID.randomUUID().toString())
                .name("item_name")
                .build());
    }

    @PostMapping("/")
    public Single<Item> processSomething() {
        log.info("{}: processSomething started", this.getClass().getSimpleName());
        var processedItem = this.fakeReactiveRepo.get()
                .flatMap(item -> {
                    log.info("Processing Item Async");
                    return Observable.just(item);
                }).onErrorResumeNext(x -> Observable.error(new Exception()));
        log.info("{}: Probably the item didn't be processed yet", this.getClass().getSimpleName());
        return Single.fromObservable(processedItem);
    }
}
