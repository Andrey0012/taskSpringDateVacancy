package com.example.taskspringdatevacancy.controller;

import com.example.taskspringdatevacancy.entity.Vacancy;
import com.example.taskspringdatevacancy.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VacancyController {

    private final VacancyService vacancyService;

    //создание новой вакансии
    @PutMapping(value = "/vacancy", consumes = MediaType.APPLICATION_XML_VALUE)
    public Vacancy addNewVacancy(@RequestBody Vacancy vacancy) {
        vacancyService.saveVacancy(vacancy);
        return vacancy;
    }

    //Список вакансий отсортированных по наименованию
    @GetMapping(value = "/vacancy", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Vacancy> showAllEmployee() {
        return vacancyService.getAllVacancy();
    }

    //Вакансия с ID {id}
    @GetMapping(value = "/vacancy/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Vacancy getVacancy(@PathVariable int id) {
        return vacancyService.getVacancy(id);
    }

    //удаление вакансии с ID {id}
    @DeleteMapping("/vacancy/{id}")
    public void deleteVacancy(@PathVariable int id) {
        vacancyService.deleteVacancy(id);
    }
}

