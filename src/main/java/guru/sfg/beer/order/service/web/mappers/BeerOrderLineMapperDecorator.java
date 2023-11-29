package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beerservice.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {
    private BeerOrderLineMapper beerOrderLineMapper;
    private BeerService beerService;

    @Autowired
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }


    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine beerOrderLine) throws NotFoundException {
        BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(beerOrderLine);
        Optional<BeerDto> beerDetails = beerService.getBeerDetails(beerOrderLine.getUpc());

        if (beerDetails.isPresent()) {
            beerOrderLineDto.setBeerId(beerDetails.get().getId());
            beerOrderLineDto.setBeerName(beerDetails.get().getBeerName());
            beerOrderLineDto.setBeerStyle(beerDetails.get().getBeerStyle().name());
            beerOrderLineDto.setPrice(beerDetails.get().getPrice());
        } else {
            log.error("Beer details is empty!");
        }

        return beerOrderLineDto;
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return beerOrderLineMapper.dtoToBeerOrderLine(dto);
    }
}
