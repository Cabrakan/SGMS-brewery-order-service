package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;

public interface BeerService {
    BeerDto getBeerDetails(String upc);
}
