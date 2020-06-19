import java.util.Calendar;
/**
 * Classe responsavel por gerar os valores de hora, minuto e segundo em que a função de criptografia foi executada
 * @author Mauricio Sugimoto Polloni
 *
 */
public class Relogio 
{	
	/**
	 * retorna o valor da hora
	 * @return x
	 */
	public int hora()
	{		
		int x = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);		
	
		return x;
	}
	
	/**
	 * retorna o valor do minuto
	 * @return x
	 */
	public int minuto()
	{		
		int x = Calendar.getInstance().get(Calendar.MINUTE);
		
		return x;
	}
	
	/**
	 * retorna o valor do segundo
	 * @return x
	 */
	public int segundo()
	{		
		int x = Calendar.getInstance().get(Calendar.SECOND);
		
		return x;
	}
}
