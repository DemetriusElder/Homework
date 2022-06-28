package com.test.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.rest.Models.Champion;

import Exceptions.EntryNotFoundException;
import Dto.ChampDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import Service.ChampServ;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("champion")
public class ChampControl {
	
	@Autowired
	private ChampServ champService;
	
	@GetMapping()
	public List<Champion> getChampion(){
		return champService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void postChampions(@RequestBody ChampDto champDto) {
		champService.addChampion(champDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Champion> getChampionsById(@PathVariable("id")Long id)throws EntryNotFoundException{
		Champion newChamp = champService.getById(id);
		return new ResponseEntity<>(newChamp, HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchKey}")
	public List<Champion> getFilteredList(@PathVariable("searchKey") String key){
		return champService.getFilteredChampion(key);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteChampion(@PathVariable("id") Long id)throws EntryNotFoundException{
		champService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
