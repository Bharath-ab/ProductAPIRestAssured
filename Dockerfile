#OS Base version
FROM ubuntu:22.04

MAINTAINER bharathvarma

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/pom.xml
COPY TestNg.xml /app/TestNg.xml
COPY configs /app/configs

#To update the packages
RUN apt update

#Install JDK 17
#RUN apt install openjdk-17-jdk -y
#ENV PATH=$PATH:/usr/lib/jvm/java-17-openjdk-amd64/bin

#Install wget utility
RUN apt install curl -y

#Install Maven


RUN mkdir /opt/maven
ARG MAVEN_VERSION=3.9.4
ARG USER_HOME_DIR="/root"
ARG BASE_URL=https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN curl -fL ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar zxv -C /opt/maven --strip-components=1


ENV MAVEN_HOME /opt/maven
ENV M2_HOME /opt/maven
ENV PATH="/opt/maven/bin:${PATH}"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

CMD ["sh", "runPhonexApi.sh" ]
