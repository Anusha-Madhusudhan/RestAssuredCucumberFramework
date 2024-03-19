package wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockServerImple {
	private static final String HOST="localhost";
	private static final int PORT=9090;
	private static final String END_PoINT="/rentalcars";
	private static WireMockServer server=new WireMockServer(PORT);
	
	public static void startServer() {
		
		server.start();
		WireMock.configureFor(HOST, PORT);
		
		ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		mockResponse.withBodyFile("cars.json");
		
		
		
		ResponseDefinitionBuilder mockResponse2=new ResponseDefinitionBuilder();
		mockResponse2.withStatus(201);
		mockResponse2.withStatusMessage("SuccussFully created new car object");
		
		
		
		WireMock.stubFor(WireMock.get(END_PoINT).willReturn(mockResponse));
		WireMock.stubFor(WireMock.post(END_PoINT).willReturn(mockResponse2));
		
	}
	
	
	public static void stopServer() {
		if(server.isRunning()&& server!=null) {
			server.shutdown();
		}
	}
	
	

}
