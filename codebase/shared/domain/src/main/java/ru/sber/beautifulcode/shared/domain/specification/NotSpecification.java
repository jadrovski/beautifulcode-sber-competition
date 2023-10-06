package ru.sber.beautifulcode.shared.domain.specification;

public class NotSpecification<C> extends AbstractSpecification<C> {

  private final Specification<C> spec;

  public NotSpecification(Specification<C> s) {
    this.spec = s;
  }

  @Override
  public boolean isSatisfiedBy(C candidate) {
    return !spec.isSatisfiedBy(candidate);
  }

}
