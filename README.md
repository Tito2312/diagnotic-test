# Diagnostic

Aplicación de consola desarrollada en Java para procesar transacciones sobre una billetera. El proyecto permite registrar apuestas (`BET`) y premios (`WIN`), validar los montos, controlar el saldo disponible y detectar transacciones repetidas mediante su identificador.

## Características

- Procesamiento de apuestas y premios con `BigDecimal`.
- Aprobación o rechazo de cada transacción.
- Validación de montos mayores que cero.
- Rechazo de apuestas cuando el saldo disponible no es suficiente.
- Control de transacciones duplicadas por identificador.
- Registro del saldo resultante y una descripción para cada operación.
- Pruebas unitarias con JUnit 5.

## Requisitos

- Java 21 o superior.
- Apache Maven 3.8 o superior.

Puedes comprobar las versiones instaladas con:

```bash
java -version
mvn -version
```

## Ejecución

Clona el repositorio y entra en su directorio:

```bash
git clone https://github.com/Tito2312/diagnotic-test.git
cd diagnotic-test
```

Compila el proyecto:

```bash
mvn compile
```

Ejecuta el programa principal:

```bash
java -cp target/classes org.main.Main
```

El programa procesa un conjunto de transacciones de ejemplo y muestra el estado, la fecha y el saldo resultante de cada una, además de un resumen final.

## Pruebas

Para ejecutar las pruebas unitarias:

```bash
mvn test
```

Las pruebas cubren apuestas aprobadas, saldo insuficiente, premios aprobados, montos negativos, transacciones duplicadas y la conservación del saldo cuando se recibe una solicitud repetida.

## Reglas de negocio

1. Toda transacción debe tener un monto mayor que cero y un tipo válido.
2. Una apuesta descuenta el monto del saldo únicamente si el saldo es estrictamente mayor que dicho monto.
3. Un premio suma el monto al saldo.
4. Una transacción con un identificador ya procesado se marca como duplicada y no modifica el saldo.
5. Las transacciones rechazadas tampoco modifican el saldo.

## Estructura del proyecto

```text
Diagnostic/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── model/
            │   ├── Transaction.java
            │   ├── TransactionResult.java
            │   ├── TransactionStatus.java
            │   ├── TransactionType.java
            │   └── Wallet.java
            ├── org/main/
            │   └── Main.java
            └── service/
                ├── WalletService.java
                └── WalletServiceTest.java
```

### Componentes principales

- `Wallet`: representa la billetera y su saldo actual.
- `Transaction`: contiene el identificador, tipo, monto y fecha de una transacción.
- `WalletService`: aplica las reglas de negocio y mantiene los resultados procesados.
- `TransactionResult`: representa el resultado de una operación.
- `Main`: punto de entrada de la aplicación de consola.
- `WalletServiceTest`: pruebas unitarias del servicio.

## Tecnologías

- Java 21
- Maven
- JUnit Jupiter 5

