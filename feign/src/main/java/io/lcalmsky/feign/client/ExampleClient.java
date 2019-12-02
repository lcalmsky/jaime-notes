package io.lcalmsky.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "example", url = "${external-api.http-bin}")
public interface ExampleClient {
    @GetMapping("/status/{status}")
    void status(@PathVariable("status") int status);
}
