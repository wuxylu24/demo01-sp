package com.shp.demo.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShpDemoEurekaApplicationTests {

    @Value("${local.server.port}")
    private int port;

    private final HttpClient client = HttpClient.newHttpClient();

    @Test
    void eurekaRequiresBasicAuth() throws Exception {
        assertEquals(401, get(null).statusCode());

        String token = Base64.getEncoder().encodeToString("shp:shp123".getBytes(StandardCharsets.UTF_8));
        assertEquals(200, get("Basic " + token).statusCode());
    }

    private HttpResponse<String> get(String authorization) throws Exception {
        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create("http://localhost:" + port + "/eureka/apps"));
        if (authorization != null) {
            builder.header("Authorization", authorization);
        }
        return client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
    }

}
