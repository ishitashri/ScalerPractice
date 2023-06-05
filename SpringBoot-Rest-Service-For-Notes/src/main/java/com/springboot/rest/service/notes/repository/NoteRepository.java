package com.springboot.rest.service.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.service.notes.entity.NoteVO;

@Repository
public interface NoteRepository extends JpaRepository<NoteVO, Long> {

}
