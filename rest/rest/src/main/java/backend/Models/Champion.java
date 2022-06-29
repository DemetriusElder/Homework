package backend.Models;
import javax.persistence.*;

@Entity
public class Champion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String role;

	@Column
	private long winrate;
	
	@Column
	private long pickrate;

	@Column
	private String name;
	
	@Column
	private String counter;

	@Column
	private String picture;
	
	@Column
	private String lane;

	public Champion() {
		
	}

	public Champion(int id, String role, long winrate, long pickrate, String name, String counter, String picture,
			String lane) {
		super();
		this.id = id;
		this.role = role;
		this.winrate = winrate;
		this.pickrate = pickrate;
		this.name = name;
		this.counter = counter;
		this.picture = picture;
		this.lane = lane;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getWinrate() {
		return winrate;
	}

	public void setWinrate(long winrate) {
		this.winrate = winrate;
	}

	public long getPickrate() {
		return pickrate;
	}

	public void setPickrate(long pickrate) {
		this.pickrate = pickrate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

}
