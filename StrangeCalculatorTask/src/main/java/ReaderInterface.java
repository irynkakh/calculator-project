import java.io.IOException;

public interface ReaderInterface {
    public Boolean hasNext() throws IOException;

    public Formula readNext() throws IOException;
}
