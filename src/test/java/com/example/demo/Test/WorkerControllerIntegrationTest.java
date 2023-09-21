package com.example.demo.Test;

import com.example.demo.controller.WorkerController;
import com.example.demo.models.Worker;
import com.example.demo.service.WorkerService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@AllArgsConstructor
public class WorkerControllerIntegrationTest {

    @InjectMocks
    private WorkerController workerController;

    @Mock
    private WorkerService workerService;


    private MockMvc mockMvc;

    public WorkerControllerIntegrationTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllWorkers() throws Exception {
        // Simulamos una lista de trabajadores
        List<Worker> workers = Arrays.asList(new Worker(), new Worker());

        // Configuramos el comportamiento del servicio simulado (Mock)
        when(workerService.allWorkers(anyInt(), anyInt())).thenReturn((Page<Worker>) workers);

        // Realizamos la solicitud HTTP simulada al endpoint "/api/v1/all"
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2)); // Verifica que se devuelvan 2 trabajadores
    }

    @Test
    public void testCreateWorker() throws Exception {
        Worker newWorker = new Worker(); // Crear un nuevo trabajador de prueba

        // Configurar el comportamiento del servicio simulado (Mock)
        when(workerService.createWorker(newWorker)).thenReturn(ResponseEntity.ok(newWorker));

        // Realizar la solicitud HTTP simulada al endpoint "/api/v1/create" con un JSON del nuevo trabajador
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"John\", \"age\": 30 }")) // Ajusta los datos del nuevo trabajador según tus necesidades
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John")); // Verificar la respuesta esperada
    }

    @Test
    public void testFindByIdl() throws Exception {
        long workerId = 123; // ID de trabajador de prueba
        Worker worker = new Worker();
        worker.setId(workerId);

        // Configurar el comportamiento del servicio simulado (Mock)
        when(workerService.findByIdl(workerId)).thenReturn(ResponseEntity.of(Optional.of(worker)));

        // Realizar la solicitud HTTP simulada al endpoint "/api/v1/findById/{CI}"
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/findById/" + workerId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(workerId)); // Verificar la respuesta esperada
    }

    @Test
    public void testUpdateWorker() throws Exception {
        long workerId = 456; // ID de trabajador de prueba
        Worker updatedWorker = new Worker(); // Datos de trabajador actualizados

        // Configurar el comportamiento del servicio simulado (Mock)
        when(workerService.updateWorker(workerId, updatedWorker)).thenReturn(ResponseEntity.ok(updatedWorker));

        // Realizar la solicitud HTTP simulada al endpoint "/api/v1/update/{CI}" con un JSON del trabajador actualizado
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/update/" + workerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Updated Name\", \"age\": 35 }")) // Ajusta los datos actualizados según tus necesidades
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Name")); // Verificar la respuesta esperada
    }

    @Test
    public void testDeleteWorker() throws Exception {
        long workerId = 789; // ID de trabajador de prueba

        // Configurar el comportamiento del servicio simulado (Mock)
        when(workerService.deleteWorker(workerId)).thenReturn(ResponseEntity.ok().build());

        // Realizar la solicitud HTTP simulada al endpoint "/api/v1/delete/{CI}"
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/delete/" + workerId))
                .andExpect(status().isOk()); // Verificar que la solicitud sea exitosa
    }


}