package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Disabled
@SpringBootTest
class BeerServiceImplTest {
    @Autowired
    BeerServiceImpl beerService;

    @Test
    void getBeerDetailsReturnsBeerDto() {
        String upc = "0631234200036";
        BeerDto beerDto = beerService.getBeerDetails(upc);

        assertThat(beerDto)
                .isNull();
    }
}