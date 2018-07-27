package com.criva.pipelinerunners.bigquery.model;

import com.google.api.services.bigquery.model.TableRow;
import org.apache.beam.sdk.transforms.DoFn;

import java.io.Serializable;

public interface BigQueryFieldFn<T> extends Serializable {

  Object apply(DoFn<T, TableRow>.ProcessContext context);
}
