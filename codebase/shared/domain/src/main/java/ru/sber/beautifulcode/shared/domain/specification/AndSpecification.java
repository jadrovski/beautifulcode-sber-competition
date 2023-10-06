package ru.sber.beautifulcode.shared.domain.specification;

import java.util.HashSet;
import java.util.Set;

public class AndSpecification<C> extends AbstractSpecification<C> {

  private final Set<Specification<C>> set = new HashSet<>();

  public AndSpecification(Specification<C> a, Specification<C> b) {
    set.add(a);
    set.add(b);
  }

  public boolean isSatisfiedBy(C candidate) {
    for (Specification<C> s : set) {
      if (!s.isSatisfiedBy(candidate)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public AbstractSpecification<C> and(Specification<C> s) {
    set.add(s);
    return this;
  }

}
