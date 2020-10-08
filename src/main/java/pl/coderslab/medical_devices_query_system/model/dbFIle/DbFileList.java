package pl.coderslab.medical_devices_query_system.model.dbFIle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DbFileList {
    private final List<DbFile> dbFilesList;

    public DbFileList(){
        dbFilesList = new ArrayList<>();
    }

    public void addToFileList(DbFile dbFile){
        dbFilesList.add(dbFile);
    }


}
