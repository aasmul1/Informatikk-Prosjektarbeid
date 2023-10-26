package json.internal;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import core.Accounts;
import core.User;

public class AccountsDeserializer extends JsonDeserializer<Accounts> {
    private final UserDeserializer userDeserializer = new UserDeserializer();

    
    @Override
    public Accounts deserialize(JsonParser jsonParser, DeserializationContext deserContext) throws IOException, JacksonException {
        final JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        Accounts accounts = new Accounts();
        if (jsonNode instanceof ArrayNode) {
            ArrayNode userArray = (ArrayNode) jsonNode;
            for (JsonNode userNode : userArray) {
                User user = userDeserializer.deserialize(userNode);
                accounts.addUser(user);
            }
            return accounts;
        }
        return null;
    }
}
