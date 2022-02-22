package alexandr.controller;

import alexandr.dto.BdInfoDto;
import alexandr.dto.SuccessDto;
import alexandr.entitys.Car;
import alexandr.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService workerService) {
        this.carService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllWorker( @RequestParam(name = "sort", defaultValue = "noSort") String sortBy ) {
        return new ResponseEntity<>(carService.getAllCars(sortBy), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    private ResponseEntity<SuccessDto> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    private ResponseEntity<SuccessDto> deleteCar(@PathVariable String number) {
        carService.deleteCar(number);
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @GetMapping("/info")
    private ResponseEntity<BdInfoDto> getBdInfo() {
        return new ResponseEntity<>(carService.getBdInfo(), HttpStatus.OK);
    }
}
