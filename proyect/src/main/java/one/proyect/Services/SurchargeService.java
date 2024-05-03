package one.proyect.Services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import one.proyect.Entities.SurchargeEntity;
import one.proyect.Repositories.SurchargeRepository;

@Service
public class SurchargeService {

    @Autowired
    private SurchargeRepository surchargeRepository;

    public List<SurchargeEntity> getSurchargesByTypeSurcharge(Long id) {
        return surchargeRepository.findByTypeSurcharge(id);
    }

    public SurchargeEntity getSurchargeById(Long id) {
        return surchargeRepository.findById(id).orElse(null);
    }

}
