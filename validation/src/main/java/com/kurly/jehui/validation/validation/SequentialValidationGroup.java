package com.kurly.jehui.validation.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import static com.kurly.jehui.validation.validation.SequentialValidationGroup.*;

@GroupSequence({Default.class, First.class, Second.class})
public interface SequentialValidationGroup {
  interface First {}
  interface Second {}
}
