package json.internal;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import core.NoteOverview;
import core.User;

public class UserDeserializer extends JsonDeserializer<User> {
    private final NoteOverviewDeserializer noteOverviewDeserializer = new NoteOverviewDeserializer();



    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jsonParser.readValueAsTree();
        String username = node.get(UserSerializer.USERNAME_FIELD_NAME).asText();
        String password = node.get(UserSerializer.PASSWORD_FIELD_NAME).asText();
        NoteOverview noteOverview = noteOverviewDeserializer.deserialize(jsonParser, ctxt);

        return new User(username, password, noteOverview);
    }
    
    public User deserialize(JsonNode node) throws IOException, JacksonException {
        ObjectNode objectNode = (ObjectNode) node;
        String username = objectNode.get(UserSerializer.USERNAME_FIELD_NAME).asText();
        String password =objectNode.get(UserSerializer.PASSWORD_FIELD_NAME).asText();
        NoteOverview noteOverview = noteOverviewDeserializer.deserialize(objectNode.get(UserSerializer.NOTEOVERVIEW_FIELD_NAME));


        return new User(username, password, noteOverview);
    }
}
