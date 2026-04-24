# SmartWallet - Práctica de Pruebas Unitarias
## Escuela Politecnica Nacional
## Verificacion y validacion del software

Nombre: Dilan Real

Grupo: GR1

Implementación de la clase `SmartWallet` con métodos de depósito y retiro, incluyendo validaciones y reglas de negocio.
Ademas de ello cuenta con 8 test los cuales prueban:

- 1: Deposito valido.
- 2: Deposito con cashback (mayor a 100).
- 3: Depposito exactamente 100 (no incluye cashback).
- 4: Deposito que pasa el limite Standar de 5000.
- 5: Retiro valido.
- 6: retiro a 0 para dejar cuenta inactiva.
- 7: Saldo insuficiente.
- 8: Montos negativo.

## Cómo Ejecutar los Tests
Desde la carpeta raíz del proyecto, ejecuta:

```bash
mvn test
```

*Tambien se puede utilizar el pluggin de test runner for java *

