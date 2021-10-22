package com.jpgarcia.arquitectura.springmongodb.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.jpgarcia.arquitectura.springmongodb.entity.Bike;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @InjectMocks
    private Bike bikeService = new Bike();


    @LocalServerPort
    private int port;
    
    @Test
    public void testSaludoPorDefecto() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/hola",
                String.class)).contains("Hola Mundo!");
    }
    
    
    @Test
    public void testFindBike() throws Exception {
    	
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/findBike/1",
                String.class)).contains("Ruta");
        
        
    }
    
    @Test
    public void testDeleteBike() throws Exception {
    	
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/deleteBike/1",
                String.class)).contains("Deleted Bike Successfully");
        
        
    }
    
    @Test
    public void testaddBike() throws Exception {
    	
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/addBike",
                String.class)).contains("Bike added successfully");
        
        
    }
    
    
   


}