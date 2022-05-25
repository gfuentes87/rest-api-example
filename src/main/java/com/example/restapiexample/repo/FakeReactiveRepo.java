package com.example.restapiexample.repo;

import com.example.restapiexample.dto.Item;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class FakeReactiveRepo {


    public Observable<Item> get() {
        log.info("{}: Getting item from fake repo", this.getClass().getSimpleName());
        return Observable.just(Item.builder()
                .id(UUID.randomUUID().toString())
                .name("item_name")
                .build());
    }
}
