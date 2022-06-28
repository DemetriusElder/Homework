package com.test.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.rest.Models.Champion;
import com.test.app.rest.Models.Url;

import Exceptions.EntryNotFoundException;
import Dto.ChampDto;
import Dto.UrlDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import Service.ChampServ;
import Service.UrlServ;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("url")
public class UrlControl{
	
	private final UrlServ urlService;
	
	@Autowired
	public UrlControl(UrlServ urlService) {
		this.urlService = urlService;
	}
	
	@GetMapping()
	public List<Url> getUrl(){
		return urlService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void postUrl(@RequestBody UrlDto urlDto) {
		urlService.addUrl(urlDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Url> getUrlById(@PathVariable("id")Long id)throws EntryNotFoundException{
		Url newUrl = urlService.getById(id);
		return new ResponseEntity<>(newUrl, HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchKey}")
	public List<Url> getFilteredList(@PathVariable("searchKey") String key){
		return urlService.getFilteredUrl(key);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Url> deleteUrl(@PathVariable("id")Long id)throws EntryNotFoundException{
		urlService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
