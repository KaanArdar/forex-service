package org.exchange.dao.repository;

import org.exchange.dao.entity.ExchangeTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface ExchangeTransactionRepository extends PagingAndSortingRepository<ExchangeTransaction, String> {

    Page<ExchangeTransaction> findAll(Specification<ExchangeTransaction> spec, Pageable pageable);

    static Specification<ExchangeTransaction> getSpec(String transactionId, Long transactionDate) {
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(transactionDate)) {
                predicates.add(cb.greaterThan(root.get("transactionDate"), Long.MIN_VALUE));
                predicates.add(cb.lessThan(root.get("transactionDate"), transactionDate));
            }

            if (Objects.nonNull(transactionId)) {
                predicates.add(cb.equal(root.get("id"), transactionId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

}
