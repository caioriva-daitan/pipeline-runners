package com.criva.pipelinerunners.pipeline.function;

import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

public class CountWords extends PTransform<PCollection<String>, PCollection<KV<String, Long>>> {

  @Override
  public PCollection<KV<String, Long>> expand(PCollection<String> input) {

    return input.apply(ParDo.of(new PickWords())).apply(Count.perElement());
  }
}
