package com.accenture.wchallenge.infrastructure.service;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.domain.port.WChallengePort;
import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.infrastructure.adapter.client.JSONPlaceholder;
import com.accenture.wchallenge.infrastructure.adapter.mapper.AlbumMapper;
import com.accenture.wchallenge.infrastructure.adapter.mapper.UserMapper;
import com.accenture.wchallenge.infrastructure.adapter.repository.AlbumRepository;
import com.accenture.wchallenge.infrastructure.adapter.repository.UserRepository;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.AlbumEntity;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WChallengeService implements WChallengePort {

    private final JSONPlaceholder client;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private AlbumMapper albumMapper = AlbumMapper.INSTANCE;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public List<Album> getAlbums() {
        return client.getAlbums();
    }

    @Override
    public List<Photo> getPhotos() {
        return client.getPhotos();
    }

    @Override
    public List<User> getUsers() {
        return client.getUsers();
    }

    @Override
    public List<Comment> getComments() {
        return client.getComments();
    }

    @Override
    public List<Album> getAlbumsByUserId(String userId) {
        return client.getAlbumsByUserId(userId);
    }

    @Override
    public List<Comment> getCommentsByName(String name) {
        return client.getCommentsByName(name);
    }

    @Override
    public void saveAlbumAndUserByAlbumId(String id, boolean read, boolean write) {
        List<Album> albums = client.getAlbumById(id);
        albumRepository.save(albumMapper.toEntity(albums.get(0)));
        List<User> users = client.getUsersById(albums.get(0).getUserId());
        UserEntity userEntity = userMapper.toEntity(users.get(0));
        userEntity.setRead(read);
        userEntity.setWrite(write);
        userRepository.save(userEntity);
    }

    @Override
    public void updateAccessByAlbumId(String id, boolean read, boolean write) {
        Optional<AlbumEntity> albumEntityOptional = albumRepository.findById(id);
        albumEntityOptional.ifPresentOrElse((albumEntity) -> {
            Optional<UserEntity> userEntityOptional = userRepository.findById(albumEntity.getUserId());
            userEntityOptional.ifPresentOrElse((userEntity) -> {
                userEntity.setRead(read);
                userEntity.setWrite(write);
                userRepository.save(userEntity);
            }, () -> {
                throw new NoSuchElementException(albumEntity.getUserId());
            });
        }, () -> {
            throw new NoSuchElementException(id);
        });
    }

    @Override
    public List<User> getUserByAccessAndAlbumId(String access, String albumId) {
        Optional<AlbumEntity> albumEntityOptional = albumRepository.findById(albumId);
        Optional<List<UserEntity>> userEntitiesOptional;
        List<User> users = new ArrayList<>();
        if ("READ".equals(access)) {
            userEntitiesOptional = userRepository.getUsersByAccessRead();
        } else {
            userEntitiesOptional = userRepository.getUsersByAccessWrite();
        }
        userEntitiesOptional.ifPresentOrElse((userEntities) -> {
            userEntities.forEach(userEntity -> {
                albumEntityOptional.ifPresentOrElse((albumEntity) -> {
                    if(albumEntity.getUserId().equals(userEntity.getId())) {
                        users.add(userMapper.toDomain(userEntity));
                    }
                }, () -> {
                    throw new NoSuchElementException(albumId);
                });
            });
        }, () -> {
            throw new NoSuchElementException();
        });
        return users;
    }

}
