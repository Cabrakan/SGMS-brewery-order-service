package guru.sfg.beer.order.service.util.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import guru.sfg.beer.order.service.web.model.BaseItem;

import java.io.IOException;

// TODO: Base class serializer gets overridden by child class serializer!
public class BaseItemSerializer extends StdSerializer<BaseItem> {
    public BaseItemSerializer() {
        this(null);
    }

    public BaseItemSerializer(Class<BaseItem> t) {
        super(t);
    }


    @Override
    public void serialize(BaseItem baseItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("version", baseItem.getVersion());
        jsonGenerator.writeObjectField("createdDate", baseItem.getCreatedDate());
        jsonGenerator.writeObjectField("lastModifiedDate", baseItem.getLastModifiedDate());
        jsonGenerator.writeObjectField("id", baseItem.getId());
        jsonGenerator.writeEndObject();
    }
}
