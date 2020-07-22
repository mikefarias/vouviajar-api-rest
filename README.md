# Vou Viajar API Rest

API Rest para utilização em SAAS para Agências de Viagens

## Regras de Negócios

Existem três módulos disponíveis na API: Account, Company e Client. 
Account é responsável pelo gerenciamento dos usuários cadastrados. 
Company é responsável pelo geranciamento das agências de turismo cadastradas; e 
Client é responsável pelo gerenciamento dos clientes das agências de turismo. 

Account
* RN01 - Um usuário deve ser único por CPF ou CNPJ; 
* RN02 - Somente é possível habilitar o cadastro de uma agência de viagens com cadastro de CNPJ e Cadastur; 
* RN03 - Login do usuário deve ser realizado com e-mail e é necessário confirmação do cadastro;
* RN04 - O cadastro inicial deve solicitar somente nome, sobrenome, email e senha coom objetivo de apresentar o serviço a agência. Portanto, estes campos são obrigatórios;
* RN05 - Necessário validação de CNPJ e Cadastur para habilitar uma agência de viagens;
* RN06 - O id_company será o tenant para organizar os dados de cada agência de turismo no SAAS;
* RN07 - Um CNPJ pode ter apenas uma Agência de Turismo; 
* RN08 - Possibiliar alteração de senha;
* RN09 - Permitir login através de redes sociais; 
* RN10 - Acessar o máximo de informações para entender comportamento do cliente;


Company
* RN11 - Uma agência de viagens pode cadastrar uma viagem;
* RN12 - As viagens podem ser do tipo EXCURSÃO e BATE E VOLTA;
* RN13 - Uma viagem tem os seguintes status CADASTRADA, PUBLICADA, FINALIZADA, CANCELADA, EXCLUIDA;
* RN14 - Uma viagem possui um ou mais pacotes de viagens possíveis para VENDA;
* RN15 - Um pacote precisa de uma reserva de cliente para preencher uma das vagas;
* RN16 - A reserva pode ser cadastrada pela própria Agência de Turismo ou, preferencialmente, pelo cliente cadastrado no SAAS. A reserva é realizada no momento da assinatura do contrato;
* RN17 - O contrato deve conter dados do contrante e contratado além de especificar valores devidos;
* RN18 - Em caso de disponibilidade de pagamento via SAAS, o contrato passa a ter validade após confirmação de pagamento via cartão de crédito; 

## Endpoints por módulo 

Account
- /api/v1/user

Company
- /api/v1/travel-agency
- /api/v1/travel
- /api/v1/travel-package
- /api/v1/travel-contract
- /api/v1/reservation

Client
- /api/v1/travel-sugestion
