package com.accenture.wchallenge.infrastructure.adapter.client;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.domain.users.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class JSONPlaceholder {

    private final RestTemplate restTemplate;

    public JSONPlaceholder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Album> getAlbums() {

        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Album>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<Photo> getPhotos() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Photo>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/photos", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<User> getUsers() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<User>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<Comment> getComments() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Comment>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/comments", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<Album> getAlbumsByUserId(String userId) {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Album>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/albums?userId=" + userId, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<Comment> getCommentsByName(String name) {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Comment>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/comments?name=" + name, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<Album> getAlbumById(String id) {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<Album>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/albums?id=" + id, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    public List<User> getUsersById(String id) {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        ResponseEntity<List<User>> responseEntity = restTemplate
                .exchange("https://jsonplaceholder.typicode.com/users?id=" + id, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {});

        return responseEntity.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return requestHeaders;
    }
}
