import java.util.Random;

/**
 * Classe responsavel por executar o processo de criptografia do texto
 * 
 * 
 * @author Mauricio sugimoto Polloni
 *
 */

public class Maquina
{
	char[] textoC,textoDC,cripto,descripto;
	int i=0,k=0,y,j=0,s=0;
	
	int ascii [];
	int ascii2 [];
	Relogio r = new Relogio();
	
	/**
	 *  Recebe o texto puro e retorna o texto criptografado
	 *  @param textoPuro
	 *  @return resposta 
	 */	
	
	public String Criptografar(String textoPuro)
	{
		
		textoC = textoPuro.toCharArray();
		y = textoC.length;
		
		ascii = new int[y];
		cripto = new char[(y*2)+2];
		
		for(int l=0;l<y;l++)
		{
			ascii[l]=(int)textoC[l];
		}		
		
		conta();		
		
		
		String resposta = String.copyValueOf(cripto);	
		
				
		return resposta;
	}
	
	/**
	 * Recebe o texto criptografado e retorna o texto puro
	 * @param textoCripto
	 * @return respostaD
	 */
	public String DesCriptografar(String textoCripto)
	{
		textoDC = textoCripto.toCharArray();
		y = textoDC.length;
		
		
		ascii2 = new int[y+3];
		descripto = new char[y+3];
		
		for(int l=0;l<y;l++)
		{
			ascii2[l]=(int)textoDC[l];
		}
				
		
		contaRev();		
		
		String respostaD = String.copyValueOf(descripto);		
		return respostaD;
	}
	
	/**
	 * Retorna um valor aleatorio entre 1 e o parametro limite
	 * @param limite
	 * @return valor
	 */
	public int gerador(int limite)
	{
		Random geraHora = new Random();
		int valor = geraHora.nextInt(limite);
		return valor;
	}
	
	/**
	 * Criptografa atrav�s de uma chave  de 3 bytes, por�m o texto criptografado possui o dobro de tamanho do texto puro.
	 * 
	 * Cada Byte do texto puro � transformado em um valor int (referente ao seu valor decimal da tabela ASCII), somado com o valor um valor aleat�rio gerado pelo m�todo gerador()
	 * e introduzido em um vetor char. A posi��o do Byte determina por qual Byte da chave ele ser� criptografado, por exemplo: o byte na primeira posi��o ser� criptografado por um valor aleat�rio
	 * entre 1 e o valor da hora em que o m�todo criptografar() foi executado, a segunda posi��o � criptografada pelo valor aleat�rio entre o 1 e o minuto em que o m�todo foi iniciado
	 * e a terceira posi��o, pelo valor aleat�rio entre 1 e o segundo em que o m�todo foi iniciado.Por fim, � somado 32 a todos os valores.
	 * 
	 * Os valores aleatorios gerados tambem s�o criptografados em sequencia dos bytes criptografado, somando 32 ao valor gerado e convertendo em char para a introdu��o no vetor.
	 * @return 0
	 */
	
	public int conta()
	{
		
		if(k>=y)
		{			
			return 0;
		}
		
		else
		{
			if(j==0)
			{
				int hora = gerador(r.hora());
				int valor = ascii[k]+hora+32;								
				
				cripto[i] = (char)(valor);				
				cripto[i+3] =(char)(hora+32);
				
				k++;
				i++;				
				j++;
				return conta();
			}	
			
			if(j==1)
			{
				int min = gerador(r.minuto());				
				int valor = ascii[k]+min+32;				
				
				cripto[i] = (char) (valor);				
				cripto[i+3] = (char) (min+32);
				
				k++;
				i++;				
				j++;
				return conta();
			}
		
			
			if(j==2)
			{
				int seg = gerador(r.segundo());
				int valor = ascii[k]+seg+32;							
				
				cripto[i] =(char) (valor);				
				cripto[i+3] =(char) (seg+32);
				
				k++;
				i=i+4;				
				j=0;
				return conta();
			}
		}
		k=0;
		j=0;
		return 0;		
	}
	
	/**
	 * Descriptografa o texto recebido atrav�s de uma chave de 6 bytes, por�m o texto descriptografado possui metade do tamanho do texto criptografado.
	 * 
	 * Os bytes s�o convertidos em valores int, � subtra�do dos 3 primeiros bytes os valores dos 3 �ltimos respectivamente. � subtra�do 32 de todos os valores.
	 * Por fim, os valores s�o convertidos em char e inseridos novamente em um vetor char

	 * @return 0;
	 */

	public int contaRev()
	{
		if(k>=(y/2))
		{
			return 0;
		}
		
		else
		{
			if(j==0)
			{
				int hora = ascii2[s+3]-32;				
				int valor = ascii2[s];			
				
				descripto[k]=(char)(valor-hora-32);				
				
				j++;
				k++;
				s++;
				return contaRev();
			}
			
			if(j==1)
			{
				int min = ascii2[s+3]-32;
				int valor = ascii2[s];				
				
				descripto[k]=(char)(valor-min-32);			
				
				j++;
				k++;
				s++;
				return contaRev();
			}
			
			if(j==2)
			{
				int seg = ascii2[s+3]-32;
				int valor = ascii2[s];			
				
				descripto[k]=(char)(valor-seg-32);			
				
				k++;
				s=s+4;
				j=0;
				return contaRev();
			}				
		}
		k=0;
		j=0;
		return 0;
	}	
}
