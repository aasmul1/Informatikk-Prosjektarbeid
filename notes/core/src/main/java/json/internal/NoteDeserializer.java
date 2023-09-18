package json.internal;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import core.Note;

public class NoteDeserializer extends JsonDeserializer<Note> {

    @Override
    public Note deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jsonParser.readValueAsTree();
        String title = node.get(NoteSerializer.TITLE_FIELD_NAME).asText();
        String text = node.get(NoteSerializer.TEXT_FIELD_NAME).asText();
        return new Note(title, text);
    }

    public Note deserialize(JsonNode node) throws IOException, JacksonException {
        final ObjectNode objectNode = (ObjectNode) node;
        final String title = objectNode.get(NoteSerializer.TITLE_FIELD_NAME).asText();
        final String text =objectNode.get(NoteSerializer.TEXT_FIELD_NAME).asText();
        return new Note(title, text);
    }
    
}
