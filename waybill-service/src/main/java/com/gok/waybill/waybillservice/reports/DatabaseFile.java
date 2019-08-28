package com.gok.waybill.waybillservice.reports;


import com.gok.waybill.waybillservice.data.model.Model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@Table(name = "files")
public class DatabaseFile extends Model {

    @Column(name = "fileName")
    private String fileName;
    @Column(name = "fileType")
    private String fileType;

    @Lob
    private byte[] data;

    public DatabaseFile() {

    }

    public DatabaseFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}