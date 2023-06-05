package com.springboot.rest.service.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.service.notes.entity.NoteVO;
import com.springboot.rest.service.notes.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@PostMapping
	public ResponseEntity<NoteVO> addOrSaveNotes(NoteVO noteVO){
		return new ResponseEntity<NoteVO>(noteService.addNote(noteVO), HttpStatus.OK);
	}
}
