package com.gok.waybill.waybillservice.reports;

import com.gok.waybill.waybillservice.data.model.files.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DatabaseFile, Integer> {
}
