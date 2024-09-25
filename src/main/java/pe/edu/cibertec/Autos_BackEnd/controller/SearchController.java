package pe.edu.cibertec.Autos_BackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Autos_BackEnd.dto.CarRequestDTO;
import pe.edu.cibertec.Autos_BackEnd.dto.CarResponseDTO;
import pe.edu.cibertec.Autos_BackEnd.service.SearchService;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/searching")
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/searched")
    public CarResponseDTO searched(@RequestBody CarRequestDTO carRequestDTO){
        try{
            Object[] dataCar = searchService.findCar(carRequestDTO);
            System.out.println("Result : " + Arrays.toString(dataCar));

            if(dataCar == null){
                return new CarResponseDTO("01", "ERROR: Vehiculo no encontrado", "", "", 0, 0.0, "");
            }

            return new CarResponseDTO("00", "", (String) dataCar[0], (String) dataCar[1], (Integer) dataCar[2], (Double) dataCar[3], (String) dataCar[4]);
        }catch (IOException e){
            return new CarResponseDTO("99", "ERROR: Ocurrió un problema", "", "", 0, 0.0,"");
        }
    }

}
