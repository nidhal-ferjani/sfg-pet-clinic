package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.services.PetService;
import com.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Nidhal on 17/06/2019.
 */
public class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 14L;

    @Mock
    PetTypeService petTypeService;
    @Mock
    PetService petService;


    @Before
    public void setUp() throws Exception {

      MockitoAnnotations.initMocks(this);
      ownerServiceMap = new OwnerServiceMap(petTypeService, petService);

      ownerServiceMap.save(Owner.builder().id(ownerId).build());
    }

    @Test
    public void testFindAll() throws Exception {
        Set<Owner> set = ownerServiceMap.findAll();
        assertEquals(1,set.size());
    }



    @Test
    public void testFindById() throws Exception {

        Owner owner = ownerServiceMap.findById(ownerId);
        assertNotNull(owner);
    }

    @Test
    public void testSaveExistID() throws Exception {
      Long id = 12L;
      Owner owner2 = Owner.builder().id(id).build();
      Owner ownerSave = ownerServiceMap.save(owner2);
      assertEquals(id,ownerSave.getId());
    }

    @Test
    public void testSaveNotID() throws Exception {
      Owner ownerSave = ownerServiceMap.save(Owner.builder().build());
      assertNotNull(ownerSave);
      assertNotNull(ownerSave.getId());
    }

    @Test
    public void testDelete() throws Exception {
      ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
      assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    public void testDeleteById() throws Exception {
     ownerServiceMap.deleteById(ownerId);
     assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    public void testFindByLastName() throws Exception {
     ownerServiceMap.save(Owner.builder().id(17L).firstName("Ferjani").lastName("nidhal").build());
        System.out.println("FirstName = " + ownerServiceMap.findById(17L).getLastName());
       assertNotNull(ownerServiceMap.findByLastName("nidhal"));
    }

    @Test
    public void testFindByLastNameNotFound() throws Exception {

        Owner owner = ownerServiceMap.findByLastName("nidouch");
        assertNull(owner);

    }
}