package org.spring.springboot.dubbo;

import java.util.List;

import org.spring.springboot.domain.City;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    @Reference(version = "1.0.0")
    CityService cityService;

    public void printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
        
        List<City> citys=cityService.findAllCity();
        
        for(City e:citys) {
        		System.out.println(e.getId());
        		System.out.println(e.getCityName());
        		cityService.deleteCity(e.getId());
        }
        
        System.out.println(citys.size());
        
    }
}
