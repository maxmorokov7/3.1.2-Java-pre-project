package web.Service;


import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {


    @Override
    public List<Car> getCars(Integer count) {
        List<Car> list = Car.getCarList();
        if (count < 1 || count > 5) return list;
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
