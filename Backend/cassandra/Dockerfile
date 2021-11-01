FROM cassandra:3.11.10@sha256:9bebcaa655839d6e043163c4e40f45f17fd783ab09ba62ef6aaf1babf8c4d654
ENV MAX_HEAP_SIZE=256M
ENV HEAP_NEWSIZE=128M

VOLUME /data/cassandra /var/lib/cassandra

HEALTHCHECK --interval=5s --timeout=5s CMD cqlsh -e describe keyspaces

EXPOSE 9042