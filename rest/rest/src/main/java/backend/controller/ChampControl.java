package backend.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.Models.Champion;

import backend.Exceptions.EntryNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import backend.Service.ChampServ;

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
	public void postChampions(@RequestBody Champion champDto) {
		champService.addChampion(champDto);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Champion> getChampionsByName(@PathVariable("name") String name)throws EntryNotFoundException{
		System.out.println(name);
		Champion newChamp = champService.getByName(name);
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
	
	@GetMapping("/compare/{one}/{two}")
	public Champion compareChampions(@PathVariable("one")String one,@PathVariable("two")String two) throws EntryNotFoundException{
		Champion first = champService.getByName(one);
		Champion second = champService.getByName(two);
		Champion winner = new Champion();
		if(first.getCounter() == second.getName())
		{
			if(first.getWinrate() + 5 > second.getWinrate())
			{
				winner = first;
			}else {
				winner = second;
			}
		}else if(second.getCounter() == first.getName()){
			if(second.getWinrate() + 5 > first.getWinrate())
			{
				winner = second;
			}else {
				winner = first;
			}
		}else {
			if(first.getWinrate() > second.getWinrate())
			{
				winner = first;
			}else {
				winner = second;
			}
		}
		return winner;
	}
	@GetMapping("/pagelist/{pagenumber}")
	public List<Champion> getPageList(@PathVariable("pagenumber")int pagenumber) {
		int pagesize = 5;
		int x = pagesize * (pagenumber -1);
		List<Champion> tempList = champService.getAll();
		tempList.sort(Comparator.comparing(Champion::getName).reversed());
		List<Champion> pageList = new ArrayList<Champion>(pagesize);
		for(int i = 0; i < pagesize; i++) {
			if(x < tempList.size()) {
				pageList.add(tempList.get(x));
				x++;
			}
		}
		return pageList;
	}
	
	@GetMapping("/winrate/{pagenumber}")
	public List<Champion> getWinRateList(@PathVariable("pagenumber")int pagenumber) {
		int pagesize = 5;
		int x = pagesize * (pagenumber -1);
		List<Champion> tempList = champService.getAll();
		tempList.sort(Comparator.comparing(Champion::getWinrate).reversed());
		List<Champion> pageList = new ArrayList<Champion>(pagesize);
		for(int i = 0; i < pagesize; i++) {
			if(x < tempList.size()) {
				pageList.add(tempList.get(x));
				x++;
			}
		}
		return pageList;
	}
	@GetMapping("/pickrate/{pagenumber}")
	public List<Champion> getPickRateList(@PathVariable("pagenumber")int pagenumber) {
		int pagesize = 5;
		int x = pagesize * (pagenumber -1);
		List<Champion> tempList = champService.getAll();
		tempList.sort(Comparator.comparing(Champion::getPickrate).reversed());
		List<Champion> pageList = new ArrayList<Champion>(pagesize);
		for(int i = 0; i < pagesize; i++) {
			if(x < tempList.size()) {
				pageList.add(tempList.get(x));
				x++;
			}
		}
		return pageList;
	}


}
