package pe.edu.cibertec.Autos_BackEnd.service;

import pe.edu.cibertec.Autos_BackEnd.dto.CarRequestDTO;
import java.io.IOException;

public interface SearchService {

    Object[] findCar(CarRequestDTO carRequestDTO) throws IOException;

}
