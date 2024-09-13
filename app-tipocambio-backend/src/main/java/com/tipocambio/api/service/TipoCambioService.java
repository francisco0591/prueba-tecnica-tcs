package com.tipocambio.api.service;

import java.util.List;
import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;

public interface TipoCambioService {

	public TipoCambioDTO cambioTipoCambio(String monedaOrigen);
	
	public TipoCambio buscarTipoCambio(String monedaOrigen,String monedaDestino);
	
	public void guardarTipoCambio(TipoCambio tipoCambio);
	
	public List<TipoCambio> listarTipoCambio();
}
