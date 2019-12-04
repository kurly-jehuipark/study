package com.kurly.jehui.validation.member.web;

import javax.validation.Valid;
import java.util.Collection;

class NestedStruct {

  private Sample1 sample1;

  @Valid
  private Sample2 sample2;

  private Collection<@Valid Sample1> sample1Collection;

  public Sample1 getSample1() {
    return sample1;
  }

  public Sample2 getSample2() {
    return sample2;
  }

  public Collection<Sample1> getSample1Collection() {
    return sample1Collection;
  }
}
