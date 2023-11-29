package guru.sfg.beer.order.service.util.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;

import java.io.IOException;

// TODO: --------------------------
// TODO: !!! Assignment for AOP !!!
// TODO: --------------------------
// TODO: Create a custom annotation that takes class fields in any order and return proper JSON according to that order
public class BeerOrderSerializer extends StdSerializer<BeerOrderDto> {
    public BeerOrderSerializer() {
        this(null);
    }
    public BeerOrderSerializer(Class<BeerOrderDto> t) {
        super(t);
    }

    @Override
    public void serialize(BeerOrderDto beerOrderDto,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("id", beerOrderDto.getId());
        jsonGenerator.writeObjectField("customerId", beerOrderDto.getCustomerId());
        jsonGenerator.writeObjectField("customerRef", beerOrderDto.getCustomerRef());
        jsonGenerator.writeObjectField("version", beerOrderDto.getVersion());
        jsonGenerator.writeObjectField("beerOrderLines", beerOrderDto.getBeerOrderLines());
        jsonGenerator.writeObjectField("orderStatus", beerOrderDto.getOrderStatus());
        jsonGenerator.writeObjectField("orderStatusCallbackUrl", beerOrderDto.getOrderStatusCallbackUrl());
        jsonGenerator.writeObjectField("createdDate", beerOrderDto.getCreatedDate());
        jsonGenerator.writeObjectField("lastModifiedDate", beerOrderDto.getLastModifiedDate());
        jsonGenerator.writeEndObject();
    }
}
