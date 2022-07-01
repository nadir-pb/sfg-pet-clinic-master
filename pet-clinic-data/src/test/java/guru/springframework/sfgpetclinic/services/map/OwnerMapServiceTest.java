package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final String lastname = "jabbarli";

    final Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastname).build());
    }

    @Test
    void testFindAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());

    }

    @Test
    void testFindById() {
        Owner owner = ownerMapService.findById(id);
        assertEquals(id, owner.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void testDelete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void testDeleteById() {
        ownerMapService.deleteById(id);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void testFindByLastName() {
        Owner jabbarli = ownerMapService.findByLastName(lastname);
        assertNotNull(jabbarli);
        assertEquals(id,jabbarli.getId());
    }

    @Test
    void findAllByLastNameLike() {
    }
}