package bahamas;
import java.util.Scanner;
public class Bahamas {

	/**
	 * @author GrupoBahamas
	 * @param args
	 */
	public static void main(String[] args) {
		menu();		//invoco metodo para mostrar el menu principal
	}
	/**
	 * Presenta varias operaciones al usuario, dependiendo del numero que elija se le
	 * asignara una opcion
	 */
	public static void menu() {
		int r;
		Scanner scan=new Scanner(System.in);

		do{
			System.out.println("Que desea hacer?");
			System.out.println("1. Encontrar playa ideal");
			System.out.println("2. Encontrar hotel ideal");
			System.out.println("3. Encontrar restaurante ideal");
			System.out.println("4. Busque algo en concreto");
			System.out.println("5. Salir");
			r=scan.nextInt();
		}while(r!=1 && r!=2 && r!=3 && r!=4);

		if(r==1) {
			testPlaya();
		}else if(r==2) { 
			testHotel();
		}else if(r==3) { 
			testRestaurante();
		}else if(r==4){ 
			buscador();
		}else {
			System.out.println("programa finalizado");
		}


	}
	/**
	 * Se crea un array con todos los resultados posibles y se le da a elegir al usuario
	 * cual desea reservar.
	 */
	public static void buscador(){
		String r;
		boolean n=true;
		String [][]array1= {{
			"Playa de la Isla Gran Turca"
			,"Playa de la Isla de Balmoral"
			,"Playa de la Isla de la Laguna Azul"
			,"Playa de Isla Paradise"
			,"Playa de Gran Bahama"
			,"Playa Atlantis"
			,"Playa Cable"
		},{ 
			"Restaurante Mogano by Giorgio Locatelli"
			,"Restaurante Social House Sushi & Grill"
			,"Restaurante Shima"
			,"Restaurante Island Brothers & CIE Nassau"
			,"Restaurante 23° North"
			,"Restaurante Palapa"
		},{
			"Hotel Sandyport Beach Resort"
			,"Hotel Grand Hyatt Baha Mar"
			,"Hotel Breezes Resort"
			,"Hotel Saint Francis Resort & Marina"
			,"Hotel Cape Santa Maria Beach Resort & Villas "
			,"Hotel Towne"
			,"Hotel Peace and Plenty"
		}};
		Scanner scan=new Scanner(System.in);

		for (int i = 0; i < array1.length; i++) {
			if(i==0) {
				System.out.println("Playas: \r\n");
			}else if(i==1) {
				System.out.println("Restaurantes: \r\n");
			}else if(i==2){
				System.out.println("Hoteles: \r\n");
			}
			for (int j = 0; j < array1[i].length; j++) {
				System.out.println(array1[i][j]);
			}
			System.out.println();
		}


		System.out.println("Dónde desea realizar su reserva?");
		r=scan.nextLine();


		for (int i = 0; i < array1.length && n; i++) {
			for (int j = 0; j < array1[i].length && n; j++) {
				if(array1[i][j].equalsIgnoreCase(r)) {
					if(i==0) {
						reservaPlaya(array1[i][j]);//Playa
						n=false;
					}else if(i==1) {
						reservaRestaurante(array1[i][j]);//Restaurante
						n=false;
					}else {
						reservaHotel(array1[i][j]);//Hotel
						n=false;
					}

				}
			}
		}

	}
	/**
	 * @param pedira al usuario que dia ira a la playa.
	 */
	public static void reservaPlaya(String elemento) {
		Scanner scan = new Scanner(System.in);
		String fechaEnt;

		System.out.println("Que fecha irá?");
		fechaEnt = scan.nextLine();

		tiempoPlaya(fechaEnt,elemento);
	}
	/**
	 * @param fechaEnt
	 * @param elemento
	 * Metodo que imprime el clima que hara en la playa el dia que haya elegido.
	 */
	public static void tiempoPlaya(String fechaEnt, String elemento) {

		String[] clima = {
				"soleado", "lluvioso", "tormentoso", "nevado", "nublado", "muy caluroso"
		};

		int index ;

		index = (int)(Math.random()*5+0);

		System.out.println("El clima el dia "+fechaEnt+" en la "+elemento+" será, " +clima[index]);
		menu();
	}
	/**
	 * Pide los datos necesarios al usuario para realizar la reserva.
	 * @param elemento
	 */
	public static void reservaRestaurante(String elemento) {
		Scanner scan = new Scanner(System.in);

		String nombre,apellidos,telefono,DNI,fechaEnt,hora;

		System.out.println("Ingrese su nombre");
		nombre = scan.nextLine();

		System.out.println("Ingrese sus apellidos");
		apellidos = scan.nextLine();

		do {
			System.out.println("Ingrese su DNI");
			DNI = scan.nextLine();
		}while(!validarDNI(DNI));



		do {
			System.out.println("Ingrese la fecha de entrada para "+elemento);
			fechaEnt = scan.nextLine();	
		} while (!validarFecha(fechaEnt));

		do {
			System.out.println("Ingrese la hora a la que irá");
			hora = scan.nextLine();
		} while (!validarHora(hora));

		do {
			System.out.println("Ingrese su numero de contacto");
			telefono = scan.nextLine();
		}while(validarTelefono(telefono));

		confirmarReservaRestaurante(nombre,apellidos,telefono,DNI,fechaEnt,hora,elemento);
	}
	/**
	 * Metodo que confirma la reserva e imprime un mensaje al usuario.
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param DNI
	 * @param fechaEnt
	 * @param hora
	 * @param elemento
	 * 
	 */
	public static void confirmarReservaRestaurante(
			String nombre, String apellidos, String telefono, 
			String DNI, String fechaEnt, String hora, String elemento) {
		System.out.println("Muchas gracias "+nombre+" "+apellidos+" con el DNI de "+DNI+ " por su reserva");
		System.out.println("Disfrute de su comida el dia "+fechaEnt+" a las "+hora);
		System.out.println("Le llegará un SMS al numero "+telefono+" que usted nos ha proporcionado");
		menu();
	}
	/**
	 * Pide los datos necesarios al usuario para realizar la reserva.
	 * @param elemento
	 */
	public static void reservaHotel(String elemento) {
		Scanner scan = new Scanner(System.in);

		String nombre,apellidos,telefono,DNI,fechaEnt,fechaSal;

		System.out.println("Ingrese su nombre");
		nombre = scan.nextLine();

		System.out.println("Ingrese sus apellidos");
		apellidos = scan.nextLine();

		do {
			System.out.println("Ingrese su DNI");
			DNI = scan.nextLine();
		}while(!validarDNI(DNI));

		do {
			do {
				System.out.println("Ingrese la fecha de entrada para "+elemento);
				fechaEnt = scan.nextLine();
			}while(!validarFecha(fechaEnt));

			do {
				System.out.println("Ingrese la fecha de salida para "+elemento);
				fechaSal = scan.nextLine();
			}while(!validarFecha(fechaSal));
		}while(!validarRangoFechas(fechaEnt,fechaSal));

		do {
			System.out.println("Ingrese su numero de contacto");
			telefono = scan.nextLine();
		}while(validarTelefono(telefono));

		confirmarReservaHotel(nombre,apellidos,telefono,DNI,fechaEnt,fechaSal,elemento);
	}
	/**
	 * Metodo que confirma la reserva e imprime un mensaje al usuario.
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param DNI
	 * @param fechaEnt
	 * @param fechaSal
	 * @param elemento
	 */
	public static void confirmarReservaHotel(
			String nombre, String apellidos, String telefono, 
			String DNI, String fechaEnt, String fechaSal, String elemento) {
		System.out.println("Muchas gracias "+nombre+" "+apellidos+" con el DNI de "+DNI+ " por su reserva");
		System.out.println("Disfrute de su estacia durante los dias del "+fechaEnt+" al "+fechaSal);
		System.out.println("Le llegará un SMS al numero "+telefono+" que usted nos ha proporcionado");
		menu();
	}
	/**
	 * Metodo que valida la hora en el formato 00:00
	 * @param hora
	 * @return
	 */
	public static boolean validarHora(String hora) {
		// Expresión regular para validar el formato de una hora//
		String regex = "^([01]\\d|2[0-3]):([0-5]\\d)$";

		//Validar la hora con la expresión regular//
		return hora.matches(regex);
	}
	/**
	 * Metodo que valida el numero de telefono
	 * @param telefono
	 * @return
	 */
	public static boolean validarTelefono(String telefono) {
		// Expresión regular para validar el formato de un número de teléfono
		String regex = "^(\\+\\d{1,3})?\\d{8,10}$";

		// Validar el número de teléfono con la expresión regular
		return telefono.matches(regex);
	}
	/**
	 * Metodo que valida que la fecha de salida sea mayor o igual a la de entrada.
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public static boolean validarRangoFechas(String fechaInicio, String fechaFin) {
		boolean valido = true;

		// Extraer los componentes de las fechas
		String[] partesFechaIni = fechaInicio.split("/");
		String[] partesFechaFin = fechaFin.split("/");

		// Comprobar que las fechas tengan el formato correcto
		if (partesFechaIni.length != 3 || partesFechaFin.length != 3) {
			valido = false;
		} else {
			try {
				// Convertir los componentes de las fechas a enteros
				int diaIni = Integer.parseInt(partesFechaIni[0]);
				int mesIni = Integer.parseInt(partesFechaIni[1]);
				int anioIni = Integer.parseInt(partesFechaIni[2]);
				int diaFin = Integer.parseInt(partesFechaFin[0]);
				int mesFin = Integer.parseInt(partesFechaFin[1]);
				int anioFin = Integer.parseInt(partesFechaFin[2]);

				// Comprobar que las fechas sean válidas
				if (diaIni < 1 || diaIni > 31 || mesIni < 1 || mesIni > 12 || anioIni < 1 ||
						diaFin < 1 || diaFin > 31 || mesFin < 1 || mesFin > 12 || anioFin < 1) {
					valido = false;
				} else {
					// Comprobar que la fecha de inicio sea menor a la fecha final
					if (anioIni > anioFin ||
							(anioIni == anioFin && mesIni > mesFin) ||
							(anioIni == anioFin && mesIni == mesFin && diaIni > diaFin)) {
						valido = false;
					}
				}
			} catch (NumberFormatException e) {
				valido = false;
			}
		}

		return valido;
	}
	/**
	 * Metodo que valida las fechas de la reserva en formato DD/MM/YYYY
	 * @param fecha
	 * @return
	 */
	public static boolean validarFecha(String fecha) {
		boolean valido = true;

		// Comprobar que la longitud de la fecha sea 10 (dd/mm/yyyy)
		if (fecha.length() != 10) {
			valido = false;
		} else {
			// Extraer los componentes de la fecha
			String[] partes = fecha.split("/");
			if (partes.length != 3) {
				valido = false;
			} else {
				try {
					int dia = Integer.parseInt(partes[0]);
					int mes = Integer.parseInt(partes[1]);
					int anio = Integer.parseInt(partes[2]);

					// Comprobar que los componentes de la fecha sean válidos
					if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1) {
						valido = false;
					} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
						valido = false;
					} else if (mes == 2) {
						if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
							if (dia > 29) {
								valido = false;
							}
						} else {
							if (dia > 28) {
								valido = false;
							}
						}
					}
				} catch (NumberFormatException e) {
					valido = false;
				}
			}
		}

		return valido;
	}
	/**
	 * Metodo que valida el DNI del usuario
	 * @param dni
	 * @return
	 */
	public static boolean validarDNI(String dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		boolean valido = true;

		// Comprobar que la longitud del DNI sea 9
		if (dni.length() != 9) {
			valido = false;
		} else {
			// Extraer los dígitos y la letra del DNI
			String numeroStr = dni.substring(0, 8);
			char letra = dni.toUpperCase().charAt(8);

			// Comprobar que los dígitos del DNI sean válidos
			try {
				int numeros = Integer.parseInt(numeroStr);
			} catch (NumberFormatException e) {
				valido = false;
			}

			// Comprobar que la letra del DNI sea válida
			int numeros = Integer.parseInt(numeroStr);
			if (letras.charAt(numeros % 23) != letra) {
				valido = false;
			}
		}

		return valido;
	}
	/**
	 * Metodo que se encarga de hacer el cuestionario para despues recomendar un hotel llamando a un metodo.
	 */
	public static void testHotel(){
		int puntaje;
		puntaje=preguntasHotel();
		resultadoHotel(puntaje);
	}
	/**
	 * Metodo que se encarga de hacer el cuestionario para despues recomendar una playa llamando a un metodo.
	 */
	public static void testPlaya() {
		int puntaje;
		puntaje=preguntasPlaya();
		resultadoPlaya(puntaje);
	}
	/**
	 * Metodo que se encarga de hacer el cuestionario para despues recomendar un restaurante llamando a un metodo.
	 */
	public static void testRestaurante() {
		int puntaje;
		puntaje=preguntasRestaurante();
		resultadoRestaurante(puntaje);
	}
	/**
	 * Metodo que pregunta al usuario que caracteristicas que desea en su hotel.
	 * @return
	 */
	public static int preguntasHotel() {
		String array[]= {"Mas de 4 estrellas"
				, "Solo adultos"
				, "con piscina"
				, "Primera linea de playa"
				, "Club infantil"
				, "Spa"
				, "Perros permitidos"	
		};
		int p=0,r;
		Scanner scan=new Scanner(System.in);
		System.out.println("Especificaciones del hotel");
		for (int i = 0; i < array.length; i++) {
			r=0;
			do {
				System.out.println(array[i]);
				System.out.println("1. si");
				System.out.println("2. no");
				r=scan.nextInt();
			}while(r!=1&&r!=2);
			if(r==1) {
				p++;
			}
		}
		return p;
	}
	/**
	 * Metodo que pregunta al usuario caracteristicas/requisitos que desea en el restaurante.
	 * @return
	 */
	public static int preguntasRestaurante(){
		int p=0,r;
		String array[]= {"Buffet libre"
				, "Carta de alergenos"
				, "Alta cocina"
				, "Casera"
				, "Vegana"
				, "Menu del dia"
				, "Oriental"};

		Scanner scan=new Scanner(System.in);
		System.out.println("Especificaciones del restaurante");
		for (int i = 0; i < array.length; i++) {
			r=0;
			do {
				System.out.println(array[i]);
				System.out.println("1. si");
				System.out.println("2. no");
				r=scan.nextInt();
			}while(r!=1&&r!=2);
			if(r==1) {
				p++;
			}
		}

		return p;
	}
	/**
	 * Metodo que pregunta al usuario varias caracteristicas/requisitos que desea en la playa.
	 * @return
	 */
	public static int preguntasPlaya() {
		int p=0,r;
		String array[]= {"Playa de Arena."
				, "Actividades acuáticas."
				, "Alquiler de tumbonas."
				, "Baños públicos."
				, "Nudista."
				, "Perros permitidos"
				, "Calas"};

		Scanner scan=new Scanner(System.in);

		System.out.println("Especificaciones de la playa");
		for (int i = 0; i < array.length; i++) {
			r=0;
			do {
				System.out.println(array[i]);
				System.out.println("1. si");
				System.out.println("2. no");
				r=scan.nextInt();
			}while(r!=1&&r!=2);
			if(r==1) {
				p++;
			}
		}
		return p;
	}
	/**
	 * Metodo que dependiendo del puntaje del usuario, le recomienda un hotel y lo imprime.
	 * @param p
	 */
	public static void resultadoHotel(int p) {
		p=p-1;
		String[]array= {
				"Hotel Sandyport Beach Resort"
				,"Hotel Grand Hyatt Baha Mar"
				,"Hotel Breezes Resort"
				,"Hotel Saint Francis Resort & Marina"
				,"Hotel Cape Santa Maria Beach Resort & Villas "
				,"Hotel Towne"
				,"Hotel Peace and Plenty"
		};
		switch (p) { 
		case 0:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 1:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 2:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 3:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 4:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 5:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;	
		case 6:
			System.out.println("El hotel mas conveniente para usted es "+array[p]);
			menu();
			break;	


		default:
			System.out.println("Su playa mas conveniente es playa del paraiso");
			menu();
		}
	}
	/**
	 * Metodo que dependiendo del puntaje del usuario, le recomienda un restaurante y lo imprime.
	 * @param p
	 */
	public static void resultadoRestaurante(int p){
		p=p-1;
		String[]array= {
				"Restaurante Mogano by Giorgio Locatelli"
				,"Restaurante Social House Sushi & Grill"
				,"Restaurante Shima"
				,"Restaurante Island Brothers & CIE Nassau"
				,"Restaurante 23° North"
				,"Restaurante Palapa"
		};

		switch (p) { 
		case 0:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 1:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 2:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 3:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 4:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 5:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;	
		case 6:
			System.out.println("El restaurante mas conveniente para usted es "+array[p]);
			menu();
			break;	



		default:
			System.out.println("Su restaurante mas conveniente es restaurante sucasa");
			menu();
		}
	}
	/**
	 * Metodo que dependiendo del puntaje del usuario, le recomienda una playa y lo imprime.
	 * @param p
	 */
	public static void resultadoPlaya(int p) {
		p=p-1;
		String []array= {
				"Playa de la Isla Gran Turca"
				,"Playa de la Isla de Balmoral"
				,"Playa de la Isla de la Laguna Azul"
				,"Playa de Isla Paradise"
				,"Playa de Gran Bahama"
				,"Playa Atlantis"
				,"Playa Cable"
		};

		switch (p) { 
		case 0:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 1:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 2:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 3:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;
		case 4:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;	  
		case 5:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;	
		case 6:
			System.out.println("La playa mas conveniente para usted es "+array[p]);
			menu();
			break;	


		default:
			System.out.println("Su playa mas conveniente es playa del paraiso");
			menu();
		}


	}
}