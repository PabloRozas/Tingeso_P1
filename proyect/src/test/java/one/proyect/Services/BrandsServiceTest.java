package one.proyect.Services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import one.proyect.Entities.BrandsEntity;
import one.proyect.Entities.Report3;
import one.proyect.Entities.Report3_2;
import one.proyect.Repositories.BrandsRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@SpringBootTest
@ActiveProfiles("test")
public class BrandsServiceTest {
    @Autowired
    private BrandsService brandsService;

    @MockBean
    private BrandsRepository brandsRepository;

    @Test
    public void getBrandByIdTest() {
        BrandsEntity brand = new BrandsEntity();
        brand.setId(1L);
        brand.setName("Toyota");

        when(brandsRepository.findById(1L)).thenReturn(Optional.of(brand));

        assertEquals(brand, brandsService.getBrandById(1L));
    }

    @Test
    public void getAllBrandsTest() {
        BrandsEntity brand = new BrandsEntity();
        brand.setId(1L);
        brand.setName("Toyota");

        when(brandsRepository.findAll()).thenReturn(List.of(brand));

        assertEquals(List.of(brand), brandsService.getAllBrands());
    }

}
