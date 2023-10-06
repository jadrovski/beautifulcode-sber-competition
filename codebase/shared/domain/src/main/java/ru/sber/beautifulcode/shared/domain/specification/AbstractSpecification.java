package ru.sber.beautifulcode.shared.domain.specification;

public abstract class AbstractSpecification<C> implements Specification<C> {

  public abstract boolean isSatisfiedBy(C candidate);

  public AbstractSpecification<C> or(Specification<C> s) {
    return new OrSpecification<>(this, s);
  }

  public AbstractSpecification<C> and(Specification<C> s) {
    return new AndSpecification<>(this, s);
  }

  public AbstractSpecification<C> not() {
    return new NotSpecification<>(this);
  }

}
