package edu.fra.uas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.model.User;
import edu.fra.uas.service.ChatService;
import edu.fra.uas.service.UserService;

@RequestMapping("/api") 
@RestController
public class UserController {
    
    private final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @GetMapping(value = "/users", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> list() {
        log.debug("list() is called");
        Iterable<User> userIter = userService.getAllUsers();
        List<User> users = new ArrayList<>();
        for (User user : userIter) {
            users.add(user);
        }
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> find(@PathVariable("id") Long userId) {
        log.debug("find() is called");
        User user = userService.getUserById(userId);
        if (user == null) {            
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/users", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody User user) {
        log.debug("add() is called");
        String detail = null;
        if (user == null) {
            detail = "User must not be null";            
        } else if (user.getRole() == null) {
            detail = "Role must not be null";
        } else if (user.getRole().isEmpty()) {
            detail = "Role must not be empty";
        } else if (user.getFirstName() == null) {
            detail = "FirstName must not be null";
        } else if (user.getFirstName().isEmpty()) {
            detail = "FirstName must not be empty";
        } else if (user.getLastName() == null) {
            detail = "LastName must not be null";
        } else if (user.getLastName().isEmpty()) {
            detail = "LastName must not be empty";
        } else if (user.getEmail() == null) {
            detail = "Email must not be null";
        } else if (user.getEmail().isEmpty()) {
            detail = "Email must not be empty";
        } else if (user.getPassword() == null) {
            detail = "Password must not be null";
        } else if (user.getPassword().isEmpty()) {
            detail = "Password must not be empty";
        }
        if (detail != null) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail); 
            pd.setInstance(URI.create("/users"));
            pd.setTitle("JSON Object Error");
            return ResponseEntity.unprocessableEntity().body(pd);
        }
        user = userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users/" + user.getId()));
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{id}"
                , consumes = MediaType.APPLICATION_JSON_VALUE
                , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody User newUser, @PathVariable("id") Long userId) {
        log.debug("update() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        String detail = null;
        if (newUser == null) {
            detail = "User must not be null";            
        } else if (newUser.getRole() == null) {
            detail = "Role must not be null";
        } else if (newUser.getRole().isEmpty()) {
            detail = "Role must not be empty";
        } else if (newUser.getFirstName() == null) {
            detail = "FirstName must not be null";
        } else if (newUser.getFirstName().isEmpty()) {
            detail = "FirstName must not be empty";
        } else if (newUser.getLastName() == null) {
            detail = "LastName must not be null";
        } else if (newUser.getLastName().isEmpty()) {
            detail = "LastName must not be empty";
        } else if (newUser.getEmail() == null) {
            detail = "Email must not be null";
        } else if (newUser.getEmail().isEmpty()) {
            detail = "Email must not be empty";
        } else if (newUser.getPassword() == null) {
            detail = "Password must not be null";
        } else if (newUser.getPassword().isEmpty()) {
            detail = "Password must not be empty";
        }
        if (detail != null) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail); 
            pd.setInstance(URI.create("/users/" + userId));
            pd.setTitle("JSON Object Error");
            return ResponseEntity.unprocessableEntity().body(pd);
        }
        user.setRole(newUser.getRole());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user = userService.updateUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users/" + user.getId()));
        return new ResponseEntity<User>(user, headers,  HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}",
                   produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") Long userId) {
        log.debug("delete() is called");
        User user = userService.deleteUser(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // ##############################################################################################################
    // ChatService integration
    // ##############################################################################################################

    @GetMapping(value = "/users/{id}/chatrooms", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getRooms(@PathVariable("id") Long userId) {
        log.debug("getRooms() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.getAllRooms();
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
            return new ResponseEntity<>("No rooms found", HttpStatus.NO_CONTENT);
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/chatrooms/{roomId}", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> findRoom(@PathVariable("id") Long userId, @PathVariable("roomId") Long roomId) {
        log.debug("findRoom() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.getRoomById(roomId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/users/{id}/chatrooms", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createRoom(@PathVariable("id") Long userId, @RequestBody String name) {
        log.debug("createRoom() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.createRoom(name);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.CREATED)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/users/" + userId + "/chatrooms/"));
            return new ResponseEntity<>(response.getBody(), headers, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping(value = "/users/{id}/chatrooms/{roomId}", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long userId, @PathVariable("roomId") Long roomId) {
        log.debug("deleteRoom() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.deleteRoom(roomId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}/chatrooms", 
                consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> joinRoom(@PathVariable("id") Long userId, @RequestBody Long roomId) {
        log.debug("joinRoom() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.joinRoom(roomId, user);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PatchMapping(value = "/users/{id}/chatrooms/{roomId}", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> leaveRoom(@PathVariable("id") Long userId, @PathVariable("roomId") Long roomId) {
        log.debug("leaveRoom() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.leaveRoom(roomId, userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/users/{id}/chatrooms/{roomId}/messages", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> sendMessage(@PathVariable("id") Long userId, @PathVariable("roomId") Long roomId, @RequestBody String text) {
        log.debug("sendMessage() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.sendMessage(roomId, userId, text);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/chatrooms/{roomId}/messages", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getMessages(@PathVariable("id") Long userId, @PathVariable("roomId") Long roomId) {
        log.debug("getMessages() is called");
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ResponseEntity<?> response = chatService.getAllMessages(roomId, userId);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
           return response;
        }        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}