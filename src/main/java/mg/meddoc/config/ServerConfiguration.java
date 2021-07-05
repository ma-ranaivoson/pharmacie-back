package mg.meddoc.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {
	
	//	@Bean
	// public ServletWebServerFactory servletContainer() {
		//    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
        	//       @Override
            //     protected void postProcessContext(Context context) {
            	//               SecurityConstraint securityConstraint = new SecurityConstraint();
                //                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(getHttpConnector());
//        return tomcat;
//    }
//
//    private Connector getHttpConnector() {
//        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//        connector.setScheme("http");
//        connector.setPort(8080);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }

}
