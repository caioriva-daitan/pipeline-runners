package com.criva.pipelinerunners.pipeline.function;

import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;

public class KeyValueToString extends SimpleFunction<KV<String, Long>, String> {

  @Override
  public String apply(KV<String, Long> input) {

    return input.getKey() + ": " + input.getValue();
  }
}
