package com.adl.hellospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.hellospring.model.Profile;
import com.adl.hellospring.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
	public List<Resume> findByTipe(String tipe);
}
