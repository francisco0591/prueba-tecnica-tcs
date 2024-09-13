package com.tipocambio.api.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tipocambio.api.dto.TipoCambioDTO;

@FeignClient(name="tipocambio", url="https://open.er-api.com/v6/latest")
public interface TipoCambioClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{monedaOrigen}", consumes = "application/json")
	TipoCambioDTO getAll(@PathVariable String monedaOrigen);
}
