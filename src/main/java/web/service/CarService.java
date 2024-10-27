package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public static List<Car> getCars(List<Car> list, int number) {
        if ((number < 1) || (number >= 5)) {
            return list;
        } else {
            List<Car> aList = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                aList.add(list.get(i));
            }
            return aList;
        }
    }
}
