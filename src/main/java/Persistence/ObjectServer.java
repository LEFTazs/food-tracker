package Persistence;

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
    
    private final String driver, url, username, password, migrationFile;
    
    public ObjectServer(String driver, String url, 
            String username, String password, String migrationFile) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.migrationFile = migrationFile;
    }

    public void updateSchema() {
        try (Connection connection = DriverManager.getConnection(
                url,
                username,
                password)) {
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(
                            new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase(migrationFile, 
                    new FileSystemResourceAccessor(), 
                    database);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException | SQLException e) {
            log.error(e.getLocalizedMessage());
        }
    }
    
    public void initialize() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver(driver);
        dsc.setUrl(url);
        dsc.setUsername(username);
        dsc.setPassword(password);
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
    
    abstract public void delete(T bean);
    
}
