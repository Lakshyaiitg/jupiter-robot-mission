package request;

import response.Response;
import response.TestResponse;

public class TestRequest implements Request {
	TestResponse response = new TestResponse();

	@Override
	public Response process() {

		return response;
	}

}
