package com.springframework.sfgpetclinic.controllers;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Nidhal on 18/06/2019.
 */

public class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> ownerSet;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        ownerSet = new HashSet<>();

        ownerSet.add(Owner.builder().id(10L).firstName("nidhal").lastName("Ferjani").build());
        ownerSet.add(Owner.builder().id(20L).firstName("Ali").lastName("ben hamza").build());

    }

    @Test
    public void testListOwners() throws Exception {

        when(ownerService.findAll()).thenReturn(ownerSet);

       /* String viewName = ownerController.listOwners(model);

        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        verify(ownerService,times(1)).findAll();
        assertTrue(viewName.equalsIgnoreCase("owners/index"));

        verify(model,times(1)).addAttribute(eq("owners"), argumentCaptor.capture());

        Set<Owner> setTest = argumentCaptor.getValue();

        assertEquals(2,setTest.size());*/

        mockMvc.perform(get("/owners"))
                .andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    public void testListOwnersByIndex() throws Exception {

        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }


    @Test
    public void testFindOwners() throws Exception {

       // String viewName = ownerController.findOwners();
       //  assertTrue(viewName.equalsIgnoreCase("notimplemented"));

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}