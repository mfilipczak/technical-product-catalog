package com.cgi.tpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.tpc.model.CfsDef;

public interface CfsDefRepository extends JpaRepository<CfsDef, Long> {
}