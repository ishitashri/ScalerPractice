package com.springboot.rest.service.notes.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rest.service.notes.entity.NoteVO;
import com.springboot.rest.service.notes.repository.NoteRepository;
import com.springboot.rest.service.notes.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;

	@Override
	public NoteVO addNote(NoteVO noteVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
