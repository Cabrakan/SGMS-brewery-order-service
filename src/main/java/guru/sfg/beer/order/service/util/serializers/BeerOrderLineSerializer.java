package guru.sfg.beer.order.service.util.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;

import java.io.IOException;

public class BeerOrderLineSerializer extends StdSerializer<BeerOrderLineDto> {
    public BeerOrderLineSerializer() {
        this(null);
    }

    public BeerOrderLineSerializer(Class<BeerOrderLineDto> t) {
        super(t);
    }

    @Override
    public void serialize(BeerOrderLineDto beerOrderLineDto,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("beerName", beerOrderLineDto.getBeerName());
        jsonGenerator.writeObjectField("beerStyle", beerOrderLineDto.getBeerStyle());
        jsonGenerator.writeObjectField("beerId", beerOrderLineDto.getBeerId());
        jsonGenerator.writeObjectField("orderQuantity", beerOrderLineDto.getOrderQuantity());
        jsonGenerator.writeObjectField("price", beerOrderLineDto.getPrice());
        jsonGenerator.writeObjectField("upc", beerOrderLineDto.getUpc());
        jsonGenerator.writeEndObject();
    }
}
