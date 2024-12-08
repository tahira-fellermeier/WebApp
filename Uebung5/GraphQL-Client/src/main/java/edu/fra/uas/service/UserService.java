package edu.fra.uas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.ResponseError;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.FieldAccessException;
import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import edu.fra.uas.model.User;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private static final String baseURI = "http://localhost:8080/graphql";

    private RestClient restClient; // wird für HTTP-Anfragen verwendet
    private HttpSyncGraphQlClient graphQlClient;
    // synchroner GraphQL-Client, basiert auf RestClient, GraphQL-Anfragen senden
    // und Antworten empfangen.

    public UserService() { // Initialisierungen der Clients
        restClient = RestClient.create();
        graphQlClient = HttpSyncGraphQlClient.create(restClient);
        graphQlClient = HttpSyncGraphQlClient.builder(restClient).url(baseURI).build();
    }

    private void logExceptionalResponse(ClientGraphQlResponse response) { // Fehler logs
        if (!response.isValid()) {
            log.error("Request failure ...");
        }
        List<ResponseError> errors = response.getErrors();
        for (ResponseError error : errors)
            log.error(error.getMessage());
    }

    public List<User> getAllUsers() {
        // GraphQL query syntax
        String document = "query { allUsers { id role firstName lastName email password } }"; // Query allUsers
                                                                                              // aufgerufen
        try {
            // retrieve data from GraphQL server
            List<User> usersList = graphQlClient.document(document).retrieveSync("allUsers").toEntityList(User.class);
            // retrieveSync("allUsers"): Diese Methode führt die Abfrage synchron aus und
            // erwartet eine Antwort mit dem Namen allUsers.
            // toEntityList(User.class): Wandelt die Antwort in eine Liste von User
            // -Objekten um.
            return usersList;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

    public List<User> getUsers(int count, int offset) {
        // GraphQL query syntax
        String document = "query { users(count: " + count + ", offset: " + offset
                + ") { id role firstName lastName email password } }";
        try {
            // retrieve data from GraphQL server
            List<User> usersList = graphQlClient.document(document).retrieveSync("users").toEntityList(User.class);
            return usersList;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

    public User getUserById(int id) {
        // GraphQL query syntax
        String document = "query { userById(id: " + id + ") { id role firstName lastName email password } }";
        try {
            // retrieve data from GraphQL server
            User user = graphQlClient.document(document).retrieveSync("userById").toEntity(User.class);
            return user;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

    public User addUser(String role, String firstName, String lastName, String email, String password) {
        // GraphQL mutation syntax
        String document = "mutation { addUser( " +
                "role: \"" + role + "\", " +
                "firstName: \"" + firstName + "\", " +
                "lastName: \"" + lastName + "\", " +
                "email: \"" + email + "\", " +
                "password: \"" + password + "\" " +
                ") " +
                "{ id role firstName lastName email password } " +
                "}";

        try {
            // retrieve data from GraphQL server
            User user = graphQlClient.document(document).retrieveSync("addUser").toEntity(User.class);
            return user;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

    public User updateUser(int id, String role, String firstName, String lastName, String email, String password) {
        // GraphQL mutation syntax
        String document = "mutation { updateUser( " +
                "id: \"" + id + "\", " +
                "role: \"" + role + "\", " +
                "firstName: \"" + firstName + "\", " +
                "lastName: \"" + lastName + "\", " +
                "email: \"" + email + "\", " +
                "password: \"" + password + "\" " +
                ") " +
                "{ id role firstName lastName email password } " +
                "}";
        try {
            // retrieve data from GraphQL server
            User user = graphQlClient.document(document).retrieveSync("updateUser").toEntity(User.class);
            return user;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

    public Integer deleteUser(int id) {
        // GraphQL mutation syntax
        String document = "mutation { deleteUser(id: " + id + ")}";
        try {
            // retrieve data from GraphQL server
            Integer integer = graphQlClient.document(document).retrieveSync("deleteUser").toEntity(Integer.class);
            return integer;
        } catch (FieldAccessException ex) {
            ClientGraphQlResponse response = ex.getResponse();
            logExceptionalResponse(response);
        }
        return null;
    }

}
