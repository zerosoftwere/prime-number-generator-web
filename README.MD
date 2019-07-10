# Prime Number Generator

## About

Web based prime numbers generator

## Requirements

- java version 8+
- gradle version 4+

## Build

- `gradle build` compiles, test and builds the jar file in *build/libs* directory

## Usage

`http://localhost:8000/primes/start={int}&end={int}&strategy={str}`

Start:

    -number greater than 1 less than max integer

Stop:

    -number greater than start less than max integer

Strategies:

    -td  generates prime numbers using repeated division

    -sv  generates prime numbers using sieve of eratosthenes

    -cd  concurrent td

Example: `http://localhost:8000/primes?start=100&stop=20000&strategy=cd`

## Run server

- `gradle bootrun` starts the application

## Entries

- `http://localhost:8000/records` returns list of successful queries in the server