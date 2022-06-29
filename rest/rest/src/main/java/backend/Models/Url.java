package backend.Models;
import javax.persistence.*;

@Entity
public class Url {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String realurl;
	
	@Column
	private String tinyurl;

	public Url() {
		
	}
	public Url(long id, String realurl, String tinyurl) {
		super();
		this.id = id;
		this.realurl = realurl;
		this.tinyurl = tinyurl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRealurl() {
		return realurl;
	}

	public void setRealurl(String realurl) {
		this.realurl = realurl;
	}

	public String getTinyurl() {
		return tinyurl;
	}

	public void setTinyurl(String tinyurl) {
		this.tinyurl = tinyurl;
	}
}