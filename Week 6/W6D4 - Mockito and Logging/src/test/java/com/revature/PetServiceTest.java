package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.*;
import org.mockito.*;

import com.revature.dao.PetDAO;
import com.revature.model.Pet;
import com.revature.service.*;

public class PetServiceTest {
    
    // 1. create an object from the service layer to use to test
    @InjectMocks
    private PetService petService = new PetServiceImpl();

    // 2. mock dependencies
        // mock: object double that takes the place of real object so
            // the initial functionality is NOT performed 
    @Mock        
    private PetDAO petDAOMock;

    // 3. inject mocks
    @BeforeEach
    public void setUpTests() {
        MockitoAnnotations.openMocks(this); // PetServiceTest.class
    }


    // public Pet getPetById(int id)
    @Test
    public void test_getPetById_success() {
        // setup
        Pet pet = new Pet(1, "Dobby", 3, "Dog", 1);
        // stub method
        when(petDAOMock.getPetById(1)).thenReturn(pet);

        // call the method we are testing
        Pet petReturned = petService.getPetById(1);

        // assertion
        assertEquals(pet, petReturned);
    }

    @Test
    public void test_getAllPetsByVetId_no_matches() {
        // set up
        ArrayList<Pet> testList = new ArrayList<>();
        Collections.addAll(testList, new Pet(1, "Candy", 1, "Dog", 1),
                                    new Pet(2, "Torchy", 3, "Cat", 2),
                                    new Pet(3, "Egg", 8, "Bird", 3),
                                    new Pet(4, "Whiskers", 3, "Cat", 2),
                                    new Pet(5, "Joe", 10, "Dog", 1));
                                    
        // stub
        when(petDAOMock.getAllPets()).thenReturn(testList);

        // returns only pets with given id
        ArrayList<Pet> listReturned = petService.getAllPetsByVetId(4);
        
        // returns no pets if no matches
        assertTrue(listReturned.size() == 0);
    }

    @Test
    public void test_getAllPetsByVetId_matches_found() {
    // set up
    ArrayList<Pet> testList = new ArrayList<>();
    Collections.addAll(testList, new Pet(1, "Candy", 1, "Dog", 1),
                                new Pet(2, "Torchy", 3, "Cat", 2),
                                new Pet(3, "Egg", 8, "Bird", 3),
                                new Pet(4, "Whiskers", 3, "Cat", 2),
                                new Pet(5, "Joe", 10, "Dog", 1));
                                
    // stub
    when(petDAOMock.getAllPets()).thenReturn(testList);

    // returns only pets with given id
    ArrayList<Pet> listReturned = petService.getAllPetsByVetId(2);

    // returns no pets if no matches
    assertTrue(listReturned.size() == 2);
    }

    @Test
    public void test_getAllPetsByVetId_calls_getAllPets_once() {
        // set up
        ArrayList<Pet> testList = new ArrayList<>();
                                            
        // stub
        when(petDAOMock.getAllPets()).thenReturn(testList);

        // just call it
        petService.getAllPetsByVetId(4);
        
        // returns no pets if no matches
        // https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#verification
        verify(petDAOMock, times(1)).getAllPets();
    }
}
