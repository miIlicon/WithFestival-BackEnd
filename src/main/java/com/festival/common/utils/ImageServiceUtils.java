package com.festival.common.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceUtils {

    public ImageServiceUtils() {
    }

    public String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    public List<String> saveSubImages(String filePath, List<MultipartFile> subFiles) throws IOException {

        List<String> subFilePaths = new ArrayList<>();

        for (MultipartFile subFile : subFiles) {
            if (!subFile.isEmpty()) {
                String savePath = createStoreFileName(subFile.getOriginalFilename());
                subFilePaths.add(savePath);
                subFile.transferTo(new File(filePath + savePath));
            }
        }
        return subFilePaths;
    }
}