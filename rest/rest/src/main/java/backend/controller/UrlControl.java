package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.Models.Champion;
import backend.Models.Url;

import backend.Exceptions.EntryNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import backend.Service.ChampServ;
import backend.Service.UrlServ;

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
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/post")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Url> postUrl(@RequestBody Url url) throws EntryNotFoundException {
		urlService.addUrl(url);
		System.out.println("Test");
		return new ResponseEntity<>(url, HttpStatus.OK);
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
