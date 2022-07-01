package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;

    @Mock
    SpecialtyRepository specialtyRepository;

    Long id = 1L;

    @Mock
    Speciality speciality = new Speciality();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        specialityMapService = new SpecialityMapService(specialtyRepository);
    }

    @Test
    void findAll() {

        Speciality speciality1=new Speciality();
        HashSet specialityData=new HashSet();
        specialityData.add(speciality1);

        when(specialityMapService.getSpeciality()).thenReturn(specialityData);
        Set<Speciality> specialities = specialityMapService.getSpeciality();
        assertEquals(specialities.size(),1);
        verify(specialtyRepository, times(3)).findAll();
    }

    @Test
    void findById() {
        specialityMapService.findById(id);

//        Speciality speciality1 = specialityMapService.findById(id);
//        assertEquals(id, speciality1.getId());
    }


    @Test
    void save() {
        specialityMapService.save(speciality);
    }

    @Test
    void delete() {
        specialityMapService.delete(speciality);
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(speciality.getId());
    }
}