# Docker build demo

Simple apps to demonstrate different requirements for building Docker images.

All applications are (non-compliant) bare bones web servers.

All the servers can be used @ [localhost:8080](http://localhost:8080/).

```bash
curl localhost:8080
```

## server1

Web server with no pre-build step or dependencies beyond Ruby.
The purpose of this app is to demo a very simple Docker build.

```bash
docker build -t server1 .
docker run --rm -p 8080:8080 -e WHO=Docker server1
```

## server2

Web server with a dependency.
The purpose of this app is to demo having to install a dependency in the
`Dockerfile`.

```bash
docker build -t server2 .
docker run --rm -p 8080:8080 server2
```

## server3

Web server with pre-build steps.
The purpose of this app is to recommend against compiling code as part of the
`docker build`.

```bash
gradle build
docker build -t server3 .
docker run --rm -p 8080:8080 -e WHO=Docker server3
```
