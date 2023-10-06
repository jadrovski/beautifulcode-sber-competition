package ru.sber.beautifulcode.shared.domain.specification;

public interface Specification<C> {
  boolean isSatisfiedBy(C candidate);
}
