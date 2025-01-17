package com.tiendaMinTic.CSV.Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDto.ProductosVO;


@Service
public class ServicioUploadCSV {

  ProductosDAO productosDAO = new ProductosDAO();
  
  public boolean save(MultipartFile file) {
	  boolean subida = false;
    try {
      //Crea lista de productos desde csv	
      List<ProductosVO> listaproductos = csvToProductos(file.getInputStream());
      
      //cargo a DB
      for(ProductosVO prodVo: listaproductos) {
    	  try {
    		  productosDAO.registrarProducto(prodVo);

    	  }catch (Exception e) {
    		  throw new RuntimeException("aquiiiiiiiiiiiiii: " + e.getMessage());
    	  }
    	 }
      
      
      subida = true;
      

      
    } catch (IOException e) {
      throw new RuntimeException("falla carga csv: " + e.getMessage());
    }
    
    return subida;
  }
  

  public List<ProductosVO> getAllProducts() {
    return productosDAO.listarProductos();
  }
  
  

  public static List<ProductosVO> csvToProductos(InputStream is) {
	  List<ProductosVO> listaProductos = new ArrayList<ProductosVO>();
	  
	  
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
    		
		CSVParser csvParser = new CSVParser(fileReader,CSVFormat.RFC4180.withFirstRecordAsHeader());
    		) {    

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
    
      for (CSVRecord csvRecord : csvRecords) {

    	  ProductosVO produItem = new ProductosVO(
              Long.valueOf(csvRecord.get("codigo_producto")),
              Double.parseDouble(csvRecord.get("ivacompra")),
              Long.valueOf(csvRecord.get("nitproveedor")),
              csvRecord.get("nombre_producto"),
              Double.parseDouble(csvRecord.get("precio_compra")),
              Double.parseDouble(csvRecord.get("precio_venta"))
            );

    	  listaProductos.add(produItem);
      }
      
      return listaProductos;
    } catch (IOException e) {
      throw new RuntimeException("Error al cargar el CSV : " + e.getMessage());
    }
  }
}

