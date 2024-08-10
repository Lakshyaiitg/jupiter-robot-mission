package org.maxhomes.ai.jupitermission.responses;

public class TestResponse implements Response {
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "test response!";
	}

}
