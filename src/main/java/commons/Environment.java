package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${environment}.properties"})
public interface Environment extends Config {
	String url(); 
	
	@Key("db.hostname")
	String dbHostName();
	
	@Key("db.username")
	String dbUserName();
	
	@Key("db.password")
	String dbPassword();
	
}
