<p align="center">
  <a href="https://api.whatsapp.com/send?phone=5561984443443&text=Ola%20Ant%C3%B4nio!" alt="WhatsApp">
  <img src="https://img.shields.io/badge/-WhatsApp-25d366?style=flat-square&labelColor=25d366&logo=whatsapp&logoColor=white&link=https://api.whatsapp.com/send?phone=5561984443443&text=Ola%20Ant%C3%B4nio!" alt="Link para o whatsapp"/></a>

  <a href="https://www.linkedin.com/in/antonio-lima-jr/" alt="Linkedin">
  <img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/antonio-lima-jr/"  alt="Link para o Linkedin"/></a>

  <a href="https://github.com/Antonio-Lima-Jr" alt="Github">
  <img src="https://img.shields.io/badge/-GitHub-100000?style=flat-square&logo=github&logoColor=white&link=https://github.com/Antonio-Lima-Jr"  alt="link para o github"/></a>
</p>  
<h1 align="center">Desafio Certi api</h1>

<!-- TABLE OF CONTENTS -->
<details >
  <summary>Indice</summary>
  <ol>
    <li>
      <a href="#desafio-proposto">Desafio Proposto</a>
      <ul>
        <li><a href="#tecnologias-utilizadas">Tecnologias utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#rodar-Projeto">Rodar Projeto</a>
      <ul>
        <li><a href="#Pré-requisitos">Pré-requisitos</a></li>
        <li><a href="#executar-projeto">Executar projeto</a></li>
      </ul>
    </li>
    <li><a href="#utilização">Utilização</a>
      <ul>
         <li><a href="#imagens">Imagens</a></li>
      </ul>
    </li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## Desafio Proposto

Na linguagem de sua preferência, crie um servidor HTTP que, para cada requisição GET, retorne um JSON cuja chave extenso
seja a versão por extenso do número inteiro enviado no path. Os números podem estar no intervalo [-99999, 99999].

```bash
$ curl http://localhost:3000/1
{ "extenso": "um" }
```

```bash
$ curl http://localhost:3000/-1042
{ "extenso": "menos mil e quarenta e dois" }
```

```bash
$ curl http://localhost:3000/94587
{ "extenso": "noventa e quatro mil e quinhentos e oitenta e sete" }
```

### Tecnologias utilizadas

- [Spring](https://spring.io/)
- [Docker](https://www.docker.com/)
- [Insomnia Rest](https://insomnia.rest/)

<!-- GETTING STARTED -->

## Rodar Projeto

Utilizado Docker build multi-stage, é utilizada uma imagem com maven apenas para fazer o build e gerar o .jar e então
esse jar e transferido para outra imagem com um openjdk. Desta forma não é necessária nenhuma dependência local e todo o
processo de build e execução fica por conta do docker.

### Pré-requisitos

Para Rodar este projeto é necessário apenas o docker instalado.

- [Docker Install](https://docs.docker.com/get-docker/)

### Executar projeto

1. Clone o repositório
   ```shell
   git clone https://github.com/Antonio-Lima-Jr/desafio-certi.git
   ```
2. Entre na pasta
   ```shell
   cd desafio-certi
   ```
3. Vá para a Branch de Desenvolvimento
   ```
   git checkout Desenvolvimento
   ```
4. Build Image docker

   ```shell
   docker build -t api-certi .
   ```

5. Rodar Image construida
   ```shell
   docker run -p 3000:3000 -t api-certi
   ```

## Utilização

Após o projeto rodando aceitara requisições GET na porta 3000 local seguido de um valor no path e retornara o mesmo por
extenso, caso esteja fora do range -99999 e 99999 retorna um erro personalizado.

### Imagens

<p align="center">
   <img alt="Requisição" src="https://github.com/Antonio-Lima-Jr/desafio-certi/blob/main/screenshot/get19919.png" width="300"/>
   <img alt="Requisição" src="https://github.com/Antonio-Lima-Jr/desafio-certi/blob/main/screenshot/res19919.png" width="300"/>

   <img alt="Requisição" src="https://github.com/Antonio-Lima-Jr/desafio-certi/blob/main/screenshot/get100000.png" width="300"/>
   <img alt="Requisição" src="https://github.com/Antonio-Lima-Jr/desafio-certi/blob/main/screenshot/res100000.png" width="300"/>
</p>

## Contato

Antônio Lima Jr - [Linkedin](https://www.linkedin.com/in/antonio-lima-jr/) - antonio.df.013@gmail.com

Project Link: [https://github.com/Antonio-Lima-Jr/desafio-certi](https://github.com/Antonio-Lima-Jr/desafio-certi)
