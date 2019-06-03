
import java.io.*;

public class CloningHandler {

    public static Object cloneObject(Object object) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream outputByteArrayStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputByteArrayStream);
        objectOutputStream.writeObject(object);

        ByteArrayInputStream inputByteArrayStream = new ByteArrayInputStream(outputByteArrayStream.toByteArray());
        ObjectInputStream objectIO = new ObjectInputStream(inputByteArrayStream);
        return objectIO.readObject();
    }
}
