package com.gok.waybill.waybillservice.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    private DBFileRepository dbFileRepository;

    @Autowired
    public DBFileStorageService(DBFileRepository dbFileRepository) {
        this.dbFileRepository = dbFileRepository;
    }

    public DatabaseFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename() + "");

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new IllegalStateException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile databaseFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
            return dbFileRepository.save(databaseFile);
        } catch (IOException ex) {
            throw new IllegalStateException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DatabaseFile getFile(Integer fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new IllegalStateException("File not found with id " + fileId));
    }
}