package Projeto1;

import java.io.IOException;
import java.util.Random;
import java.util.InputMismatchException;
import 	java.util.Scanner;

public class tempoClima 
{

	public static void main(String[] args)
	{
	
		
		int escolha;
		Double data[][][] = new Double[2021][13][32];
		int mes = 0, ano = 0;
		Scanner ler = new Scanner(System.in);
		Random random = new Random();
		
		do
		{
		menu();
		System.out.print("Digite a opcao desejada: ");
		escolha = ler.nextInt();
		
		//valores aleatorios atribuidos ao mes 1 de 2020
		for(int x = 0; x < 31;x++)
		{
			
			data[2020][1][x] = (double) random.nextInt(32);
			
			
		}
		
		switch (escolha) 
		{
		
		case 1:
			entradaTemp(mes, ler, data, ano);	
			break;
		case 2:
			tempMedia(mes, ler, data, ano);
			break;
		case 3:
			tempMinima(mes, ler, data, ano);
			break;
		case 4:
			tempMax(mes, ler, data, ano);
			break;
		case 5:
			relatorio(mes, ler, data, ano);
			break;
		
		}
		}while(escolha != 6);

	}
	
	public static void menu() 
	{
		System.out.println("1- Entrada das temperaturas");
		System.out.println("2- Calculo da temperatura media");
		System.out.println("3- Calculo da temperatura minima");
		System.out.println("4- Calculo da temperatura maxima");
		System.out.println("5- Relatorio meteorologico");
		System.out.println("6- Encerrar programa");
	}
	
	public static void entradaTemp(int mes, Scanner ler, Double data[][][], int ano) 
		{
		try {
		System.out.println("Qual mes deseja cadastrar");
		mes = ler.nextInt();
		
		System.out.println("Qual ano deseja cadastrar");
		ano = ler.nextInt();
		if(ano < 2011 || ano > 2020)
		{
			System.out.println("Ano invalido digite um ano entre 2011 e 2020 ");
			ano = ler.nextInt();
		}
		
		
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
			{
			
			for(int i = 0; i < 31; i++) 
				{
				System.out.println("Digite a temperatura media do dia " + (i+1));
				data[ano][mes][i] = ler.nextDouble();
				}
			}
			
		
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
			{
			for(int i = 0; i < 30; i++)
				{
				System.out.println("Digite a temperatura media do dia " + (i+1));
				data[ano][mes][i] = ler.nextDouble();
				}
			}
		
		else if(mes == 2)
			{
			
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
				{
				
				for(int i = 0; i < 29; i++)
					{
					System.out.println("Digite a temperatura media do dia " + (i+1));
					data[ano][mes][i] = ler.nextDouble();
					}
				}
			else
				{
				for(int i = 0; i < 28; i++) 
					{
					System.out.println("Digite a temperatura media do dia " + (i+1));
					data[ano][mes][i] = ler.nextDouble();
					}
				}
			}
		
		
		
		}
		catch (InputMismatchException e)
		{
			System.out.println("Por favor digite um numero");
		}
		catch (Exception e)
		{
			System.out.println("Mes ou ano fora do padrao");
		}
		
		}
	
