package com.accenture.wchallenge.infrastructure.service;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.infrastructure.adapter.client.JSONPlaceholder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WChallengeServiceTest {

    @Mock
    private JSONPlaceholder jsonPlaceholder;

    @InjectMocks
    private WChallengeService service;

    @Test
    void getAlbums() {
        when(jsonPlaceholder.getAlbums()).thenReturn(buildAlbumList());

        List<Album> albums = service.getAlbums();

        verify(jsonPlaceholder).getAlbums();

        assertThat(albums).isNotNull().isEqualTo(buildAlbumList());
    }

    @Test
    void getPhotos() {
        when(jsonPlaceholder.getPhotos()).thenReturn(buildPhotoList());

        List<Photo> photos = service.getPhotos();

        verify(jsonPlaceholder).getPhotos();

        assertThat(photos).isNotNull().isEqualTo(buildPhotoList());
    }

    @Test
    void getUsers() {
        when(jsonPlaceholder.getUsers()).thenReturn(buildUserList());

        List<User> users = service.getUsers();

        verify(jsonPlaceholder).getUsers();

        assertThat(users).isNotNull().isEqualTo(buildUserList());
    }

    @Test
    void getComments() {
        when(jsonPlaceholder.getComments()).thenReturn(buildCommentList());

        List<Comment> comments = service.getComments();

        verify(jsonPlaceholder).getComments();

        assertThat(comments).isNotNull().isEqualTo(buildCommentList());
    }

    @Test
    void getAlbumsByUserId() {
        when(jsonPlaceholder.getAlbumsByUserId(anyString())).thenReturn(buildAlbumList());

        List<Album> albums = service.getAlbumsByUserId("some-user-id");

        verify(jsonPlaceholder).getAlbumsByUserId("some-user-id");

        assertThat(albums).isNotNull().isEqualTo(buildAlbumList());
    }

    @Test
    void getCommentsByName() {
        when(jsonPlaceholder.getCommentsByName(anyString())).thenReturn(buildCommentList());

        List<Comment> comments = service.getCommentsByName("some-name");

        verify(jsonPlaceholder).getCommentsByName("some-name");

        assertThat(comments).isNotNull().isEqualTo(buildCommentList());
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