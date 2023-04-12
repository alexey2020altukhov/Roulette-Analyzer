package com.ra.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveFile(String pathFromContentRoot, Object data) throws IOException {
        mapper.writeValue(new File(System.getProperty("user.dir").concat(pathFromContentRoot)), data);
    }

    public static File getFile(String pathFromContentRoot) {
        File file = new File(System.getProperty("user.dir").concat(pathFromContentRoot));
        if(file.exists()) {
            return file;
        } else {
            return null;
        }
    }
}