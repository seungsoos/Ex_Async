package org.dummy.async.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run() {
        return new AsyncResult<>(hello()).completable();
    }


    public String hello() {

        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(2000);
                log.info("Thread sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "async hello";
    }
}
