package com.example.taskspringdatevacancy.repository;

import com.example.taskspringdatevacancy.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
}
