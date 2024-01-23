package org.dummy.async.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public CompletableFuture hello() {
        log.info("CompletableFuture init");
        return asyncService.run();
    }

}
