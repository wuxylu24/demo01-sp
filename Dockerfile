# 多阶段构建：一次编译整个工程，再按 MODULE 取出对应服务的 jar
# 用法：docker build --build-arg MODULE=shp_auth -t shp-auth .
FROM maven:3.8.8-eclipse-temurin-8 AS builder
WORKDIR /build
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn -B -q -DskipTests package

FROM eclipse-temurin:8-jre
ARG MODULE
WORKDIR /app
COPY --from=builder /build/${MODULE}/target/*.jar app.jar
ENV TZ=Asia/Shanghai \
    JAVA_OPTS="-Xms256m -Xmx512m"
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]
