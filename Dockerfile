# [alpine] sltx and texlive
FROM docker.io/eagleoutice/lithie-tx-full:latest

LABEL version="1.0" author="Florian Sihler"

# we do not care about caching
USER root
RUN apk add bash python3 make openjdk11
RUN ln -sf python3 /usr/bin/python

# sloppy rename for alpine; no perl-rename :C
COPY rename-fb /bin/rename
RUN chmod +x /bin/rename
USER lithie-user
RUN pip3 install --no-cache --upgrade pip
WORKDIR /root/data

ENTRYPOINT [ "make" ]
