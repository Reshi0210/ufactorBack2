package com.example.demo.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.demo.models.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.WorkerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

public class WorkerServiceTest {

    @InjectMocks
    private WorkerService workerService;

    @Mock
    private WorkerRepository workerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateWorker() {
        // Preparar un objeto Worker simulado para la prueba
        Worker w1 = new Worker();
        w1.setCi("94100226768");
        w1.setFirstName("John");


        // Simula el comportamiento del repositorio para guardar el trabajador
        when(workerRepository.save(any(Worker.class))).thenReturn(w1);

        // Llama al método createWorker en WorkerService
        ResponseEntity<Worker> responseEntity = workerService.createWorker(w1);

        // Verifica que la respuesta sea un código 200 (OK)
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Verifica que el objeto Worker devuelto coincida con el objeto simulado
        assertEquals(w1, responseEntity.getBody());
    }

    @Test
    public void testFindByIdl() {
        // Preparar un número de id simulado para la prueba
        Long id = Long.valueOf(1);

        // Simula el comportamiento del repositorio para buscar un trabajador por CI
        Worker w1 = new Worker();
        w1.setId(id);
        when(workerRepository.findById(id)).thenReturn(java.util.Optional.of(w1));

        // Llama al método findByIdl en WorkerService
        ResponseEntity<Worker> responseEntity = workerService.findByIdl(id);

        // Verifica que la respuesta sea un código 200 (OK)
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Verifica que el objeto Worker devuelto coincida con el objeto simulado
        assertEquals(w1, responseEntity.getBody());
    }

    @Test
    public void testUpdateWorker() {
        // Preparar un número de CI simulado para la prueba
        long id = Long.valueOf(500);

        // Preparar un objeto Worker simulado para la prueba
        Worker existingWorker = new Worker();
        existingWorker.setId(id);
        // Establece otras propiedades necesarias

        // Simula el comportamiento del repositorio para buscar un trabajador por CI
        when(workerRepository.findById(id)).thenReturn(java.util.Optional.of(existingWorker));

        // Preparar un objeto Worker actualizado
        Worker updatedWorker = new Worker();
        updatedWorker.setId(Long.valueOf(500));
        // Establece las propiedades actualizadas

        // Llama al método updateWorker en WorkerService
        ResponseEntity<Worker> responseEntity = workerService.updateWorker(id, updatedWorker);

        // Verifica que la respuesta sea un código 200 (OK)
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Verifica que el objeto Worker devuelto coincida con el objeto actualizado
        assertEquals(updatedWorker, responseEntity.getBody());
    }

    @Test
    public void testDeleteWorker() {
        // Preparar un número de CI simulado para la prueba
        long id =Long.valueOf(501);

        // Simula el comportamiento del repositorio para buscar un trabajador por CI
        Worker existingWorker = new Worker();
        existingWorker.setId(id);
        when(workerRepository.findById(id)).thenReturn(java.util.Optional.of(existingWorker));

        // Llama al método deleteWorker en WorkerService
        ResponseEntity<Map<String, Boolean>> responseEntity = workerService.deleteWorker(id);

        // Verifica que la respuesta sea un código 200 (OK)
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Verifica que el mapa de respuesta indique que el trabajador fue eliminado correctamente
        assertTrue(responseEntity.getBody().get("deleted"));
    }
}