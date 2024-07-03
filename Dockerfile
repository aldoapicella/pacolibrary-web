FROM ubuntu:latest
LABEL authors="aldoa"

ENTRYPOINT ["top", "-b"]