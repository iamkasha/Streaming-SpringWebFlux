package org.kasha.springbootwebflux.streamingspringbootwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class StreamingWithSpringBootWebFluxApplication {

    @Autowired
    private StreamingService streamingService;
    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range){
        System.out.println("range in bytes() : " + range);
        return streamingService.getVideo(title);
    }
    public static void main(String[] args) {
        SpringApplication.run(StreamingWithSpringBootWebFluxApplication.class, args);
    }

}
