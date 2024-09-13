package com.tipocambio.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipocambio.api.client.TipoCambioClient;
import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;
import com.tipocambio.api.repository.TipoCambioRepository;
import com.tipocambio.api.service.TipoCambioService;

@Service
public class TiempoCambioServiceImpl implements TipoCambioService{

	@Autowired
	private TipoCambioClient tipoCambioClient;
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Override
	public TipoCambioDTO cambioTipoCambio(String monedaOrigen) {
		return tipoCambioClient.getAll(monedaOrigen);
	}

	@Override
	public TipoCambio buscarTipoCambio(String monedaOrigen, String monedaDestino) {
		return tipoCambioRepository.findByTipoCambio(monedaOrigen, monedaDestino);
	}

	@Override
	public void guardarTipoCambio(TipoCambio tipoCambio) {
	    tipoCambioRepository.save(tipoCambio);
	}

	@Override
	public List<TipoCambio> listarTipoCambio() {
		return tipoCambioRepository.findAll();
	}


}
