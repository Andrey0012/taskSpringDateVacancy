package com.example.taskspringdatevacancy;

import com.example.taskspringdatevacancy.entity.Vacancy;
import com.example.taskspringdatevacancy.repository.VacancyRepository;
import com.example.taskspringdatevacancy.service.VacancyService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VacancyServiceTest {

    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private VacancyService vacancyService;

    @MockBean
    EntityManager entityManager;
    @AfterEach
    public void deleteAllElement() {
        Query query = entityManager.createQuery("delete from Vacancy");
        query.executeUpdate();
    }

    @Test
    public void saveVacancyTest() {
     //given
        Vacancy vacancy = Vacancy.builder()
                .name("dfg")
                .salary(55)
                .workExperience("dfvb")
                .city("zdf")
                .build();

        //when
        vacancyService.saveVacancy(vacancy);

        //then
        Optional<Vacancy> byId = vacancyRepository.findById(vacancy.getId());
        assertTrue(byId.isPresent());
        assertEquals(vacancy.getName(), byId.get().getName());
        assertEquals(vacancy.getWorkExperience(), byId.get().getWorkExperience());
        assertEquals(vacancy.getSalary(), byId.get().getSalary());
        assertEquals(vacancy.getCity(), byId.get().getCity());
    }

    @Test
    public void getVacancyTest() {
        //given
        Vacancy vacancy = Vacancy.builder()
                .name("dfg")
                .salary(55)
                .workExperience("dfvb")
                .city("zdf")
                .build();
        vacancyRepository.save(vacancy);

        //when
        Vacancy byId = vacancyService.getVacancy(vacancy.getId());

        //then
        assertNotNull(byId);
    }

    @Test
    public void deleteVacancyTest() {
        //given
        Vacancy vacancy = Vacancy.builder()
                .name("dfg")
                .salary(55)
                .workExperience("dfvb")
                .city("zdf")
                .build();
        vacancyService.saveVacancy(vacancy);

        //when
        vacancyService.deleteVacancy(vacancy.getId());

        //then
        Optional<Vacancy> byId = vacancyRepository.findById(vacancy.getId());
        assertTrue(byId.isEmpty());

    }
    @Test
    public void getAllVacancyTest() {
        //given
        Vacancy vacancy = Vacancy.builder()
                .name("dfg")
                .salary(55)
                .workExperience("dfvb")
                .city("zdf")
                .build();
        Vacancy vacancy1 = Vacancy.builder()
                .name("dfg")
                .salary(55)
                .workExperience("dfvb")
                .city("zdf")
                .build();
        vacancyRepository.save(vacancy);
        vacancyRepository.save(vacancy1);

        //when
        List<Vacancy> byId = vacancyService.getAllVacancy();

        //then
        assertEquals(2, byId.size());
    }
}
