package response;

public interface Response {
	@Override
	public String toString();

	public String getError();

	public void setError(String error);
}
