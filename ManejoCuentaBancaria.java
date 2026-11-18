
import java.util.ArrayList;
import java.util.Scanner;

public class ManejoCuentaBancaria {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n===== MENU CUENTA BANCARIA =====");
            System.out.println("1. Crear objeto por defecto");
            System.out.println("2. Crear objeto con parametros");
            System.out.println("3. Modificar atributos del objeto");
            System.out.println("4. Visualizar objetos registrados");
            System.out.println("5. Retirar dinero");
            System.out.println("6. Depositar dinero");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        CuentaBancaria cuenta1 = new CuentaBancaria();
                        cuentas.add(cuenta1);
                        System.out.println("Cuenta creada por defecto.");
                        break;

                    case 2:
                        System.out.print("Ingrese el titular: ");
                        String titular = sc.nextLine();

                        System.out.print("Ingrese el numero de cuenta: ");
                        String numero = sc.nextLine();

                        System.out.print("Ingrese el saldo inicial: ");
                        double saldo = Double.parseDouble(sc.nextLine());

                        System.out.print("Ingrese el limite de retiro: ");
                        double limite = Double.parseDouble(sc.nextLine());

                        if (titular.trim().isEmpty() ||
                            numero.trim().isEmpty() ||
                            saldo < 0 || limite < 0) {

                            System.out.println("Datos no validos.");

                        } else {
                            CuentaBancaria cuenta2 =
                                new CuentaBancaria(titular, numero, saldo, limite);

                            cuentas.add(cuenta2);
                            System.out.println("Cuenta creada correctamente.");
                        }
                        break;

                    case 3:
                        if (cuentas.isEmpty()) {
                            System.out.println("No hay cuentas registradas.");
                            break;
                        }

                        System.out.print("Ingrese la posicion de la cuenta (1 a "
                                + cuentas.size() + "): ");
                        int pos = Integer.parseInt(sc.nextLine());

                        if (pos < 1 || pos > cuentas.size()) {
                            System.out.println("Posicion no valida.");
                            break;
                        }

                        CuentaBancaria cuenta = cuentas.get(pos - 1);

                        System.out.println("1. Modificar titular");
                        System.out.println("2. Modificar numero de cuenta");
                        System.out.println("3. Modificar saldo");
                        System.out.println("4. Modificar limite de retiro");
                        System.out.print("Seleccione: ");

                        int campo = Integer.parseInt(sc.nextLine());

                        switch (campo) {
                            case 1:
                                System.out.print("Nuevo titular: ");
                                cuenta.setTitular(sc.nextLine());
                                break;

                            case 2:
                                System.out.print("Nuevo numero: ");
                                cuenta.setNumeroCuenta(sc.nextLine());
                                break;

                            case 3:
                                System.out.print("Nuevo saldo: ");
                                cuenta.setSaldo(Double.parseDouble(sc.nextLine()));
                                break;

                            case 4:
                                System.out.print("Nuevo limite: ");
                                cuenta.setLimiteRetiro(Double.parseDouble(sc.nextLine()));
                                break;

                            default:
                                System.out.println("Opcion no valida.");
                        }
                        break;

                    case 4:
                        if (cuentas.isEmpty()) {
                            System.out.println("No hay cuentas registradas.");
                        } else {
                            for (int i = 0; i < cuentas.size(); i++) {
                                System.out.println("\nCuenta " + (i + 1));
                                cuentas.get(i).mostrarInformacion();
                            }
                        }
                        break;

                    case 5:
                        if (cuentas.isEmpty()) {
                            System.out.println("No hay cuentas registradas.");
                            break;
                        }

                        System.out.print("Posicion de la cuenta: ");
                        int posicionRetiro = Integer.parseInt(sc.nextLine());

                        if (posicionRetiro < 1 ||
                            posicionRetiro > cuentas.size()) {
                            System.out.println("Posicion no valida.");
                            break;
                        }

                        System.out.print("Monto a retirar: ");
                        double retiro = Double.parseDouble(sc.nextLine());

                        cuentas.get(posicionRetiro - 1).retirar(retiro);
                        break;

                    case 6:
                        if (cuentas.isEmpty()) {
                            System.out.println("No hay cuentas registradas.");
                            break;
                        }

                        System.out.print("Posicion de la cuenta: ");
                        int posicionDeposito = Integer.parseInt(sc.nextLine());

                        if (posicionDeposito < 1 ||
                            posicionDeposito > cuentas.size()) {
                            System.out.println("Posicion no valida.");
                            break;
                        }

                        System.out.print("Monto a depositar: ");
                        double deposito = Double.parseDouble(sc.nextLine());

                        cuentas.get(posicionDeposito - 1).depositar(deposito);
                        break;

                    case 7:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero valido.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
