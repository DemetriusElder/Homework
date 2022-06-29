package backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Models.Champion;
import backend.Repo.ChampRepo;
import backend.Exceptions.EntryNotFoundException;
import backend.Models.Champion;

@Service
public class ChampServ {
	
	@Autowired
	private ChampRepo champRepo;
	
	public void addChampion(Champion champDto) {
		Champion newChamp = new Champion();
		newChamp.setCounter(champDto.getCounter());
		newChamp.setName(champDto.getName());
		newChamp.setWinrate(champDto.getWinrate());
		newChamp.setPickrate(champDto.getPickrate());
		newChamp.setPicture(champDto.getPicture());
		newChamp.setRole(champDto.getRole());
		newChamp.setLane(champDto.getLane());
		champRepo.save(newChamp);
	}
	
	public Champion getById(Long id)throws EntryNotFoundException{
		System.out.println(id);
		if (!champRepo.existsById(id)) {
			throw new EntryNotFoundException();
		}
		return champRepo.getById(id);
	}
	public Champion getByName(String name)throws EntryNotFoundException{
		System.out.println(name);
		if (!champRepo.existsByName(name)) {
			throw new EntryNotFoundException();
		}
		return champRepo.getByName(name);
	}
	
	public void deleteById(Long id) throws EntryNotFoundException{
		if (!champRepo.existsById(id)) {
			throw new EntryNotFoundException();
		}
		champRepo.deleteById(id);
	}
	
	public List<Champion> getAll() {
		return champRepo.findAll();
	}
	
	public List<Champion> getFilteredChampion(String searchKey){
    	return champRepo.getFilteredChampion(searchKey);
    }

}
