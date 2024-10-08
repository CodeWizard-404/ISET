package TP_SOA.entities;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class jerseyConfig extends ResourceConfig{
	public jerseyConfig() {
		register(WebService.class);
	}
}
