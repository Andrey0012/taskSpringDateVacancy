package com.example.taskspringdatevacancy.service;

import com.example.taskspringdatevacancy.entity.Vacancy;
import com.example.taskspringdatevacancy.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImp implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public List<Vacancy> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy saveVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy getVacancy(Integer id) {
        return vacancyRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("там нет ничего");
        });
    }

    @Override
    public void deleteVacancy(Integer id) {
        vacancyRepository.deleteById(id);
    }
}
