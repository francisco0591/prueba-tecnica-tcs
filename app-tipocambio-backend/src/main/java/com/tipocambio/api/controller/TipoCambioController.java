package com.tipocambio.api.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;
import com.tipocambio.api.request.TipoCambioRequest;
import com.tipocambio.api.service.TipoCambioService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoCambioController {

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping("cambioTipoCambio/{monedaOrigen}")
	public ResponseEntity<TipoCambioDTO> getCambioTipoCambio(@PathVariable String monedaOrigen){
		return new ResponseEntity<>(tipoCambioService.cambioTipoCambio(monedaOrigen),HttpStatus.OK);
	}
	
	@GetMapping("/listarTipoCambio")
	public List<TipoCambio> listarTipoCambio() {
		List<TipoCambio> lstTipoCambio = new ArrayList<TipoCambio>();
		tipoCambioService.listarTipoCambio().forEach(tipocambio1 -> lstTipoCambio.add(tipocambio1));
		return lstTipoCambio;
	}
	
	@PostMapping("/saveTipoCambio")
	public TipoCambio saveTipoCambio(@RequestBody TipoCambioRequest request) {
		TipoCambio bean = new TipoCambio();
		try {
			TipoCambioDTO dto =  tipoCambioService.cambioTipoCambio(request.getMoneda_origen());
			if(dto!= null) {
				float monto_tipo_cambio = 0;
			     System.out.println("rates:"+dto.getRates());
			     Gson gson = new Gson();
			     ObjectMapper objectMapper = new ObjectMapper();
			     String objetoJson = objectMapper.writeValueAsString(dto.getRates());
			     JsonObject json = gson.fromJson(objetoJson, JsonObject.class);
			     // get attribute
			     String tipoCambioValor = json.get(request.getMoneda_destino()).getAsString();
			     System.out.println("tipoCambioValor:"+tipoCambioValor);
			     monto_tipo_cambio = request.getMonto() * Float.parseFloat(tipoCambioValor);
//			     System.out.println("monto_tipo_cambio:"+monto_tipo_cambio);
			    
			     	bean.setMonto(request.getMonto());
					bean.setMoneda_origen(request.getMoneda_origen());
					bean.setMoneda_destino(request.getMoneda_destino());
					bean.setTipo_cambio(Float.parseFloat(tipoCambioValor));
					bean.setMonto_tipo_cambio(monto_tipo_cambio);
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					String fechaComoCadena = sdf.format(new Date());
					 TipoCambio existe = tipoCambioService.buscarTipoCambio(request.getMoneda_origen(), request.getMoneda_destino());
	                 if(existe != null) {
//	    			     System.out.println("existe:"+existe.getId());
		    			     bean.setUsuario_creacion(existe.getUsuario_creacion());
		 				bean.setFecha_creacion(existe.getFecha_creacion());
	    			     bean.setUsuario_modificacion("admin");
	    			     bean.setFecha_modificacion(fechaComoCadena);
                         bean.setId(existe.getId());
	                 }else {
	 					bean.setUsuario_creacion("admin");
	 					bean.setFecha_creacion(fechaComoCadena);
	                 }
					 tipoCambioService.guardarTipoCambio(bean);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}
}
