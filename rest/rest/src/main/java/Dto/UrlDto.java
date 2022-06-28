package Dto;

public class UrlDto {

	private final String realUrl;

	private final String tinyUrl;

	public UrlDto(String realUrl, String tinyUrl) {
		super();
		this.realUrl = realUrl;
		this.tinyUrl = tinyUrl;
	}

	public String getRealUrl() {
		return realUrl;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}
}
