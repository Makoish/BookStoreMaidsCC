package com.maids.cc.bookStore.service;

import com.maids.cc.bookStore.model.Patron;
import com.maids.cc.bookStore.repository.PatronRepository;
import org.springframework.stereotype.Service;


@Service
public class PatronService {

    private final PatronRepository patronRepository;
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }



    public Iterable<Patron> get(){
        return patronRepository.findAll();
    }


    public Patron get(Integer id){
        return patronRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        patronRepository.deleteById(id);
    }

    public Patron save(Patron patron){
        patronRepository.save(patron);
        return patron;
    }

    public Patron updateItem(Integer id, Patron updatedItem) {
        return patronRepository.findById(id)
                .map(Patron -> {
                    Patron.setFirstName(updatedItem.getFirstName());
                    Patron.setLastName(updatedItem.getLastName());
                    Patron.setEmail(updatedItem.getPhoneNO());
                    Patron.setPhoneNO(updatedItem.getPhoneNO());
                    return patronRepository.save(Patron);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
    }
}

