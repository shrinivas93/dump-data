package com.shri.dumpdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.dumpdata.document.Data;
import com.shri.dumpdata.repository.DataRepository;
import com.shri.dumpdata.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataRepository dataRepository;

	@Override
	public Data addData(Data data) {
		return dataRepository.save(data);
	}

}
