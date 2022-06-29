package backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Models.Url;
import backend.Repo.UrlRepo;
import backend.Exceptions.EntryNotFoundException;

@Service
public class UrlServ {
	
	private final UrlRepo urlRepo;
	
	@Autowired
    public UrlServ(UrlRepo urlRepo) {
		this.urlRepo = urlRepo;
    }
	public void addUrl(Url url) throws EntryNotFoundException{
		if (!urlRepo.existsByrealurl(url.getRealurl())) {
            throw new EntryNotFoundException();
        }else {
		Url newUrl = new Url();
		newUrl.setRealurl(url.getRealurl());
		newUrl.setTinyurl(url.getTinyurl());
		urlRepo.save(newUrl);
		}
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
    public Url getByRealUrl(String realurl) throws EntryNotFoundException {
        if (!urlRepo.existsByrealurl(realurl)) {
            throw new EntryNotFoundException();
        }
        return urlRepo.findByrealurl(realurl).orElseThrow(() -> new EntryNotFoundException());
    }
    public List<Url> getFilteredUrl(String searchKey){
    	return urlRepo.getFilteredUrl(searchKey);
    }

}
