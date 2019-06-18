package com.springframework.sfgpetclinic.services.springdatajpa;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.springframework.sfgpetclinic.repositories.PetRepository;
import com.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Nidhal on 18/06/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    private Owner returnOwner;

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this);
        System.out.println("I'm here in BeforeTest ==========> setUp");
        returnOwner = Owner.builder().id(28L).firstName("Aouini").lastName("Hamid").build();
    }

    @Test
    public void testFindByLastName() throws Exception {
      Owner ownerSave = Owner.builder().id(10L).lastName("ahmed").build();
      when(ownerRepository.findByLastName(any())).thenReturn(ownerSave);
        Owner ownerTest = ownerSDJpaService.findByLastName("ahmed");

        assertTrue(ownerTest.getLastName().equalsIgnoreCase("AHMED"));
        verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    public void testFindAll() throws Exception {

        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(11L).firstName("ferjani").build());
        ownerSet.add(Owner.builder().id(16L).firstName("ferjani").build());
        ownerSet.add(Owner.builder().id(17L).firstName("ferjani").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(3,ownerSDJpaService.findAll().size());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
       when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
       Owner owner = ownerRepository.findById(28L).get();

        assertNotNull(owner);

        verify(ownerRepository,times(1)).findById(anyLong());
    }

    @Test
    public void testSave() throws Exception {

      when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner testOwner = ownerSDJpaService.save(returnOwner);

        assertEquals(new Long(28),testOwner.getId());
    }

    @Test
    public void testDelete() throws Exception {
     ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    public void testDeleteById() throws Exception {
        ownerSDJpaService.deleteById(18L);
        verify(ownerRepository,times(1)).deleteById(any());
    }
}