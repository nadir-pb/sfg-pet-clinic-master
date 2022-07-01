package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Speciality;

import java.util.Set;

/**
 * Created by jt on 7/31/18.
 */
public interface SpecialtyService extends CrudService<Speciality, Long> {

    Set<Speciality> getSpeciality();
}
