package alexandr.service;

import alexandr.dto.BdInfoDto;
import alexandr.entitys.Car;
import alexandr.exeptions.CarAlreadyInExistException;
import alexandr.exeptions.CarDoesNotExistException;
import alexandr.exeptions.IllegalNumberException;
import alexandr.repository.CarRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CarService {
    private final CarRepo carRepo;
    private final Validator validator;

    public List<Car> getAllCars(String sortBy) {
        log.info("get all cars");
        List<Car> cars = carRepo.findAll();
        sort(sortBy, cars);
        return cars;
    }

    public BdInfoDto getBdInfo() {
        log.info("Get bd info");
        return new BdInfoDto(carRepo.countAll(), carRepo.getFirstCreateDate(), carRepo.getLastCreateDate());
    }


    @Transactional
    public void addCar(Car car) {
        if (validator.incorrectNumber(car.getNumber())) {
            throw new IllegalNumberException();
        }
        if (carRepo.existsById(car.getNumber())) {
            throw new CarAlreadyInExistException();
        }
        log.info("Add car with number " + car.getNumber());
        carRepo.save(car);
    }

    @Transactional
    public void deleteCar(String number) {
        try {
            carRepo.deleteById(number);
            log.info("Delete car with number " + number);
        } catch (EmptyResultDataAccessException e) {
            throw new CarDoesNotExistException();
        }
    }

    private void sort(String sortBy, List<Car> cars) {
        switch (sortBy) {
            case "number" : {
                cars.sort(Comparator.comparing(Car::getNumber));
                break;
            }
            case "color" : {
                cars.sort(Comparator.comparing(Car::getColor));
                break;
            }
            case "model" : {
                cars.sort(Comparator.comparing(Car::getModel));
                break;
            }
            case "year" : {
                cars.sort(Comparator.comparing(Car::getYear));
            } default:
        }
    }
}
