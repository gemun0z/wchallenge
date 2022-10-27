package com.accenture.wchallenge.infrastructure.adapter.client;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.domain.users.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JSONPlaceholderTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private JSONPlaceholder jsonPlaceholder;

    @Test
    void getAlbums() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Album>>() {}))
                .thenReturn(new ResponseEntity<>(buildAlbumList(), HttpStatus.OK));

        List<Album> albums = jsonPlaceholder.getAlbums();

        assertThat(albums).isNotNull().isEqualTo(buildAlbumList());
    }

    @Test
    void getPhotos() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/photos", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Photo>>() {}))
                .thenReturn(new ResponseEntity<>(buildPhotoList(), HttpStatus.OK));

        List<Photo> photos = jsonPlaceholder.getPhotos();

        assertThat(photos).isNotNull().isEqualTo(buildPhotoList());
    }

    @Test
    void getUsers() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<User>>() {}))
                .thenReturn(new ResponseEntity<>(buildUserList(), HttpStatus.OK));

        List<User> users = jsonPlaceholder.getUsers();

        assertThat(users).isNotNull().isEqualTo(buildUserList());
    }

    @Test
    void getComments() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/comments", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Comment>>() {}))
                .thenReturn(new ResponseEntity<>(buildCommentList(), HttpStatus.OK));

        List<Comment> comments = jsonPlaceholder.getComments();

        assertThat(comments).isNotNull().isEqualTo(buildCommentList());
    }

    @Test
    void getAlbumsByUserId() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/albums?userId=1", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Album>>() {}))
                .thenReturn(new ResponseEntity<>(buildAlbumList(), HttpStatus.OK));

        List<Album> albums = jsonPlaceholder.getAlbumsByUserId("1");

        assertThat(albums).isNotNull().isEqualTo(buildAlbumList());
    }

    @Test
    void getCommentsByName() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/comments?name=some-name", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Comment>>() {}))
                .thenReturn(new ResponseEntity<>(buildCommentList(), HttpStatus.OK));

        List<Comment> comments = jsonPlaceholder.getCommentsByName("some-name");

        assertThat(comments).isNotNull().isEqualTo(buildCommentList());
    }

    @Test
    void getAlbumById() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/albums?id=1", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Album>>() {}))
                .thenReturn(new ResponseEntity<>(buildAlbumList(), HttpStatus.OK));

        List<Album> albums = jsonPlaceholder.getAlbumById("1");

        assertThat(albums).isNotNull().isEqualTo(buildAlbumList());
    }

    @Test
    void getUsersById() {
        HttpEntity<?> requestEntity = new HttpEntity<>(getHttpHeaders());

        when(restTemplate.exchange("https://jsonplaceholder.typicode.com/users?id=1", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<User>>() {}))
                .thenReturn(new ResponseEntity<>(buildUserList(), HttpStatus.OK));

        List<User> users = jsonPlaceholder.getUsersById("1");

        assertThat(users).isNotNull().isEqualTo(buildUserList());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return requestHeaders;
    }

    private List<Album> buildAlbumList() {
        return List.of(Album.builder().build());
    }

    private List<Photo> buildPhotoList() {
        return List.of(Photo.builder().build());
    }

    private List<User> buildUserList() {
        return List.of(User.builder().build());
    }

    private List<Comment> buildCommentList() {
        return List.of(Comment.builder().build());
    }
}