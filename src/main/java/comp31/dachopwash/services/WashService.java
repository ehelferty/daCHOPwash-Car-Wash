package comp31.dachopwash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.dachopwash.models.repositories.WashRepo;

@Service
public class WashService {
    WashRepo washRepo;

    @Autowired
    public WashService(WashRepo washRepo) {
        super();
        this.washRepo = washRepo;
    }
}