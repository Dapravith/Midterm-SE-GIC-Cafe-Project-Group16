package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import gic.i4c.GicCafe.model.Addons;
import gic.i4c.GicCafe.repository.AddonsRepository;
import gic.i4c.GicCafe.service.AddonsService;

@Service

public class AddonsServiceImplement implements AddonsService {

    private AddonsRepository addonsRepository;

    public AddonsServiceImplement(AddonsRepository addonsRepository) {
        super();
        this.addonsRepository = addonsRepository;
    }

    @Override
    public Addons getCream() {
        return addonsRepository.findByName("cream");
    }

    @Override
    public List<Addons> getSugar() {
        return addonsRepository.findMultipleByName("sugar");
    }
    
}
