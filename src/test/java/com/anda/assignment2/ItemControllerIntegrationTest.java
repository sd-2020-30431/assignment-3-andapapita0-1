package com.anda.assignment2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.anda.assignment2.bean.Item;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void getFood(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/groceries",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testCreateItem() throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Item item = new Item("pizza", 2, 980, sdformat.parse("2020-03-30"),
                sdformat.parse("2020-04-03"));
        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl() + "/groceries",
                item, Item.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateItem() throws ParseException {
        int id = 1;
        Item item = restTemplate.getForObject(getRootUrl() + "/groceries/" + id, Item.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        item.setConsumptionDate(sdf.parse("2020-05-25"));
        restTemplate.put(getRootUrl() + "/groceries/" + id, item);
        Item updatedItem = restTemplate.getForObject(getRootUrl() + "/groceries/" + id, Item.class);
        assertNotNull(updatedItem);
    }

    @Test
    public void testDeleteItem() {
        int id = 2;
        Item item = restTemplate.getForObject(getRootUrl() + "/groceries/" + id, Item.class);
        assertNotNull(item);
        restTemplate.delete(getRootUrl() + "/groceries/" + id);
        try {
            item = restTemplate.getForObject(getRootUrl() + "/groceries/" + id, Item.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
