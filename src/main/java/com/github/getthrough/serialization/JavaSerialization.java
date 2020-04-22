package com.github.getthrough.serialization;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author getthrough
 * @date 2020/3/12
 */
@Slf4j
public class JavaSerialization {

    public <T> void serialize(T obj, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.canWrite())
            throw new IOException("file is not allowed to write with file path : " + filePath);

        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(obj);
        } catch (IOException e) {
            log.error("write object failed, exception : {}", e);
        }
    }

    public <E> E deserialize(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException("file not found in path : " + filePath);

        try (
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Object object = ois.readObject();
            E element = (E) object;
            return element;
        } catch (IOException | ClassNotFoundException e) {
            log.error("read object failed, exception : {}", e);
            return null;
        }
    }

}
