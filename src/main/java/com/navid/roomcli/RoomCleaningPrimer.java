package com.navid.roomcli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RoomCleaningPrimer implements CommandLineRunner {

    private RestTemplate restTemplate;

    public RoomCleaningPrimer() {
        super();
        // must be injected in real world
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        // this must be injected via a property in real world
        String url = "http://localhost:8001/api/rooms";
        Room[] roomArray = this.restTemplate.getForObject(url, Room[].class);
        List<Room> rooms = Arrays.asList(roomArray);
        rooms.forEach(System.out::println);
    }
}
