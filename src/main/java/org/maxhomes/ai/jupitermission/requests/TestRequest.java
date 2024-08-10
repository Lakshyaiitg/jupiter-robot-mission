package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.responses.Response;
import org.maxhomes.ai.jupitermission.responses.TestResponse;

public class TestRequest implements Request {
	TestResponse response = new TestResponse();

	@Override
	public Response process() {

		return response;
	}

}
