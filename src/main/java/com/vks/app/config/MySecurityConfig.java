package com.vks.app.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySecurityConfig {

	  @Bean
	    public ServletWebServerFactory servletContainer() {
	        // Enabling SSL traffic
	        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory() {
	            @Override
	            protected void postProcessContext(Context context) {
	                SecurityConstraint securityConstraint = new SecurityConstraint();
	                securityConstraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection securityCollection = new SecurityCollection();
	                securityCollection.addPattern("/*");
	                securityConstraint.addCollection(securityCollection);
	                context.addConstraint(securityConstraint);
	            }
	        };

	        // Adding HTTP to HTTPS redirect
	        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());

	        return tomcatServletWebServerFactory;
	    }

	    /*
	     If any request comes with port 8080 needs to be redirected to HTTPS on 8443.
	     */
	    private Connector httpToHttpsRedirectConnector() {
	        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	        connector.setScheme("http");
	        connector.setPort(8080);
	        connector.setSecure(false);
	        connector.setRedirectPort(8443);
	        return connector;
	    }
}
