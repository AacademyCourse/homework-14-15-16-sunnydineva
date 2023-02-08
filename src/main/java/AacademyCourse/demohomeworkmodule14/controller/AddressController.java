package AacademyCourse.demohomeworkmodule14.controller;

import AacademyCourse.demohomeworkmodule14.entity.Address;
import AacademyCourse.demohomeworkmodule14.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/sayHello")
    public String sayAddress() {
        return "Hello from address controller";
    }

    @GetMapping("/get/{id}")
    public Optional<Address> getAddress(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping(path = "/add")
    public Address createAddress(@RequestBody Address address) {
        Address addressToBeCreated = new Address();
        addressToBeCreated.setCountry(address.getCountry());
        addressToBeCreated.setCity(address.getCity());
        addressToBeCreated.setStreet(address.getStreet());
        addressToBeCreated.setStreetNumber(address.getStreetNumber());

        return addressService.saveAddress(addressToBeCreated);
    }

    @DeleteMapping(path = "/remove/{id}")
    public String deleteAddress(@PathVariable Long id){
        this.addressService.deleteById(id);
        return String.format("Address with %s id is deleted", id);
    }
}