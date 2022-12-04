package com.example.taskspringdatevacancy.service;

import com.example.taskspringdatevacancy.entity.Vacancy;

import java.util.List;

public interface VacancyService {
    List<Vacancy> getAllVacancy();

    Vacancy saveVacancy(Vacancy vacancy);

    Vacancy getVacancy(Integer id);

    void deleteVacancy(Integer id);
}
