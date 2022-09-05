package com.example.springboot07graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springboot07graphql.dto.VehicleDTO;
import com.example.springboot07graphql.entity.Vehicle;
import com.example.springboot07graphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;


    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        return vehicleRepository.save(dtoToEntity(vehicleDTO));
    }

    private Vehicle dtoToEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle =new Vehicle();
        vehicle.setType(vehicleDTO.getType());
        vehicle.setBrandName(vehicleDTO.getBrandName());
        vehicle.setModelCode(vehicle.getModelCode());
        vehicle.setLaunchDate(new Date());
        return vehicle;
    }
}
