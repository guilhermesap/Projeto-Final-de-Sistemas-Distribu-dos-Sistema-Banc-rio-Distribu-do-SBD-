# Projeto Final SD: Sistema Bancário-Distribuído
---
## Objetivos do trabalho

1. Cada grupo deverá projetar e desenvolver um Sistema Bancário Distribuído (SBD);
2. O SBD de cada grupo consistirá em um Sistema Bancário, provendo operações e serviços
para movimentações financeiras;

### uml: class diagram 

```
@startuml
package "Projeto Final SD" {
    class Cliente {
        + email
        + nome
        + cpf
    }

    class Conta {
        + id
        + senha
        + saldo
      
    }
    
    class Operações {
        + Deposito()
        + Saque()
        + Transferência()
        + Consulta()
        + Extrato()
        
    }
    class Login {
        + id
        + senha
    }

   
    class SistemaBancário {
    }

    SistemaBancário <|-- Cliente
    SistemaBancário <|-- Conta
    SistemaBancário <|-- Operações
    SistemaBancário <|-- Login
    
    }
}
@enduml
```
