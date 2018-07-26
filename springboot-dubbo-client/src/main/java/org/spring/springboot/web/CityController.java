package org.spring.springboot.web;

import java.util.List;

import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.CityDubboConsumerService;
import org.spring.springboot.dubbo.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * Book 控制层
 *
 * Created by bysocket on 27/09/2017.
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Reference(version = "1.0.0")
    CityService cityService;

    @Autowired
    CityDubboConsumerService cityDubboConsumerService;
    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @RequestMapping(value = "/getCityList",method = RequestMethod.GET)
    public List<City> getCityList() {
        List<City> citys=cityService.findAllCity();
        
        for(City e:citys) {
        		System.out.println(e.getId());
        		System.out.println(e.getCityName());
        }
        
        System.out.println(citys.size());
        
        return citys;
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name) {
    		String hello="hello"+name;
    		return hello;
    }

    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)
    public List<City> helloworld(String name) {
     return 	cityDubboConsumerService.printCity();
    }


}
