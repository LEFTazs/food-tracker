package Persistence;

import SpringInterface.ConfigProperties;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.datasource.DataSourceConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ObjectServer<T> {
    
    protected EbeanServer ebeanServer;
    
    private final ConfigProperties configProperties;
    
    public ObjectServer(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    public void updateSchema() {
        try (Connection connection = DriverManager.getConnection(
                configProperties.getUrl(),
                configProperties.getUsername(),
                configProperties.getPassword())) {
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(
                            new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase(configProperties.getMigrationFile(), 
                    new FileSystemResourceAccessor(), 
                    database);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException | SQLException e) {
            log.error(e.getLocalizedMessage());
        }
    }
    
    public void initialize() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver(configProperties.getDriver());
        dsc.setUrl(configProperties.getUrl());
        dsc.setUsername(configProperties.getUsername());
        dsc.setPassword(configProperties.getPassword());
        ServerConfig cfg = new ServerConfig();
        cfg.setName("foodtracker");
        cfg.setDdlGenerate(false);
        cfg.setDdlRun(false);
        cfg.setRegister(true);
        cfg.setDataSourceConfig(dsc);
        cfg.setDefaultServer(true);
        ebeanServer = EbeanServerFactory.create(cfg);
    }
    
    abstract public void save(T bean);
    
    abstract public T get(int id);
    
    abstract public boolean isEmpty();
    
    abstract public void delete(T bean);
    
}
