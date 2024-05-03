package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.DiscountRepository;
import one.proyect.Entities.DiscountEntity;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    public List<DiscountEntity> getDiscounts(Long id_engine_type, Long id_discount_type) {
        return discountRepository.findAllByEngineTypeIdAndDiscountTypeId(id_engine_type, id_discount_type);
    }

    List<DiscountEntity> getDiscountsByTypeDiscount(Long id_discount_type) {
        return discountRepository.findAllByDiscountTypeId(id_discount_type);
    }

    public DiscountEntity getDiscountById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }
}
