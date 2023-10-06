package ru.sber.beautifulcode.shared.domain.specification;

import java.util.HashSet;
import java.util.Set;

public class OrSpecification<C> extends AbstractSpecification<C> {

  private final Set<Specification<C>> set = new HashSet<>();

  public OrSpecification(Specification<C> a, Specification<C> b) {
    set.add(a);
    set.add(b);
  }

  public boolean isSatisfiedBy(C candidate) {
    for (Specification<C> s : set) {
      if (s.isSatisfiedBy(candidate)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public AbstractSpecification<C> or(Specification<C> s) {
    set.add(s);
    return this;
  }

}
