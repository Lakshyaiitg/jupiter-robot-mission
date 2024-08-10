package org.maxhomes.ai.jupitermission.requests;

import org.maxhomes.ai.jupitermission.responses.Response;

public interface Request {
	
	public Response process() throws Exception;

}
