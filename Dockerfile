FROM scratch

WORKDIR home/application

ADD shared-workspace/main /

ADD shared-workspace/profiles/ /src/github.com/sbagnallsta/flights-history-service/profiles/

EXPOSE 3200

CMD ["/main"]