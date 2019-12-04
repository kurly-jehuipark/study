package com.kurly.jehui.validation.member.web;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoApi {


  @PostMapping("/sample1")
  public Sample1 sample1(@RequestBody @Validated Sample1 sample1) {
    return sample1;
  }

  @PutMapping("/sample2")
  public Sample2 sample2(@RequestBody @Validated Sample2 passwordChangeRequest) {
    return passwordChangeRequest;
  }

  @PostMapping("/nested")
  public NestedStruct nestedStruct(@RequestBody @Validated NestedStruct nestedStruct) {
    return nestedStruct;
  }

}
