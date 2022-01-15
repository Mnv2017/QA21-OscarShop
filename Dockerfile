FROM gradle:7.3.3-jdk11
RUN mkdir /srv/gradle
WORKDIR /srv/gradle
COPY * .gradle .idea ./
CMD ["gradle", "clean", "testSmoke1"]