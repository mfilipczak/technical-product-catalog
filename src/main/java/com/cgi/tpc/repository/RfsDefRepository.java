package com.cgi.tpc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.tpc.model.CfsDef;
import com.cgi.tpc.model.RfsDef;

public interface RfsDefRepository extends JpaRepository<RfsDef, Long> {

    List<RfsDef> findByCfsCfsIdIn(List<String> cfsList);

}