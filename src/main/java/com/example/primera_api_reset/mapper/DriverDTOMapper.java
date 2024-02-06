package com.example.primera_api_reset.mapper;

import org.springframework.stereotype.Service;
import java.util.function.Function;
import com.example.primera_api_reset.model.Driver;
import com.example.primera_api_reset.DTO.DriverDTO;

@Service
public class DriverDTOMapper implements Function<Driver, DriverDTO> {

    @Override
    public DriverDTO apply(Driver driver) {
        if (driver == null) {
            return null;
        }

        // Usamos el constructor de DriverDTO para crear un nuevo objeto DriverDTO
        return new DriverDTO(driver);
    }
}
