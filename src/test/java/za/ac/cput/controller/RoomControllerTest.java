package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Room;
import za.ac.cput.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoomControllerTest {
    private static Room room = RoomFactory.buildRoom("Standard", true);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/room";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(room.getRoomNo(), savedRoom.getRoomNo());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + room.getRoomNo();
        System.out.println("URL:" + url);
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);
        assertEquals(room.getRoomNo(),response.getBody().getRoomNo());
        System.out.println(response.getBody());

    }

    @Test
    void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomType("Deluxe").build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Room> response = restTemplate.postForEntity(url, updated, Room.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + room.getRoomNo();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }
    @Test
    void e_getall() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Show all:" );
        System.out.println(response);
        System.out.println(response.getBody());
    }
}