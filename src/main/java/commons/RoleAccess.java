package commons;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${role}Role.properties"})
public interface RoleAccess extends Config {
    String url();
}
