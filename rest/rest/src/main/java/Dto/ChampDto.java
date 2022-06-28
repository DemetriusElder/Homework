package Dto;

public class ChampDto {
	
	private final String role;

	private final long winrate;
	
	private final long pickrate;

	private final String name;
	
	private final String counter;

	private final String picture;
	
	private final String lane;

	public ChampDto(String role, long winrate, long pickrate, String name, String counter, String picture,
			String lane) {
		super();
		this.role = role;
		this.winrate = winrate;
		this.pickrate = pickrate;
		this.name = name;
		this.counter = counter;
		this.picture = picture;
		this.lane = lane;
	}

	public String getRole() {
		return role;
	}

	public long getWinrate() {
		return winrate;
	}

	public long getPickrate() {
		return pickrate;
	}

	public String getName() {
		return name;
	}

	public String getCounter() {
		return counter;
	}

	public String getPicture() {
		return picture;
	}

	public String getLane() {
		return lane;
	}

}
