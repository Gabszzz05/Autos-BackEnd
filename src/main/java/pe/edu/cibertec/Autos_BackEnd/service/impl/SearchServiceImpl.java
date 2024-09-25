package pe.edu.cibertec.Autos_BackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Autos_BackEnd.dto.CarRequestDTO;
import pe.edu.cibertec.Autos_BackEnd.service.SearchService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] findCar(CarRequestDTO carRequestDTO) throws IOException {
        String[] dataCar = null;

        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String line;
            while((line = br.readLine()) != null ) {
                String[] data = line.split(";");
                if(carRequestDTO.placa().equals(data[1])){
                    dataCar = new String[5];
                    dataCar[0] = data[2];
                    dataCar[1] = data[3];
                    dataCar[2] = data[4];
                    dataCar[3] = data[5];
                    dataCar[4] = data[6];
                    break;
                }
            }
        }catch (IOException e){
            dataCar = null;
            throw new IOException(e);
        }

        return dataCar;
    }
}
