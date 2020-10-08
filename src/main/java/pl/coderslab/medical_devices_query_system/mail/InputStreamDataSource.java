package pl.coderslab.medical_devices_query_system.mail;



import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;

import javax.activation.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Getter
@Setter
public class InputStreamDataSource implements DataSource {

    String contentType;
    String name;

    byte[] fileData;

    public InputStreamDataSource(String contentType, String name, InputStream inputStream) throws IOException {

        this.contentType = contentType;
        this.name = name;
        fileData = IOUtils.toByteArray(inputStream);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileData);
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
