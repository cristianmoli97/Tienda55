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

import com.tiendaMinTic.DAO.ProductosDAO;
import com.tiendaMinTic.DTO.ProductosVO;


@Service
public class ServicioUploadCSV {

  ProductosDAO productosDAO = new ProductosDAO();
  
  public static boolean hasCSVFormat(MultipartFile file) {
	  
	String TYPE = "application/vnd.ms-excel";
	  
    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }
  

  public void save(MultipartFile file) {
    try {
      //Crea lista de productos desde csv	
      List<ProductosVO> listaproductos = csvToProductos(file.getInputStream());
      
      //cargo a DB
      for(ProductosVO prodVo: listaproductos) {
    	  productosDAO.registrarProducto(prodVo);
      }
      
    } catch (IOException e) {
      throw new RuntimeException("falla carga csv: " + e.getMessage());
    }
  }

  public List<ProductosVO> getAllProducts() {
    return productosDAO.listarProductos();
  }
  
  

  public static List<ProductosVO> csvToProductos(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
    		
		CSVParser csvParser = new CSVParser(fileReader,CSVFormat.RFC4180.withFirstRecordAsHeader());
    		) {
    	

      List<ProductosVO> listaProductos = new ArrayList<ProductosVO>();

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

