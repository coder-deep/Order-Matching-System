package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.beans.Instrument;
import com.oms.repo.InstrumentRepo;

@Service
public class InstrumentService implements IInstrumentService {
	@Autowired
	InstrumentRepo irep;
	@Override
	public Instrument findById(String instrument_id)
	{
		Optional<Instrument> c = irep.findById(instrument_id);
		return c.get();
	}
}
