package com.PharmacyManagementSystem.UserMicroService.controller;



import com.PharmacyManagementSystem.UserMicroService.entity.User;
import com.PharmacyManagementSystem.UserMicroService.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() {
        User user = new User(); // Create a sample user
        when(userService.addUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.add(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testUpdateUser() {
        User user = new User(); // Create a sample user
        when(userService.updateUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.update(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testDeleteUser() {
        String email = "test@example.com";
        doNothing().when(userService).deletUser(email);

        ResponseEntity<String> response = userController.delet(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
    }

    @Test
    public void testGetUser() {
        User user = new User(); // Create a sample user
        String email = "test@example.com";
        when(userService.getUser(email)).thenReturn(user);

        ResponseEntity<User> response = userController.get(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User(); // Create sample users
        User user2 = new User();
        List<User> userList = Arrays.asList(user1, user2);

        when(userService.getAll()).thenReturn(userList);

        ResponseEntity<List<User>> response = userController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());
    }
}
