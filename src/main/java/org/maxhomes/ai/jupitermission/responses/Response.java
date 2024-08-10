package org.maxhomes.ai.jupitermission.responses;

public interface Response {
	@Override
	public String toString();

	public String getError();

	public void setError(String error);
}
