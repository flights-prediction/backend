package com.backend.aiplane.domain.flightInfo.domain;

import com.backend.aiplane.domain.airport.domain.QAirport;
import com.backend.aiplane.domain.flightInfo.application.dto.FlightInfoSearchDto;
import com.backend.aiplane.domain.route.domain.QRoute;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomFlightInfoRepositoryImpl implements CustomFlightInfoRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FlightInfo> findFlightInfosByCriteria(FlightInfoSearchDto dto) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QFlightInfo flightInfo = QFlightInfo.flightInfo;
        QRoute route = QRoute.route;
        QAirport departureAirport = QAirport.airport;

        BooleanBuilder where = new BooleanBuilder();

        if (dto.getDepartureCity() != null) {
            where.and(departureAirport.city.eq(dto.getDepartureCity()));
        }
        if (dto.getArriveCity() != null) {
            where.and(route.arriveAirport.city.eq(dto.getArriveCity()));
        }
        if (dto.getDepartureDate() != null) {
            where.and(flightInfo.departureDate.eq(dto.getDepartureDate()));
        }
        if (dto.getAirline() != null) {
            where.and(flightInfo.airline.eq(dto.getAirline()));
        }
        if (dto.getDepartureTime() != null) {
            where.and(flightInfo.departureTime.eq(dto.getDepartureTime()));
        }

        return queryFactory
                .selectFrom(flightInfo)
                .join(flightInfo.route, route)
                .join(route.departureAirport, departureAirport)
                .where(where)
                .fetch();
    }
}
