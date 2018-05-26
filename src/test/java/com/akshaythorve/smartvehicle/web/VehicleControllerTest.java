package com.akshaythorve.smartvehicle.web;

import com.akshaythorve.smartvehicle.SpringSmartVehicleSystemApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringSmartVehicleSystemApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyAllVehicleList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4))).andDo(print());
    }

    @Test
    public void verifyVehicleById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.Id").exists())
                .andExpect(jsonPath("$.Make").exists())
                .andExpect(jsonPath("$.Model").exists())
                .andExpect(jsonPath("$.Id").value(3))
                .andExpect(jsonPath("$.Make").value("Tesla"))
                .andExpect(jsonPath("$.Model").value("ModelX"))
                .andDo(print());
    }

    @Test
    public void verifyInvalidVehicleArgument() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/f").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."))
                .andDo(print());
    }

    @Test
    public void verifyInvalidVehicleId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Vehicle doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyNullVehicle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/6").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Vehicle doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyDeleteVehicle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/vehicles/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Vehicle has been deleted"))
                .andDo(print());
    }

    @Test
    public void verifyInvalidVehicleIdToDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/vehicles/9").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Vehicle doesn´t exist to delete"))
                .andDo(print());
    }


    @Test
    public void verifySaveVehicle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"Year\" : \"2017\", \"Make\" : \"Ford\", \"Model\" : \"Fusion\" }")
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.Make").exists())
                .andExpect(jsonPath("$.Model").exists())
                .andExpect(jsonPath("$.Make").value("Ford"))
                .andExpect(jsonPath("$.Model").value("Fusion"))
                .andDo(print());
    }

    @Test
    public void verifyMalformedSaveVehicle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"Id\": \"8\", \"Make\" : \"Ford\", \"Model\" : \"Fusion\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Error in request , id must not be defined"))
                .andDo(print());
    }

    @Test
    public void verifyUpdateVehicle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"Id\": \"1\",\"Year\": \"2018\", \"Make\" : \"Ford\", \"Model\" : \"Fusion\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.Year").exists())
                .andExpect(jsonPath("$.Make").exists())
                .andExpect(jsonPath("$.Model").exists())
                .andExpect(jsonPath("$.Year").value(2018))
                .andExpect(jsonPath("$.Make").value("Ford"))
                .andExpect(jsonPath("$.Model").value("Fusion"))
                .andDo(print());
    }



}
