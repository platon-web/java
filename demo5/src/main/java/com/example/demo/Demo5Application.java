package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo5Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo5Application.class, args);
    }

}
net.bytebuddy:byte-buddy:jar:1.14.12 failed to transfer from https://repo.maven.apache.org/maven2 during a previous attempt.
// This failure was cached in the local repository and resolution is not reattempted until the update interval of central
// has elapsed or updates are forced. Original error: Could not transfer artifact net.bytebuddy:byte-buddy:jar:1.14.12
// from/to central (https://repo.maven.apache.org/maven2): Connection reset