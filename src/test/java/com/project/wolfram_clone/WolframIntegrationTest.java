package com.project.wolfram_clone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WolframIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSolveEndpoint() {
        String equation = "2^2";
        String url = "http://localhost:" + port + "/solve?equation=" + equation;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("4.0", response.getBody());
    }

    @Test
    void testSolveEndpoint2() {
        String equation = "2-3";
        String url = "http://localhost:" + port + "/solve?equation=" + equation;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("-1.0", response.getBody());
    }

    @Test
    void testSolveEndpoint3() {
        String equation = "xxxxxx";
        String url = "http://localhost:" + port + "/solve?equation=" + equation;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testSolveEndpoint4() {
        String equation = "2/2";
        String url = "http://localhost:" + port + "/solve?equation=" + equation;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1.0", response.getBody());
    }

    @Test
    void testSolveEndpoint5() {
        String equation = "ceva";
        String url = "http://localhost:" + port + "/solve?equation=" + equation;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
