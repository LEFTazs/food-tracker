package Persistence;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.datasource.DataSourceConfig;

public abstract class ObjectServer<T> {
    
    protected EbeanServer ebeanServer;

    public void initialize() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:9001/foodtracker");
        dsc.setUsername("foodtracker");
        dsc.setPassword("84VgKg472f2gH47Hdvn3hZ3");
        ServerConfig cfg = new ServerConfig();
        cfg.setName("foodtracker");
        cfg.setDdlGenerate(true);
        cfg.setDdlRun(true);
        cfg.setRegister(true);
        cfg.setDataSourceConfig(dsc);
        cfg.setDefaultServer(true);
        ebeanServer = EbeanServerFactory.create(cfg);
    }
    
    abstract public void save(T bean);
    
    abstract public T get(int id);
    
    abstract public void delete(T bean);
    
}
