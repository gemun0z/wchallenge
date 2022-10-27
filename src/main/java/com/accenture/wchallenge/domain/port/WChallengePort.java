package com.accenture.wchallenge.domain.port;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.domain.users.User;

import java.util.List;

public interface WChallengePort {

    List<Album> getAlbums();

    List<Photo> getPhotos();

    List<User> getUsers();

    List<Comment> getComments();

    List<Album> getAlbumsByUserId(String userId);

    List<Comment> getCommentsByName(String name);

    void saveAlbumAndUserByAlbumId(String id, boolean read, boolean write);

    void updateAccessByAlbumId(String id, boolean read, boolean write);

    List<User> getUserByAccessAndAlbumId(String access, String albumId);

}
