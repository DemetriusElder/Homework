package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.rest.Models.Url;
import com.test.app.rest.Repo.UrlRepo;

import Dto.UrlDto;
import Exceptions.EntryNotFoundException;

@Service
public class UrlServ {
	
	private final UrlRepo urlRepo;
	
	@Autowired
    public UrlServ(UrlRepo urlRepo) {
		this.urlRepo = urlRepo;
    }
	public void addUrl(UrlDto urlDto){
		Url newUrl = new Url();
		newUrl.setRealurl(urlDto.getRealUrl());
		newUrl.setTinyurl(urlDto.getTinyUrl());
		urlRepo.save(newUrl);
    }
	public Url getById(Long id) throws EntryNotFoundException {
        if (!urlRepo.existsById(id)) {
            throw new EntryNotFoundException();
        }
        return urlRepo.getById(id);
    }
    public void deleteById(Long id) throws EntryNotFoundException{
    	if (!urlRepo.existsById(id)) {
            throw new EntryNotFoundException();
        }
    	urlRepo.deleteById(id);
    }
    public List<Url> getAll() {
        return urlRepo.findAll();
    }
    public Url getByRealUrl(String realUrl) throws EntryNotFoundException {
        if (!urlRepo.existsByRealUrl(realUrl)) {
            throw new EntryNotFoundException();
        }
        return urlRepo.findByRealUrl(realUrl).orElseThrow(() -> new EntryNotFoundException());
    }
    public List<Url> getFilteredUrl(String searchKey){
    	return urlRepo.getFilteredUrl(searchKey);
    }

}
