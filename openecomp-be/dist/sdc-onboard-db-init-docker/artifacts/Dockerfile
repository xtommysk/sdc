FROM onap/base_sdc-cqlsh:1.7.0

COPY --chown=sdc:sdc init_keyspaces.cql /home/sdc/

COPY --chown=sdc:sdc init_schemas.cql /home/sdc/

COPY --chown=sdc:sdc alter_tables.cql /home/sdc/ 

COPY --chown=sdc:sdc startup.sh /home/sdc/ 

RUN chmod 770 /home/sdc/startup.sh

ENTRYPOINT [ "/home/sdc/startup.sh" ]
