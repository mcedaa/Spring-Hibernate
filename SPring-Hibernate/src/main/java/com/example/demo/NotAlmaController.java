package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.NoteService;


@Controller
public class NotAlmaController {
	
	@Autowired
	private NoteService noteService;


	@RequestMapping("/")

	public String homee(Model model) {
		
		//model.addAttribute("baslik", "Not Alma");
		model.addAttribute("notlar", noteService.getAll(1l));
		
		
		
		System.err.println("notkar :  " + noteService.getAll(1l).size() );
		
		return "index";
	}
	
	/*
	@Transactional

	@GetMapping("/detay")
	public String detay(Model model) {
		Note note = new Note();
		note.setTitle("Merhaba");
		note.setContent("Nasilsiniz");
		//note.setUser_id(1l);
		
		noteService.createNote(note,null);
		

		return "detail";
	}
	*/
	@GetMapping("/detay/{id}" )
	public String detay(@PathVariable("id")Long id,Model model) {
		

		return "detail";
	}
	@GetMapping("/ekle" )
	public String ekle(Model model) {
		

		return "addNote";
	}
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	// notu arkadan öne yollamak için POST kullandık
	public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request) {
		
	
		System.out.println(note.toString()); // not detaylarını görebilmek için
		//request.setAttribute("mode", MODE_REGISTER);
		noteService.createNote(note, request);
		
		return new ResponseEntity<>("OK", HttpStatus.CREATED);

	}
	@RequestMapping(value = "/getNotes", method = RequestMethod.POST)
	
	public ResponseEntity<ArrayList<Note>> getNotes(HttpServletRequest request) {

		return new ResponseEntity<>(noteService.getAll(1l), HttpStatus.CREATED);

	}
	



}
