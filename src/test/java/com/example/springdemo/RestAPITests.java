package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestAPITests {
    @Test
	void getListByEmployeeIdFilter() throws Exception {
		long employeeId = 5;
		HttpUriRequest request = new HttpGet( "http://localhost:8081/api/employees-filter-id?id=" + employeeId );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
	}
}
