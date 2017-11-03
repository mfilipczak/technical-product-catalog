package com.cgi.tpc;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cgi.tpc.model.CfsDef;
import com.cgi.tpc.model.RfsDef;
import com.cgi.tpc.repository.CfsDefRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private CfsDefRepository cfsDefRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
        	CfsDef cfs1 = new CfsDef();
        	cfs1.setCfsId("1234");
        	cfs1.setName("poczta glosowa");
        	RfsDef rfs1= new RfsDef();
        	rfs1.setRfsId("123");
        	rfs1.setName("billing");
        	RfsDef rfs2= new RfsDef();
        	rfs2.setRfsId("1234");
        	rfs2.setName("IL");
        	rfs2.getBlockedRfs().add(rfs1);
        	List<RfsDef> rfs = new ArrayList<>();
        	rfs.add(rfs1);
        	rfs.add(rfs2);
        	cfs1.setRfs(rfs);
        	
        	cfsDefRepository.save(cfs1);
        	
        	CfsDef cfs2 = new CfsDef();
        	cfs2.setCfsId("123");
        	cfs2.setName("poczta glosowa");
        	RfsDef rfs3= new RfsDef();
        	rfs3.setRfsId("12345");
        	rfs3.setName("billing");
        	
        	rfs = new ArrayList<>();

        	rfs.add(rfs3);
        	cfs2.setRfs(rfs);
        	
        	cfsDefRepository.save(cfs2);
          };
       }
}
