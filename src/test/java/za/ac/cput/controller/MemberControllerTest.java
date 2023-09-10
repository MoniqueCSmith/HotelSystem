/**
 * MemberControllerTest.java
 * Controller Test class for the Member
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
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
import za.ac.cput.domain.Member;
import za.ac.cput.factory.MemberFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {

    private static Member member = MemberFactory.buildMember("ffloppy@gmail.com", "carrot");
    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/member";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Member> postResponse = restTemplate.postForEntity(url, member, Member.class);
        //assertNotNull(postResponse);
        //assertNotNull(postResponse.getBody());
        Member savedMember = postResponse.getBody();
        System.out.println("Saved data:" + savedMember);
        //assertEquals(member.getMemberID(), savedMember.getMemberID());

    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + member.getMemberID();
        System.out.println("URL:" + url);
        ResponseEntity<Member> response = restTemplate.getForEntity(url, Member.class);
        assertEquals(member.getMemberID(),response.getBody().getMemberID());
        System.out.println(response.getBody());

    }

    @Test
    void c_update() {
        //Member updated = new Member.Builder().copy(member).setPassword("Jordan012T").build();
        //String url = baseURL + "/update";
        //System.out.println("URL:" + url);
        //System.out.println("Post data:" + updated);
        //ResponseEntity<Member> response = restTemplate.postForEntity(url, updated, Member.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/" + member.getMemberID();
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
