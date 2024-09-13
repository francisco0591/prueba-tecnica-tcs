package com.tipocambio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tipocambio.api.entities.TipoCambio;


@Repository
public interface  TipoCambioRepository  extends JpaRepository<TipoCambio, Integer>{
	
	@Query ("select u from TipoCambio u where u.moneda_origen=?1 and u.moneda_destino=?2")
	TipoCambio findByTipoCambio(String monedaOrigen,String monedaDestino);
}
