package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.services.beerservice.BeerService;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import org.springframework.beans.factory.annotation.Autowired;

public class BeerOrderMapperDecorator implements BeerOrderMapper {
    private BeerOrderMapper beerOrderMapper;

    @Autowired
    public void setBeerOrderMapper(BeerOrderMapper beerOrderMapper) {
        this.beerOrderMapper = beerOrderMapper;
    }


    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        BeerOrderDto beerOrderDto = beerOrderMapper.beerOrderToDto(beerOrder);
        beerOrderDto.setCustomerId(beerOrder.getCustomer().getId());
        return beerOrderDto;
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        return beerOrderMapper.dtoToBeerOrder(dto);
    }
}
