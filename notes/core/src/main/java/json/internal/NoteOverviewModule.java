package json.internal;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

import core.Note;
import core.NoteOverview;

public class NoteOverviewModule extends Module {

    @Override
    public String getModuleName() {
        return "NoteOverviewModule";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    private final SimpleDeserializers deserializers = new SimpleDeserializers();
    private final SimpleSerializers serializers = new SimpleSerializers();

    public NoteOverviewModule() {
        serializers.addSerializer(Note.class, new NoteSerializer());
        serializers.addSerializer(NoteOverview.class, new NoteOverviewSerializer());
        deserializers.addDeserializer(Note.class, new NoteDeserializer());
        deserializers.addDeserializer(NoteOverview.class, new NoteOverviewDeserializer());
    }

    @Override
    public void setupModule(SetupContext context) {
        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }
    
}
