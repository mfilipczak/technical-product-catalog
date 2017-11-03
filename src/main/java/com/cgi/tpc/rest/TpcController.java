package com.cgi.tpc.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.tpc.model.CfsDef;
import com.cgi.tpc.model.RfsDef;
import com.cgi.tpc.repository.RfsDefRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TpcController {

	@Autowired
	private RfsDefRepository rfsDefRepository;

	@RequestMapping(value = "/rfs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json,application/xml")
	public @ResponseBody RfsDef[] setCurrentDataList(@RequestBody List<CfsDef> cfsList) {
		List<String> ids = cfsList.stream().map(c -> c.getCfsId()).collect(Collectors.toList());
		return rfsDefRepository.findByCfsCfsIdIn(ids).toArray(new RfsDef[] {});
	}
}
