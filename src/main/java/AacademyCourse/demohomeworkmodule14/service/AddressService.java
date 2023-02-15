package AacademyCourse.demohomeworkmodule14.service;

import AacademyCourse.demohomeworkmodule14.entity.Address;
import AacademyCourse.demohomeworkmodule14.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public Optional<Address> getById(Long id){
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address){
        Address addressToBeCreated = new Address();
        addressToBeCreated.setCountry(address.getCountry());
        addressToBeCreated.setCity(address.getCountry());
        addressToBeCreated.setStreet(address.getStreet());
        addressToBeCreated.setStreet(address.getStreetNumber());
        return addressRepository.save(addressToBeCreated);
    }

    public void deleteById(Long id){
        this.addressRepository.deleteById(id);
    }
}
