package com.example.demo.Test;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Scholarship;
import com.example.demo.models.scholarLevel;
import com.example.demo.repository.ScholarShipRepository;
import com.example.demo.service.ScholarShipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ScholarShipServiceTest {

    @InjectMocks
    private ScholarShipService scholarShipService;

    @Mock
    private ScholarShipRepository scholarShipRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAll() {
        // Mock del repositorio para devolver una lista de becas simulada
        List<Scholarship> scholarships = new ArrayList<>();
        scholarships.add(new Scholarship());
        when(scholarShipRepository.findAll()).thenReturn(scholarships);

        List<Scholarship> result = scholarShipService.all();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testFindById_ExistingId() {
        long id = 1L;
        Scholarship scholarship = new Scholarship();
        scholarship.setId(id);

        // Configurar el comportamiento del mock del repositorio para devolver una beca simulada
        when(scholarShipRepository.findById(id)).thenReturn(Optional.of(scholarship));

        ResponseEntity<Scholarship> response = scholarShipService.findById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    public void testFindById_NonExistingId() {
        long id = 1L;

        // Configurar el comportamiento del mock del repositorio para devolver un Optional vacío
        when(scholarShipRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> scholarShipService.findById(id));
    }

    @Test
    public void testCreate() {
        Scholarship scholarship = new Scholarship();

        scholarShipService.create(scholarship);

        // Verificar que el método save del repositorio se llamó una vez con la beca
        verify(scholarShipRepository, times(1)).save(scholarship);
    }

    @Test
    public void testUpdate_ExistingId() {
        long id = 1L;
        Scholarship existingScholarship = new Scholarship();
        existingScholarship.setId(id);

        Scholarship updatedScholarship = new Scholarship();
        updatedScholarship.setId(id);

        // Configurar el comportamiento del mock del repositorio para devolver la beca existente
        when(scholarShipRepository.findById(id)).thenReturn(Optional.of(existingScholarship));
        when(scholarShipRepository.save(updatedScholarship)).thenReturn(updatedScholarship);

        ResponseEntity<Scholarship> response = scholarShipService.update(id, updatedScholarship);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    public void testUpdate_NonExistingId() {
        long id = 1L;
        Scholarship updatedScholarship = new Scholarship();
        updatedScholarship.setId(id);

        // Configurar el comportamiento del mock del repositorio para devolver un Optional vacío
        when(scholarShipRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> scholarShipService.update(id, updatedScholarship));
    }

    @Test
    public void testDelete_ExistingId() {
        long id = 1L;
        Scholarship scholarshipToDelete = new Scholarship();
        scholarshipToDelete.setId(id);

        // Configurar el comportamiento del mock del repositorio para devolver la beca existente
        when(scholarShipRepository.findById(id)).thenReturn(Optional.of(scholarshipToDelete));

        ResponseEntity<Map<String, Boolean>> response = scholarShipService.delete(id);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().get("deleted"));
    }

    @Test
    public void testDelete_NonExistingId() {
        long id = 1L;

        // Configurar el comportamiento del mock del repositorio para devolver un Optional vacío
        when(scholarShipRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> scholarShipService.delete(id));
    }
}