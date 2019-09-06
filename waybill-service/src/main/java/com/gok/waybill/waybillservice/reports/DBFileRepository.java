package com.gok.waybill.waybillservice.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DatabaseFile, Integer> {
}
