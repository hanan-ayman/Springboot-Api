package com.flairsteck.workshop;


import com.flairsteck.workshop.exception.DBDownException;
import com.flairsteck.workshop.repository.CountryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author hanan.ayman
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    CountryDao countryDao;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    @Test
    public void context(){
        
    }
    @Test
    public void testGetUserById() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/BHR",
                HttpMethod.GET, new HttpEntity<String>(null, new HttpHeaders()), String.class);
        junit.framework.Assert.assertEquals(response.getBody().toString(), HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDBConnection() throws DBDownException {
        try {
            countryDao.getAllCountryInfoByCode("BHR");
        } catch (Exception ex) {
            throw new DBDownException(ex.toString());
        }
    }
}
