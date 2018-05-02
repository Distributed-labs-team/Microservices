package com.pyshankov.microservices.statisticservice.repository;

import com.pyshankov.microservices.domain.Event;
import org.springframework.data.cassandra.repository.CassandraRepository;


/**
 * Created by valeriyartemenko on 02.05.18.
 */
public interface EventRepository extends CassandraRepository<Event>{

}
