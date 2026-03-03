FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY untitled/src/Calculator.java .

RUN javac Calculator.java

CMD ["java", "Calculator"]