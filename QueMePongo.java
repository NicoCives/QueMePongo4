public class Atuendo {
  List<Prenda> prendas;

  boolean temperaturaAdecuada(double clima){
      prendas.all(prenda->prenda.podesUsarPrenda(clima));
  };
}

public class Guardarropa {
  List<Atuendo> sugerenciasAtuendos;
  ServicioMeteorologico servicioMeteorologico;

  List<Atuendo> atuendosAdecuados(String ciudad){
      sugerenciasAtuendos.filter(atuendo->atuendo.temperaturaAdecuada(servicioMeteorologico.obtenerClima(ciudad)));

  };

}


public interface ServicioMeteorologico {
    double obtenerClima(String ciudad);
}

public class SercivioMeteorologicoAccu implements AccuWeatherAPI{
    AccuWeatherAPI accuWeather;
    Map<Ciudad, int> ultimosResultados;
    LocalDateTime fechaExpiracion;

    double obtenerClima(String ciudad){
        return ultimosResultados.getValue(ciudad);
    };
    void actualizarUltimosResultados(){
        if(fechaExpiracion >= LocalDateTime.now()){
            List<Map<String, Object>> resultadosTempsCiudades;
            resultadosTempsCiudades = getWeather(ciudad);
            //Se transformas los datos de resultadosTempsCiudades con algo que el dominio entienda, en este caso ultimos resultados...
        }
    };
}

public interface AccuWeatherAPI{
    List<Map<String, Object>> getWeather(String city);
}

public class Prenda {
  TipoPrenda tipo;
  Material material;
  Color colorPrincipal;
  Color colorSecundario;
  Trama trama = Trama.LISA;
  int temperaturaMaxima;

  public Prenda(TipoPrenda tipo, Categoria categoria, Material material, Trama trama, Color colorPrincipal, int temperaturaMaxima) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
  }

  public Prenda(TipoPrenda tipo, Categoria categoria, Material material, Trama trama, Color colorPrincipal, Color colorSecundario, int temperaturaMaxima) {  
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public Categoria getCategoria() {
    return this.tipo.getCategoria();
  }

  boolean podesUsarPrenda(double clima){
      return this.temperaturaMaxima > clima;
  }
}

