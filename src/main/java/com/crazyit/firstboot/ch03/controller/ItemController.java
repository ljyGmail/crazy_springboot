package com.crazyit.firstboot.ch03.controller;

import com.crazyit.firstboot.ch03.domain.Item;
import com.crazyit.firstboot.ch03.exception.ItemNotFoundException;
import com.crazyit.firstboot.ch03.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Objects;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello WebFlux");
    }

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public Mono<Item> getByItemId(@PathVariable("id") Integer id) {
        return Mono.justOrEmpty(this.itemService.getItemById(id))
                .switchIfEmpty(Mono.error(new ItemNotFoundException("商品找不到")));
    }

    @PostMapping("")
    public Mono<Item> create(@RequestBody Item item) {
        return Mono.just(this.itemService.createOrUpdate(item));
    }

    @PutMapping("")
    public Mono<Item> update(@RequestBody Item item) {
        Objects.requireNonNull(item);
        return Mono.just(this.itemService.createOrUpdate(item));
    }

    @DeleteMapping("/{id}")
    public Mono<Item> delete(@PathVariable("id") Integer id) {
        return Mono.justOrEmpty(this.itemService.delete(id));
    }

    @GetMapping("")
    public Flux<Item> list(Integer size) {
        if (size == null || size == 0) {
            size = 5;
        }
        return Flux.fromIterable(this.itemService.list()).take(size);
    }

    @GetMapping(value = "", produces = "application/stream+json")
    public Flux<Item> list() {
        // 需要周期性地生成数据，使用Flux.interval
        return Flux.interval(Duration.ofMillis(2000))
                .onBackpressureDrop()
                // 每隔interval执行一次itemService.list()方法
                .map((interval) -> itemService.list())
                // 将List<Item>转换成Flux<Item>
                .flatMapIterable(item -> item)
                .log("生成信息");
    }
}
