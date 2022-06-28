package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.rest.Models.Champion;
import com.test.app.rest.Repo.ChampRepo;

import Dto.ChampDto;
import Exceptions.EntryNotFoundException;

@Service
public class ChampServ {
	
	@Autowired
	private ChampRepo champRepo;
	
	public void addChampion(ChampDto champDto) {
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
		if (!champRepo.existsById(id)) {
			throw new EntryNotFoundException();
		}
		return champRepo.getById(id);
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
