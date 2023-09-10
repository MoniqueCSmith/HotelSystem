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
import static za.ac.cput.domain.RoomType.*;
import static za.ac.cput.domain.RoomType.TWIN;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static Room suiteRoom = RoomFactory.buildRoom(SUITE, 600.00);
    private static Room singleRoom = RoomFactory.buildRoom(SINGLE, 1500.00);
    private static Room doubleRoom = RoomFactory.buildRoom(DOUBLE, 2400);
    private static Room queenRoom = RoomFactory.buildRoom(QUEEN, 3000.00);
    private static Room kingRoom = RoomFactory.buildRoom(KING, 4500.00);
    private static Room twinRoom = RoomFactory.buildRoom(TWIN, 1800.00);

    private final String baseURL = "http://localhost:8080/room";

    @Test
    void a_create1() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, suiteRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(suiteRoom.getRoomNo(), savedRoom.getRoomNo());
    }
    @Test
    void a_create2() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, singleRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(singleRoom.getRoomNo(), savedRoom.getRoomNo());
    }
    @Test
    void a_create3() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, doubleRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(doubleRoom.getRoomNo(), savedRoom.getRoomNo());
    }
    @Test
    void a_create4() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, queenRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(queenRoom.getRoomNo(), savedRoom.getRoomNo());
    }
    @Test
    void a_create5() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, kingRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(kingRoom.getRoomNo(), savedRoom.getRoomNo());
    }
    @Test
    void a_create6() {
        String url = baseURL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, twinRoom, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Room savedRoom = postResponse.getBody();
        System.out.println("Saved data:" + savedRoom);
        assertEquals(twinRoom.getRoomNo(), savedRoom.getRoomNo());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + suiteRoom.getRoomNo();
        System.out.println("URL:" + url);
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);
        assertEquals(suiteRoom.getRoomNo(),response.getBody().getRoomNo());
        System.out.println(response.getBody());

    }

    @Test
    void c_update() {
        Room updated = new Room.Builder().copy(suiteRoom).setPrice(6000.00).build();
        String url = baseURL + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data:" + updated);
        ResponseEntity<Room> response = restTemplate.postForEntity(url, updated, Room.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + suiteRoom.getRoomNo();
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