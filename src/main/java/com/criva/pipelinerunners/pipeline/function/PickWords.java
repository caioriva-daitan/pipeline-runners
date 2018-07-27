package com.criva.pipelinerunners.pipeline.function;

import org.apache.beam.sdk.transforms.DoFn;

import java.util.stream.Stream;

public class PickWords extends DoFn<String, String> {

  @ProcessElement
  public void processElement(ProcessContext context) {
    String[] words = context.element().split("[^\\p{L}]+");

    Stream.of(words).filter(
        word -> !word.isEmpty()
    ).forEach(
        word -> {
          context.output(word);
        }
    );
  }
}
