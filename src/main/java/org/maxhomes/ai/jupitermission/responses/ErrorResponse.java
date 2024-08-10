package org.maxhomes.ai.jupitermission.responses;

public class ErrorResponse implements Response {

	private String error;

	@Override
	public String getError() {
		return error;
	}

	@Override
	public void setError(String error) {
		this.error = error;
	}

}
