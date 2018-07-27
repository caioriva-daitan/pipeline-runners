package com.criva.pipelinerunners.pipeline.util;

import com.criva.pipelinerunners.bigquery.model.BigQueryField;
import org.apache.beam.sdk.values.KV;

import java.util.HashMap;
import java.util.Map;

public class WordCountUtils {

  public static Map<String, BigQueryField<KV<String, Long>>> createWordCountTableFieldsMap() {
    Map<String, BigQueryField<KV<String, Long>>> map = new HashMap<>();

    map.put("word",
        new BigQueryField<KV<String, Long>>(
            "STRING",
            (c) -> c.element().getKey()));
    map.put("count",
        new BigQueryField<KV<String, Long>>(
            "INTEGER",
            (c) -> c.element().getValue()));
    return map;
  }
}