	public static void tempMedia(int mes, Scanner ler, Double data[][][], int ano) 
	{
		
		double soma = 0;
		double media = 0;
		
		do
		{
		System.out.println("Digite o mes que deseja consultar:");
		mes = ler.nextInt();
	
		
		System.out.println("Digite o ano que deseja consultar:");
		ano = ler.nextInt();
		if(data[ano][mes][1] == null)
		{
			System.out.println("Data nao cadastrada");
		}
		}while(data[ano][mes][1] == null);
		
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
		{
			for(int i = 0; i < 31; i++) 
			{
				soma = soma + data[ano][mes][i];
			}
			media = soma / 31;
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
		{
			for(int i = 0; i < 30; i++) 
			{
				soma = soma + data[ano][mes][i];
			}
			media = soma / 30;
		}
		else if(mes == 2)
		{
		
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
			{
			
				for(int i = 0; i < 29; i++) 
				{
					soma = soma + data[ano][mes][i];
				}
				media = soma / 29;
			}
			else
			{
				for(int i = 0; i < 28; i++) 
				{
					soma = soma + data[ano][mes][i];
				}
				media = soma / 28;
			}
		}
		
		
		System.out.println("A media das temperaturas do mes "+mes+ " do ano " +ano+" eh: " +media);
		
	}
	
	
	public static void tempMinima(int mes, Scanner ler, Double data[][][], int ano)
	{
		int i = 0;
		double minima = 9999;
		int j = 0;
		
		do
		{
		System.out.println("Digite o mes que deseja consultar:");
		mes = ler.nextInt();
	
		
		System.out.println("Digite o ano que deseja consultar:");
		ano = ler.nextInt();
		if(data[ano][mes][1] == null)
		{
			System.out.println("Data nao cadastrada");
		}
		}while(data[ano][mes][1] == null);
		
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
		{
			for(i = 0; i < 31; i++) 
			{
				if(data[ano][mes][i] < minima)
				{
					minima = data[ano][mes][i];
					j = i;
				}
				
			}
			
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
		{
			for(i = 0; i < 30; i++) 
			{
				if(data[ano][mes][i] < minima)
				{
					minima = data[ano][mes][i];
					j = i;
				}
				
			}
			
		}
		else if(mes == 2)
		{
		
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
			{
			
				for(i = 0; i < 29; i++) 
				{
					if(data[ano][mes][i] < minima)
					{
						minima = data[ano][mes][i];
						j = i;
					}
					
				}
				
			}
			else
			{
				for(i = 0; i < 28; i++) 
				{
					if(data[ano][mes][i] < minima)
					{
						minima = data[ano][mes][i];
						j = i;
					}
					
				}
				
			}
			
			
		}
		System.out.println("Temperatura minima: " + minima + " Data: "+ (j+1) +"/" + mes + "/"+ ano);
	}
	
	public static void tempMax(int mes, Scanner ler, Double data[][][], int ano)
	{
		int i = 0;
		double maxima = -9999;
		int j = 0;
		
		do
		{
		System.out.println("Digite o mes que deseja consultar:");
		mes = ler.nextInt();
	
		
		System.out.println("Digite o ano que deseja consultar:");
		ano = ler.nextInt();
		if(data[ano][mes][1] == null)
		{
			System.out.println("Data nao cadastrada");
		}
		}while(data[ano][mes][1] == null);
		
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
		{
			for(i = 0; i < 31; i++) 
			{
				if(data[ano][mes][i] > maxima)
				{
					maxima = data[ano][mes][i];
					j = i;
				}
				
			}
			
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
		{
			for(i = 0; i < 30; i++) 
			{
				if(data[ano][mes][i] > maxima)
				{
					maxima = data[ano][mes][i];
					j = i;
				}
				
			}
			
		}
		else if(mes == 2)
		{
		
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
			{
			
				for(i = 0; i < 29; i++) 
				{
					if(data[ano][mes][i] > maxima)
					{
						maxima = data[ano][mes][i];
						j = i;
					}
					
				}
				
			}
			else
			{
				for(i = 0; i < 28; i++) 
				{
					if(data[ano][mes][i] > maxima)
					{
						maxima = data[ano][mes][i];
						j = i;
					}
					
				}
				
			}
			
		}
		System.out.println("Temperatura maxima: " +maxima+ " Data: "+(j+1)+"/"+mes + "/"+ ano);
	}
	
	public static void relatorio(int mes, Scanner ler, Double data[][][], int ano)
	{
		int i = 0;
		double minima = 9999;
		double maxima = -9999;
		int j = 0;
		int k = 0;
		double soma = 0;
		double media = 0;
		
		do
		{
		System.out.println("Digite o mes que deseja consultar:");
		mes = ler.nextInt();
	
		
		System.out.println("Digite o ano que deseja consultar:");
		ano = ler.nextInt();
		if(data[ano][mes][1] == null)
		{
			System.out.println("Data nao cadastrada");
		}
		}while(data[ano][mes][1] == null);
		
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
		{
			for(i = 0; i < 31; i++) 
			{
				if(maxima <= data[ano][mes][i])
				{
					maxima = data[ano][mes][i];
				}
				if(maxima == data[ano][mes][i])
				{
					j = i;
				}
				
				if(minima > data[ano][mes][i])
				{
					minima = data[ano][mes][i];
				}
				if(minima == data[ano][mes][i])
				{
					k = i;
				}
				
				System.out.println("Media dia "+(i+1)+" "+data[ano][mes][i]);
				
				soma = soma + data[ano][mes][i];
			}
			media = soma / 31;
			System.out.println("A media das temperaturas do mes "+mes+ " do ano " +ano+" eh: " +media);
			System.out.println("Temperatura minima: " +minima+ " Data: "+(k+1)+"/"+mes + "/"+ ano);
			System.out.println("Temperatura maxima: " +maxima+ " Data: "+(j+1)+"/"+mes + "/"+ ano);
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
		{
			for(i = 0; i < 30; i++) 
			{
				if(maxima <= data[ano][mes][i])
				{
					maxima = data[ano][mes][i];
				}
				if(maxima == data[ano][mes][i])
				{
					j = i;
				}
				
				if(minima > data[ano][mes][i])
				{
					minima = data[ano][mes][i];
				}
				if(minima == data[ano][mes][i])
				{
					k = i;
				}
				
				System.out.println("Media dia "+(i+1)+" "+data[ano][mes][i]);
				
				soma = soma + data[ano][mes][i];
			}
			media = soma / 30;
			System.out.println("A media das temperaturas do mes "+mes+ " do ano " +ano+" eh: " +media);
			System.out.println("Temperatura minima: " +minima+ " Data: "+(k+1)+"/"+mes + "/"+ ano);
			System.out.println("Temperatura maxima: " +maxima+ " Data: "+(j+1)+"/"+mes + "/"+ ano);
		}
		else if(mes == 2)
		{
		
			if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
			{
			
				for(i = 0; i < 29; i++) 
				{
					if(maxima <= data[ano][mes][i])
					{
						maxima = data[ano][mes][i];
					}
					if(maxima == data[ano][mes][i])
					{
						j = i;
					}
					
					if(minima > data[ano][mes][i])
					{
						minima = data[ano][mes][i];
					}
					if(minima == data[ano][mes][i])
					{
						k = i;
					}
					
					System.out.println("Media dia "+(i+1)+" "+data[ano][mes][i]);
					
					soma = soma + data[ano][mes][i];
				}
				media = soma / 29;
				System.out.println("A media das temperaturas do mes "+mes+ " do ano " +ano+" eh: " +media);
				System.out.println("Temperatura minima: " +minima+ " Data: "+(k+1)+"/"+mes + "/"+ ano);
				System.out.println("Temperatura maxima: " +maxima+ " Data: "+(j+1)+"/"+mes + "/"+ ano);
			}
			else
			{
				for(i = 0; i < 28; i++) 
				{
					if(maxima <= data[ano][mes][i])
					{
						maxima = data[ano][mes][i];
					}
					if(maxima == data[ano][mes][i])
					{
						j = i;
					}
					
					if(minima > data[ano][mes][i])
					{
						minima = data[ano][mes][i];
					}
					if(minima == data[ano][mes][i])
					{
						k = i;
					}
					
					System.out.println("Media dia "+(i+1)+" "+data[ano][mes][i]);
					
					soma = soma + data[ano][mes][i];
				}
				media = soma / 28;
				System.out.println("A media das temperaturas do mes "+mes+ " do ano " +ano+" eh: " +media);
				System.out.println("Temperatura minima: " +minima+ " Data: "+(k+1)+"/"+mes + "/"+ ano);
				System.out.println("Temperatura maxima: " +maxima+ " Data: "+(j+1)+"/"+mes + "/"+ ano);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
