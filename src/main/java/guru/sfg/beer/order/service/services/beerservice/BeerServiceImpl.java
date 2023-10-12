package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class BeerServiceImpl implements BeerService {
    private final RestTemplate restTemplate;
    private final String BEER_SERVICE_BASE_PATH = "/api/v1/beer";
    @Value("${brewery.beer-service-host}")
    private String beerServiceHost;

    public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getBeerServiceHost() {
        return beerServiceHost;
    }

//    @Override
//    public Optional<BeerDto> getBeerDetails(String beerUpc) {
//        String url = beerServiceHost + BEER_SERVICE_BASE_PATH + "/upc/{beerUpc}";
//
//        ResponseEntity<BeerDto> exchange = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                BeerDto.class,
//                beerUpc
//        );
//
//        return Optional.of(exchange.getBody());
//    }

    @Override
    public Optional<BeerDto> getBeerDetails(String beerUpc) {
        String url = beerServiceHost + BEER_SERVICE_BASE_PATH + "/upc/";

        return Optional.ofNullable(restTemplate.getForObject(url + beerUpc, BeerDto.class));
    }
}
