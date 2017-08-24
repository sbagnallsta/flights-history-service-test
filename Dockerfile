FROM scratch

WORKDIR home/application

ADD main /

ADD profiles/ /src/github.com/sbagnallsta/flights-history-service/profiles/

EXPOSE 3200

CMD ["/main"]