# benjon

Potentially a Clojure backend for [benson](http://github.com/mieky/benson).

## Setting up the database

- Requires postgresql 9.4+
- Create and populate your database stub, see src/sql/queries.sql

## Running

You need [Leiningen](http://leiningen.org/).

1. Clone the repo
2. `lein run`

## Building

    lein uberjar
    java -jar target/uberjar/benjon-0.1.0-SNAPSHOT-standalone.jar

## License

MIT
