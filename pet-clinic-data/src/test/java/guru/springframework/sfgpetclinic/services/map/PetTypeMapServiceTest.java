package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;

    @Mock
    PetType petType=new PetType();

    Long id = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
    }

    @Test
    void findAll() {
        petTypeMapService.findAll();
    }

    @Test
    void findById() {
        petTypeMapService.findById(id);
    }

    @Test
    void save() {
        petTypeMapService.save(petType);
    }

    @Test
    void delete() {
        petTypeMapService.delete(petType);
    }

    @Test
    void deleteById() {
        petTypeMapService.delete(petType);
    }
}